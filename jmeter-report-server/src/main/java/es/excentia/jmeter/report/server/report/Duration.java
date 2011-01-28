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

import es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample;

public class Duration extends ReportData {
	
	private static final int MILLISECONDS_IN_ONE_MINUTE = 60000;
	
	protected long startTs = -1;
	protected long endTs = -1;
	
	public long getDuration() {
		return endTs - startTs;
	}
	
	public double getDurationInMinutes() {
		return ((double)(endTs - startTs))/MILLISECONDS_IN_ONE_MINUTE;
	}

	@Override
	public void addMeasure(AbstractSample sample) {
		long ts = sample.getTs();
		
		if (startTs==-1 || ts<startTs) {
			startTs = ts;
		}
		
		if (ts>endTs) {
			endTs = ts;
		}
	}
	
	@Override
	public String toString() {
		return Double.toString(getDurationInMinutes()) +" min.";
	}
	
}
