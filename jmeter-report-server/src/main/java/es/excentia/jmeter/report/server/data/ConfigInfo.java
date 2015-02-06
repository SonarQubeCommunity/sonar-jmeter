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

package es.excentia.jmeter.report.server.data;

import es.excentia.jmeter.report.client.JMeterReportConst;


public class ConfigInfo {

  private String name;
  private String jtlPath;
  private int growingJtlWaitTime = JMeterReportConst.DEFAULT_GROWING_JTL_WAIT_TIME;
  
  public ConfigInfo() { }
  public ConfigInfo(String jtlPath) {
    this.jtlPath = jtlPath;
  }
  public ConfigInfo(String name, String jtlPath) {
    this.name = name;
    this.jtlPath = jtlPath;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public String getJtlPath() {
    return jtlPath;
  }
  public void setJtlPath(String jtlPath) {
    this.jtlPath = jtlPath;
  }
  
  /**
   * Seconds that jmeter server will wait when is near of jtl end
   * to check if a the jtl grows, and so, if has to read more.
   * 
   * If bigger than 0, jmeter server will be able to read JTL growing files 
   * when jmeter test is running. If 0, this feature will be disabled.
   * 
   * This feature will be only available for java 1.6 and later. 
   */
  public int getGrowingJtlWaitTime() {
    return growingJtlWaitTime;
  }
  public void setGrowingJtlWaitTime(int growingJtlWaitTime) {
    this.growingJtlWaitTime = growingJtlWaitTime;
  }
  
}
