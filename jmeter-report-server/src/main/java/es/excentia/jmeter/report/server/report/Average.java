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

public abstract class Average extends ReportData {

  protected long total;
  protected double valuesSum;
  
  /*
    stddev = sqr ( devSum / (total - 1) )
    devSum = sum(v_i - avg)²
    devSum = (v_1 - avg)² + (v_2 - avg)² + ...
    devSum = (v_1 - avg)*(v_1 - avg) + (v_2 - avg)*(v_2 - avg) + ...
    devSum = v_1² + avg² - 2*v_1*avg + v_2² + avg² - 2*v_2*avg + ...
    devSum = (v_1² + v_2² + ... ) - 2*avg*(v_1 + v_2 + ...) + total*avg²
    devSum = squaresSum - 2*avg*valuesSum + total*avg²
    stddev = sqr ( (squaresSum - 2*avg*valuesSum + total*avg²) / (total - 1) )
  */
  protected double squaresSum;
  
  protected void incrementTotal() {
    total++;
  }

  protected void addToAvg(double value) {
    valuesSum = valuesSum + value;
  }

  protected void addToDev(double value) {
    squaresSum = squaresSum + value*value;
  }

  public Double getAverage() {
    if (total <= 0) {
      return Double.NaN;
    }
    return valuesSum/total;
  }

  public double getDeviation() {
    if (total <= 0) {
      return Double.NaN;
    }
    Double avg = getAverage();
    return Math.sqrt((squaresSum - 2*avg*valuesSum + total*avg*avg) / (total - 1));
  }

  public double getDeviationPercent() {
    if (total <= 0) {
      return Double.NaN;
    }
    return (getDeviation() * 100.0) / getAverage();
  }

  @Override
  public String toString() {
    return getAverage() + " (dev. " + Math.round(getDeviationPercent()) + "%)";
  }
}
