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

import org.junit.Assert;
import org.junit.Test;

public class ConfigServiceTest {

  protected ConfigService configService = ServiceFactory
      .get(ConfigService.class);

  @Test
  public void testLoadJTLConfigAFileNotFound() {
    boolean error = false;

    try {
      configService.getAbstractSampleReaderByConfig("A");
    } catch (Exception e) {
      error = true;
      Assert.assertTrue(e.getMessage().startsWith("JTL file defined"));
    }

    Assert.assertTrue(error);
  }

}
