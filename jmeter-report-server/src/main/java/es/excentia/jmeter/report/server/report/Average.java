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
  protected double sumAvg;
  protected Double avg;
  protected double sumDev;

  protected void incrementTotal() {
    total++;
  }

  protected void addToAvg(double value) {
    sumAvg = sumAvg + value;
  }

  protected void addToDev(double value) {
    sumDev = sumDev + Math.pow(value - getAverage(), 2);
  }

  protected long getTotal() {
    if (getSummary().getActualPhaseIndex() >= Report.SECOND_PHASE) {
      return total;
    } else {
      throw new ReportException("El total aún no está disponible");
    }
  }

  public Double getAverage() {
    if (getSummary().getActualPhaseIndex() < Report.SECOND_PHASE) {
      throw new ReportException("La media aún no está disponible");
    }

    if (getTotal() <= 0) {
      return Double.NaN;
    }
    if (avg != null) {
      return avg;
    }

    avg = sumAvg / getTotal();
    return avg;
  }

  public double getDeviation() {
    // TODO cfillol: Comprobar que estamos en la tercera fase?
    if (getTotal() <= 0) {
      return Double.NaN;
    }
    return Math.sqrt(sumDev / (getTotal() - 1));
  }

  public double getDeviationPercent() {
    // TODO cfillol: Comprobar que estamos en la tercera fase?
    if (getTotal() <= 0) {
      return Double.NaN;
    }
    return (getDeviation() * 100.0) / getAverage();
  }

  @Override
  public String toString() {
    return getAverage() + " (dev. " + Math.round(getDeviationPercent()) + "%)";
  }
}
