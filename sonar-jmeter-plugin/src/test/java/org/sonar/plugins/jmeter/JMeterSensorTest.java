/*
 * Sonar JMeter Plugin
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

package org.sonar.plugins.jmeter;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.apache.commons.configuration.MapConfiguration;
import org.junit.Test;
import org.sonar.api.resources.Project;


public class JMeterSensorTest {

  JMeterSensor sensor = new JMeterSensor();
  
  @Test
  public void testLocalJtlPathConfig() {
    Map<String,String> configMap = new HashMap<String,String>();
    // cfillol: It doesn't mind what you set in LOCAL_JTL_PATH_PROPERTY, if you specify "test-http"
    // as config name, JMeterReportServer will analize this internal classpath file: /src/main/resources/test-http.jtl.xml
    // This is interesting when programming tests like this.
    configMap.put(JMeterPluginConst.LOCAL_JTL_PATH_PROPERTY, "/home/carlos/jmeter_work/iceweb.jtl");
    
    Project project = new Project("test-http-key","","test-http"); // Force "test-http" as config name
    project.setConfiguration(new MapConfiguration(configMap));
    
    Assert.assertNotNull(sensor.getGlobalSummary(project));
  }
  
}
