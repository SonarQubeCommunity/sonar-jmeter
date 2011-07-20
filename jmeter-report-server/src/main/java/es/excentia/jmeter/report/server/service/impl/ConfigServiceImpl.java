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

package es.excentia.jmeter.report.server.service.impl;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.excentia.jmeter.report.client.JMeterReportConst;
import es.excentia.jmeter.report.client.util.StringUtil;
import es.excentia.jmeter.report.server.data.ConfigInfo;
import es.excentia.jmeter.report.server.exception.ConfigException;
import es.excentia.jmeter.report.server.service.ConfigService;

/**
 * @author cfillol
 */
public class ConfigServiceImpl implements ConfigService {

  private static final Logger log = LoggerFactory.getLogger(ConfigServiceImpl.class);
  
  private static final String PORT_KEY = "port";
  private static final String MAX_CONNECTIONS_KEY = "maxConnections";


  /**
   * Load jmeter report server properties file from the classpath
   */
  protected static Properties getPropertiesFromClasspath() {
    Properties props = new Properties();

    String propsName = JMeterReportConst.REPORT_SERVER_PROPERTIES;
    URL url = ClassLoader.getSystemResource(propsName);
    if (url == null) {
      throw new ConfigException("Properties file '" + propsName + "' doesn't exist.");
    }

    try {
      props.load(url.openStream());
    } catch (IOException e) {
      throw new ConfigException("Cannot load properties file: " + propsName + "\nURL=" + url.toString(), e);
    }

    return props;
  }

  /**
   * Get configured property string value or null
   */
  protected static String getProperty(String key) {
    String value = null;

    // Properties from command line have preference
    Properties props = System.getProperties();
    if ( !props.contains(key)) {
      props = getPropertiesFromClasspath();
    }
    value = props.getProperty(key);
    return value;
  }

  /**
   * Get a positive or 0 integer value
   */
  public int getNaturalProperty(String key, int defaultValue) {
    int value = defaultValue;

    String strValue = getProperty(key);
    if (strValue == null) {
      log.debug(
          "No " + key + " configured. "+
          "Using default value " + defaultValue + "."
       );
    } else {
      try {
        value = Integer.parseInt(getProperty(key));
      } catch (NumberFormatException e) {
        log.warn("Could not parse " + key + ": " + e.getMessage());
      }
    }

    if (value < 0) {
      log.warn(
          "The value of " + key + " cannot be negative: " + value+ ". "+
          "Using default value " + defaultValue + "."
      );
      value = defaultValue;
    }

    return value;
  }

  
  private static final Map<String, ConfigInfo> inMemoryConfigs = new HashMap<String, ConfigInfo>();
  
  /* (non-Javadoc)
   * @see es.excentia.jmeter.report.server.service.ConfigService#getTestConfigInfo(java.lang.String)
   */
  public ConfigInfo getTestConfigInfo(String config) {

    String jtlPath;
    
    ConfigInfo memConfigInfo = inMemoryConfigs.get(config);
    if (memConfigInfo != null) {
      
      // Retrieve JTL file path from memory
      jtlPath = memConfigInfo.getJtlPath();
      
    } else {
      
      // Retrieve JTL file path from system property or properties file
      String jtlPathProp = "testconfig." + config + ".jtlpath";
      jtlPath = getProperty(jtlPathProp);
      if (jtlPath == null) {
        throw new ConfigException("There is no property " + jtlPathProp + " in " + JMeterReportConst.REPORT_SERVER_PROPERTIES);
      }
      
    }
    
    return new ConfigInfo(config, jtlPath);
    
  }
  
  /* (non-Javadoc)
   * @see es.excentia.jmeter.report.server.service.ConfigService#setTestConfigInfo(java.lang.String, es.excentia.jmeter.report.server.data.ConfigInfo)
   */
  public void setTestConfigInfo(String name, ConfigInfo configInfo) {

    if (StringUtil.isBlank(name)) {
      throw new ConfigException("Config must have a name");
    }

    if (configInfo != null) {
      configInfo.setName(name);

      String jtlPath = configInfo.getJtlPath();
      if (StringUtil.isBlank(jtlPath)) {
        throw new ConfigException("Config must have a jtl file path");
      }

      inMemoryConfigs.put(name, configInfo);

    } else {
      inMemoryConfigs.remove(name);
    }
  }
  
  
  /* (non-Javadoc)
   * @see es.excentia.jmeter.report.server.service.ConfigService#getPort()
   */
  public int getPort() {
    return getNaturalProperty(PORT_KEY, JMeterReportConst.DEFAULT_PORT);
  }
  
  /* (non-Javadoc)
   * @see es.excentia.jmeter.report.server.service.ConfigService#getMaxConnections()
   */
  public int getMaxConnections() {
    return getNaturalProperty(MAX_CONNECTIONS_KEY, JMeterReportConst.DEFAULT_MAX_CONNECTIONS);
  }

}
