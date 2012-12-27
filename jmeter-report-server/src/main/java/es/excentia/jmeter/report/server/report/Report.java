/*
 * JMeter Report Server
 * Copyright (C) 2010 eXcentia
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */

package es.excentia.jmeter.report.server.report;

import java.util.HashMap;
import java.util.Map;

import es.excentia.jmeter.report.client.serialization.StreamReader;
import es.excentia.jmeter.report.server.service.ReaderService;
import es.excentia.jmeter.report.server.service.ServiceFactory;
import es.excentia.jmeter.report.server.testresults.SampleMix;
import es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample;
import es.excentia.jmeter.report.server.testresults.xmlbeans.Sample;

@SuppressWarnings("unchecked")
public class Report {

  public static final int SCOPE_REQUEST_GLOBAL = 1;
  public static final int SCOPE_TRANS_GLOBAL = 2;
  public static final int SCOPE_TRANS_TYPE = 3;
  public static final int SCOPE_ALL = 4;

  protected ReaderService readerService = ServiceFactory.get(ReaderService.class);

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

  Map<String, Class<?>> requestGlobalDataClasses = new HashMap<String, Class<?>>();
  Map<String, Class<?>> transGlobalDataClasses = new HashMap<String, Class<?>>();
  Map<String, Class<?>> transTypeDataClasses = new HashMap<String, Class<?>>();

  Map<String, ReportData> requestGlobalData = new HashMap<String, ReportData>();
  Map<String, ReportData> transGlobalData = new HashMap<String, ReportData>();
  Map<String, Map<String, ReportData>> transTypeData = new HashMap<String, Map<String,ReportData>>();

  public <T extends ReportData> void addData(Class<T> clazz, int scope) {

    if (scope == SCOPE_ALL) {
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
        // case SCOPE_REQUEST_GLOBAL:
      default:
        requestGlobalDataClasses.put(clazz.getSimpleName(), clazz);
        break;
    }
  }

  public <T extends ReportData> T getDataRequestGlobal(Class<T> clazz) {
    return (T) requestGlobalData.get(clazz.getSimpleName());
  }

  public <T extends ReportData> T getDataTransGlobal(Class<T> clazz) {
    return (T) transGlobalData.get(clazz.getSimpleName());
  }

  public <T extends ReportData> Map<String, T> getDataTransType(Class<T> clazz) {
    return (Map<String, T>) transTypeData.get(clazz.getSimpleName());
  }

  private boolean isInitialized = false;
  public boolean isInitialized() {
    return isInitialized;
  }

  public void init() {
    isInitialized = false;
    actualTransName = null;

    okUserAccessCounter = (OkUserAccessCounter) createSummaryData(OkUserAccessCounter.class);
    testDuration = (Duration) createSummaryData(Duration.class);

    for (String dataName : requestGlobalDataClasses.keySet()) {
      Class<?> dataClass = requestGlobalDataClasses.get(dataName);
      ReportData data = createSummaryData(dataClass);
      requestGlobalData.put(dataName, data);
    }

    for (String dataName : transGlobalDataClasses.keySet()) {
      Class<?> dataClass = transGlobalDataClasses.get(dataName);
      ReportData data = createSummaryData(dataClass);
      transGlobalData.put(dataName, data);
    }

    for (String dataName : transTypeDataClasses.keySet()) {
      Map<String, ReportData> transDataMap = new HashMap<String, ReportData>();
      transTypeData.put(dataName, transDataMap);
    }
    
    isInitialized = true;
  }

  public void extract(StreamReader<SampleMix> reader) {

    init();
    SampleMix sampleMix = reader.read();

    while (sampleMix != null) {

      // Analyze requests
      for (HttpSample request : sampleMix.getHttpSamples()) {
        testDuration.addMeasure(request);
        okUserAccessCounter.addMeasure(request);

        for (String dataName : requestGlobalData.keySet()) {
          ReportData data = requestGlobalData.get(dataName);
          data.addMeasure(request);
        }
      }

      // Analyze transactions
      for (Sample trans : sampleMix.getTransactions()) {
        actualTransName = trans.getLb();

        for (String dataName : transGlobalData.keySet()) {
          ReportData data = transGlobalData.get(dataName);
          data.addMeasure(trans);
        }

        for (String dataName : transTypeData.keySet()) {
          Map<String, ReportData> transDataMap = transTypeData
                                                               .get(dataName);

          ReportData data = transDataMap.get(actualTransName);
          if (data == null) {
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


  }

  protected ReportData createSummaryData(Class<?> summaryDataClass) {

    ReportData data;
    try {
      data = (ReportData) summaryDataClass.getConstructors()[0].newInstance(new Object[] {});
    } catch (Exception e) {
      throw new ReportException(e);
    }

    data.setSummary(this);

    return data;
  }


  @Override
  public String toString() {
    StringBuffer buff = new StringBuffer();

    buff.append("\n** Request Global Scope **");
    for (int phase = 0; phase < 2; phase++) {
      buff.append('\n');
      buff.append(requestGlobalData.toString());
    }

    buff.append("\n\n** Transaction Global Scope **");
    for (int phase = 0; phase < 2; phase++) {
      buff.append('\n');
      buff.append(transGlobalData.toString());
    }

    buff.append("\n\n** Transaction Type Scope **");
    for (int phase = 0; phase < 2; phase++) {
      buff.append('\n');
      buff.append(transTypeData.toString());
    }

    buff.append('\n');

    return buff.toString();
  }
}