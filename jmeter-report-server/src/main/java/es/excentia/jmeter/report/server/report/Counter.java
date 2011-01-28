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

public abstract class Counter extends ReportData {
	
	protected long total;
	protected long counter;
	
	protected void incrementTotal() { total++; }
	protected void incrementCounter() { counter++; }
	
	public long getTotal() {
		return total;
	}
	
	public long getCounter() {
		return counter;
	}
	
	public long getOpositeCounter() {
		long opositeCounter = getTotal() - counter;
		if (opositeCounter<=0) return 0;
		
		return opositeCounter;
	}
	
	public double getPercent() {
		if (counter==0) return 0;
		
		return (counter*100.0)/getTotal();
	}
	
	public double getOpositePercent() {
		long opositeCounter = getOpositeCounter();
		if (opositeCounter==0) return 0;
		
		return (opositeCounter*100.0)/getTotal();
	}

	@Override
	public String toString() {
		return getCounter() + " ("+Math.round(getPercent())+"%)";
	}
}
