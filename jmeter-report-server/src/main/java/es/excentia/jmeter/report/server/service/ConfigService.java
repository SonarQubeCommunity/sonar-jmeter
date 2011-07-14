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

import es.excentia.jmeter.report.server.data.ConfigInfo;

public interface ConfigService extends Service {

  /**
   * Get test config info for the given test config name.
   */
  ConfigInfo getTestConfigInfo(String testConfigName);
  
  /**
   * From 0.2-SNAPSHOT, you can set test config properties programmatically and these ones have preferences over system properties and classpath
   * property files.
   */
  void setTestConfigInfo(String name, ConfigInfo configInfo);
  
  /**
   * Returns configured port or 4444 if property 'port' was not set
   */
  int getPort();
  
  /**
   * Returns configured max connections number or 0 if property 
   * 'maxConnections' was not set
   */
  public int getMaxConnections();
  
}
