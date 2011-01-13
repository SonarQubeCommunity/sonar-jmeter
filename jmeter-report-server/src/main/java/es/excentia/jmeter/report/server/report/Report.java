/*
 * JMeter Report Server
 * Copyright (C) 2010 eXcentia
 * mailto:info AT excentia DOT es
 *
 * SONAR JMeter Plugin is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * SONAR JMeter Plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */

package es.excentia.jmeter.report.server.report;

import java.util.HashMap;
import java.util.Map;

import es.excentia.jmeter.report.client.serialization.StreamReader;
import es.excentia.jmeter.report.server.service.ConfigService;
import es.excentia.jmeter.report.server.service.ServiceFactory;
import es.excentia.jmeter.report.server.testresults.SampleMix;
import es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample;
import es.excentia.jmeter.report.server.testresults.xmlbeans.Sample;

@SuppressWarnings("unchecked")
public class Report {

	
	/** 
	 * Dos fases: En la primera pasada obtendremos la media y la mayoría 
	 * de los datos y en la segunda obtendremos las desviaciones típicas
	 */
	int actualPhaseIndex;
	int getActualPhaseIndex() {
		return actualPhaseIndex;
	}
	
	public static final int FIRST_PHASE = 0;
	public static final int SECOND_PHASE = 1;
	
	
	public static final int SCOPE_REQUEST_GLOBAL = 1;
	public static final int SCOPE_TRANS_GLOBAL = 2;
	public static final int SCOPE_TRANS_TYPE = 3;
	public static final int SCOPE_ALL = 4;
	
	ConfigService configService = ServiceFactory.get(ConfigService.class);
	
	
	OkUserAccessCounter okUserAccessCounter;
	public long getNumUsersLogged() {
		return okUserAccessCounter.getDistictUsersCount();
	}

	Duration testDuration;
	public long getTestDuration() {
		return testDuration.getDuration();
	}
	
	public double getTestDurationInMinutes() {
		return testDuration.getDurationInMinutes();
	}

	String actualTransName;
	String getActualTransName() {
		return actualTransName;
	}

	Map<String,Class<?>> requestGlobalDataClasses = new HashMap<String, Class<?>>();
	Map<String,Class<?>> transGlobalDataClasses = new HashMap<String, Class<?>>();
	Map<String,Class<?>> transTypeDataClasses = new HashMap<String, Class<?>>();

	
	Map<String,ReportData>[] requestGlobalData = new Map[2];
	Map<String,ReportData>[] transGlobalData = new Map[2];
	Map<String,Map<String,ReportData>>[] transTypeData = new Map[2];
	

	public <T extends ReportData> void addData(Class<T> clazz, int scope) {
		
		if (scope==SCOPE_ALL){
			requestGlobalDataClasses.put(clazz.getSimpleName(), clazz);
			transGlobalDataClasses.put(clazz.getSimpleName(), clazz);
			transTypeDataClasses.put(clazz.getSimpleName(), clazz);
			return;
		}
		
		switch (scope) {
		case SCOPE_TRANS_GLOBAL: 
			transGlobalDataClasses.put(clazz.getSimpleName(), clazz);
			break;
		case SCOPE_TRANS_TYPE:
			transTypeDataClasses.put(clazz.getSimpleName(), clazz);
			break;	
		//case SCOPE_REQUEST_GLOBAL:
		default:
			requestGlobalDataClasses.put(clazz.getSimpleName(), clazz);
			break;
		}
	}
	
	public <T extends ReportData> T getDataRequestGlobal(Class<T> clazz) {
		int phase = getPhasesByClass(clazz)[0];
		return (T)requestGlobalData[phase].get(clazz.getSimpleName());
	}
	
	public <T extends ReportData> T getDataTransGlobal(Class<T> clazz) {
		int phase = getPhasesByClass(clazz)[0];
		return (T)transGlobalData[phase].get(clazz.getSimpleName());
	}
	
	public <T extends ReportData> Map<String,T> getDataTransType(Class<T> clazz) {
		int phase = getPhasesByClass(clazz)[0];
		return (Map<String,T>)transTypeData[phase].get(clazz.getSimpleName());
	}
	
