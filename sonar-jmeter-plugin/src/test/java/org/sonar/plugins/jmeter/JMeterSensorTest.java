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

import es.excentia.jmeter.report.server.JMeterReportServer;


public class JMeterSensorTest {

  private JMeterSensor sensor = new JMeterSensor();
  
  private static final int SERVER_START_TIME = 2000;
  private static final int SERVER_STOP_TIME = 2000;

  
  @Test
  public void testLocalJtlPathConfig() {
    Map<String,String> configMap = new HashMap<String,String>();
    configMap.put(JMeterPluginConst.LOCAL_JTL_PATH_PROPERTY, "classpath:/test-http.jtl.xml");
    
    Project project = new Project("test-http-key","","test-http"); // Force "test-http" as config name
    project.setConfiguration(new MapConfiguration(configMap));
    
    Assert.assertNotNull(sensor.getGlobalSummary(project));
  }
  
  @Test
  public void testSkipWhenLocalJtlNotExists() {
    Map<String,String> configMap = new HashMap<String,String>();
    configMap.put(JMeterPluginConst.LOCAL_JTL_PATH_PROPERTY, "classpath:/notexistingpath/test.jtl.xml");
    
    Project project = new Project("mytestproject","","notexisting"); // Force "notexisting" as config name
    project.setConfiguration(new MapConfiguration(configMap));
    
    Assert.assertNull(sensor.getGlobalSummary(project));
  }
  
  
  @Test
  public void testSkipWhenRemoteJtlNotExists() {
  	
  	// Start jmeter report server.
  	// Testing plugin targeting remote jmeter report server, 
  	// then we need a running server.
  	JMeterReportServer server = new JMeterReportServer();
    server.start();
    try {
	    Thread.sleep(SERVER_START_TIME);
    } catch (InterruptedException e) {
    	// Server must be up at this point
    }
    
	  try {
	    	
	    Map<String,String> configMap = new HashMap<String,String>();
	    configMap.put(JMeterPluginConst.HOST_PROPERTY, "localhost");
	    configMap.put(JMeterPluginConst.CONFIG_PROPERTY, "A");
	    
	    Project project = new Project("mytestproject","","notexisting"); // Force "notexisting" as config name
	    project.setConfiguration(new MapConfiguration(configMap));
	    
	    Assert.assertNull(sensor.getGlobalSummary(project));
	    
    } finally {
    	
    	// Stop server at the end
    	server.stop();
      try {
	      Thread.sleep(SERVER_STOP_TIME);
      } catch (InterruptedException e) {
	      // Server must be stopped at this point
      }
      
    }
    
  }
  
  
}
