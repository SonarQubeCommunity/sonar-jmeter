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

public abstract class TransMapSimplifier<TReportData,TValue> {

	Map<String,TReportData> origMap;
	
	public TransMapSimplifier() { }
	public TransMapSimplifier(Map<String,TReportData> origMap) {
		this.origMap = origMap;
	}

	public final Map<String,TValue> toSimpleMap() {
		return toSimpleMap(origMap);
	}
	
	public final Map<String,TValue> toSimpleMap(Map<String,TReportData> origMap) {
		Map<String,TValue> simpleMap = new HashMap<String,TValue>();
		for (String key : origMap.keySet()) {
			TValue value = reportDataToValue(origMap.get(key));
			if (!isNullOrNaNNumber(value)) {
				simpleMap.put(key, value);
			}
		}
		return simpleMap;
	}
	
	protected abstract TValue reportDataToValue(TReportData data);
	
	protected boolean isNullOrNaNNumber(TValue value) {
		
		if (value==null) return true;
		if (value instanceof Double && (value==null || ((Double)value).isNaN())) {
			return true;
		}
		if (value instanceof Float && (value==null || ((Float)value).isNaN())) {
			return true;
		}
		
		return false;
	}
	
}