	public void init() {
		actualPhaseIndex = 0;
		actualTransName = null;
		
		okUserAccessCounter = (OkUserAccessCounter)createSummaryData(OkUserAccessCounter.class);
		testDuration = (Duration)createSummaryData(Duration.class);
		
		for (int phase=0; phase<2; phase++) {
			requestGlobalData[phase] = new HashMap<String, ReportData>();
			transGlobalData[phase] = new HashMap<String, ReportData>();
			transTypeData[phase] = new HashMap<String,Map<String,ReportData>>();
		}
		
		for (String dataName : requestGlobalDataClasses.keySet()) {
			Class<?> dataClass = requestGlobalDataClasses.get(dataName);
			int phases[] = getPhasesByClass(dataClass);
			ReportData data = createSummaryData(dataClass);
			for (int phase : phases) {
				requestGlobalData[phase].put(dataName, data);
			}
		}
		
		for (String dataName : transGlobalDataClasses.keySet()) {
			Class<?> dataClass = transGlobalDataClasses.get(dataName);
			int phases[] = getPhasesByClass(dataClass);
			ReportData data = createSummaryData(dataClass);
			for (int phase : phases) {
				transGlobalData[phase].put(dataName, data);
			}
		}
	
		for (String dataName : transTypeDataClasses.keySet()) {
			Class<?> dataClass = transTypeDataClasses.get(dataName);
			int phases[] = getPhasesByClass(dataClass);
			Map<String,ReportData> transDataMap = new HashMap<String, ReportData>();
			for (int phase : phases) {
				transTypeData[phase].put(dataName, transDataMap);
			}
		}
	}
	
	public void extract(String config) {
		
		init();
		StreamReader<SampleMix> reader;
	
		for (int phase=FIRST_PHASE; phase<=SECOND_PHASE; phase++) {
			
			reader = configService.getSampleMixReaderByConfig(config);
			SampleMix sampleMix = reader.read();
			
			while (sampleMix!=null) {
				
				// Analizamos requests
				for (HttpSample request : sampleMix.getHttpSamples()) {
					if (phase==FIRST_PHASE) {
						testDuration.addMeasure(request);
						okUserAccessCounter.addMeasure(request);
					}
					
					for (String dataName : requestGlobalData[phase].keySet()) {
						ReportData data = requestGlobalData[phase].get(dataName);
						data.addMeasure(request);
					}
				}
				
				// Analizamos transacciones
				for (Sample trans : sampleMix.getTransactions()) {
					actualTransName = trans.getLb();
					
					for (String dataName : transGlobalData[phase].keySet()) {
						ReportData data = transGlobalData[phase].get(dataName);
						data.addMeasure(trans);
					}
					
					for (String dataName : transTypeData[phase].keySet()) {		
						Map<String,ReportData> transDataMap = transTypeData[phase].get(dataName);
		
						ReportData data = transDataMap.get(actualTransName);
						if (data==null) {
							Class<?> summaryDataClass = transTypeDataClasses.get(dataName);
							data = createSummaryData(summaryDataClass);
							transDataMap.put(actualTransName, data);
						}
						
						data.addMeasure(trans);
					}
					
				}
				
				actualTransName = null;
				sampleMix = reader.read();
			}
			
			actualPhaseIndex++;
		}
		
	}
	
	protected ReportData createSummaryData(Class<?> summaryDataClass) {
		
		ReportData data;
		try {
			data = (ReportData) summaryDataClass
					.getConstructors()[0]
					.newInstance(new Object[] {});
		} catch (Exception e) {
			throw new ReportException(e);
		}
		
		data.setSummary(this);
		
		return data;
	}
	
	protected int[] getPhasesByClass(Class<?> dataClass) {
		if (Average.class.isAssignableFrom(dataClass)) {
			return new int[] { FIRST_PHASE, SECOND_PHASE };
		} else {
			return new int[] { FIRST_PHASE };
		}
	}
	
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		
		buff.append("\n** Request Global Scope **");
		for (int phase=0; phase<2; phase++) {
			buff.append('\n');
			buff.append(requestGlobalData[phase].toString());
		}
		
		buff.append("\n\n** Transaction Global Scope **");
		for (int phase=0; phase<2; phase++) {
			buff.append('\n');
			buff.append(transGlobalData[phase].toString());
		}
		
		buff.append("\n\n** Transaction Type Scope **");
		for (int phase=0; phase<2; phase++) {
			buff.append('\n');
			buff.append(transTypeData[phase].toString());
		}
		
		buff.append('\n');
		
		return buff.toString();
	}
}