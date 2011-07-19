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

package es.excentia.jmeter.report.server.testresults;

import java.io.InputStream;

import junit.framework.Assert;

import org.junit.Test;

import es.excentia.jmeter.report.server.JMeterReportServerTestConst;
import es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample;

public class JtlReaderTest {

  @Test
  public void testReadJtlFile() throws Exception {
    for (String config : JMeterReportServerTestConst.TEST_CONFIGS) {
      InputStream is = getClass()
          .getResourceAsStream("/" + config + ".jtl.xml");
      Assert.assertNotNull("No se encontró en el classpath " + config
          + ".jtl.xml", is);

      JtlAbstractSampleReader jtlReader = new JtlAbstractSampleReader(is);
      AbstractSample sample = jtlReader.read();
      while (sample != null) {
        Assert.assertTrue(sample.getTs() > -1);
        sample = jtlReader.read();
      }
    }
  }
}
