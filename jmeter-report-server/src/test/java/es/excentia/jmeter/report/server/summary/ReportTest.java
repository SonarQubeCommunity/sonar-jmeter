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

package es.excentia.jmeter.report.server.summary;

import org.junit.Test;

import es.excentia.jmeter.report.client.JMeterReportConst;
import es.excentia.jmeter.report.server.report.OkBytesAverage;
import es.excentia.jmeter.report.server.report.OkCounter;
import es.excentia.jmeter.report.server.report.OkResponseTimeAverage;
import es.excentia.jmeter.report.server.report.Report;
import es.excentia.jmeter.report.server.report.TransOrder;

public class ReportTest {

  @Test
  public void testReport() {

    Report report = new Report();

    report.addData(OkCounter.class, Report.SCOPE_ALL);
    report.addData(OkResponseTimeAverage.class, Report.SCOPE_ALL);
    report.addData(OkBytesAverage.class, Report.SCOPE_ALL);
    report.addData(TransOrder.class, Report.SCOPE_TRANS_GLOBAL);
    report.extract(JMeterReportConst.TEST_CONFIG_TRANS);

    System.out.print(report.toString());
  }
}
