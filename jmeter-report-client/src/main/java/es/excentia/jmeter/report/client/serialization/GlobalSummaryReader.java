/*
 * JMeter Report Client
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

package es.excentia.jmeter.report.client.serialization;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.excentia.jmeter.report.client.data.GlobalSummary;

public class GlobalSummaryReader extends ErrorCheckStreamReader<GlobalSummary> {

	protected DataInputStream dis;
	
	public GlobalSummaryReader(InputStream is) {
		super(is);
		dis = new DataInputStream(is);
	}

	@Override
	public GlobalSummary getObjectFromStream() throws IOException {
		GlobalSummary summary = new GlobalSummary();
		
		summary.setTestDesc(readString()); 
		summary.setUsersLogged(dis.readLong());
		summary.setTestDuration(dis.readLong());
		
		summary.setRequestsTotal(dis.readLong());
		summary.setRequestsOkTotal(dis.readLong());
		summary.setRequestsErrorTotal(dis.readLong());
		summary.setRequestsErrorPercent(dis.readDouble());
		
		summary.setRequestsOkPerMinute(dis.readDouble());
		summary.setRequestsOkPerMinuteAndUser(dis.readDouble());
		
		summary.setRequestsResponseTimeOkAvg(dis.readDouble());
		summary.setRequestsResponseTimeOkAvgDev(dis.readDouble());
		summary.setRequestsResponseTimeOkAvgDevPercent(dis.readDouble());
		
		summary.setRequestsBytesOkAvg(dis.readDouble());
		summary.setRequestsBytesOkAvgDev(dis.readDouble());
		summary.setRequestsBytesOkAvgDevPercent(dis.readDouble());
		
		summary.setTransTotal(dis.readLong());
		summary.setTransOkTotal(dis.readLong());
		summary.setTransErrorTotal(dis.readLong());	
		summary.setTransErrorPercent(dis.readDouble());
		
		summary.setTransOkPerMinute(dis.readDouble());
		summary.setTransOkPerMinuteAndUser(dis.readDouble());
		
		summary.setTransResponseTimeOkAvg(dis.readDouble());
		summary.setTransResponseTimeOkAvgDev(dis.readDouble());
		summary.setTransResponseTimeOkAvgDevPercent(dis.readDouble());
		
		summary.setTransBytesOkAvg(dis.readDouble());
		summary.setTransBytesOkAvgDev(dis.readDouble());
		summary.setTransBytesOkAvgDevPercent(dis.readDouble());
		
		summary.setSlowestTransName(readString());
		summary.setSlowestTransResponseTimeOkAvg(dis.readDouble());
		summary.setSlowestTransBytesOkAvgDevPercent(dis.readDouble());
		
		summary.setMostUnstableTransName(readString());			
		summary.setMostUnstableTransResponseTimeOkAvgDevPercent(dis.readDouble());
		summary.setMostUnstableTransBytesOkAvgDevPercent(dis.readDouble());	
		
		summary.setTransOrder(readStringList());
		summary.setTransMapOkTotal(readTransMapLong());
		summary.setTransMapErrorTotal(readTransMapLong());
		
		summary.setTransMapResponseTimeOkAvg(readTransMapDouble());
		summary.setTransMapResponseTimeOkAvgDev(readTransMapDouble());
		summary.setTransMapResponseTimeOkAvgDevPercent(readTransMapDouble());
		
		summary.setTransMapBytesOkAvg(readTransMapDouble());
		summary.setTransMapBytesOkAvgDev(readTransMapDouble());
		summary.setTransMapBytesOkAvgDevPercent(readTransMapDouble());
		
		return summary;
	}
	
	protected String readString() throws IOException {
		boolean isNull = dis.readBoolean();
		return isNull? null : dis.readUTF();
	}
	
	protected List<String> readStringList() throws IOException {
		int size = dis.readInt();
		List<String> list = new ArrayList<String>();
		for (int i=0; i<size; i++) {
			list.add(dis.readUTF());
		}
		return list;
	}
	
	protected Map<String,Long> readTransMapLong() throws IOException {
		int size = dis.readInt();
		Map<String,Long> map = new HashMap<String,Long>();
		for (int i=0; i<size; i++) {
			map.put(dis.readUTF(), dis.readLong());
		}
		return map;
	}
	
	protected Map<String,Double> readTransMapDouble() throws IOException {
		int size = dis.readInt();
		Map<String,Double> map = new HashMap<String,Double>();
		for (int i=0; i<size; i++) {
			map.put(dis.readUTF(), dis.readDouble());
		}
		return map;
	}
	
}
