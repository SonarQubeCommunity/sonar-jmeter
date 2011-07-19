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

package es.excentia.jmeter.report.server.service;

import org.junit.Test;

import es.excentia.jmeter.report.server.JMeterReportServerTestConst;

public class OperationServiceTest {

  protected OperationService operationService = ServiceFactory
      .get(OperationService.class);

  @Test
  public void testWriteBucketMetrics() {
    operationService.writeBucketMeasures(System.out,
        JMeterReportServerTestConst.TEST_CONFIG_TRANS, "BucketAvgResponseTime", 500);
  }

}
