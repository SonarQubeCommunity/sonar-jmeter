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

package es.excentia.jmeter.report.server;


public class JMeterReportServerTestConst {

  public static final String TEST_CONFIG_HTTP = "test-http";
  public static final String TEST_CONFIG_TRANS = "test-trans";
  public static final String TEST_CONFIG_NESTED_TRANS = "test-nested-trans";
  public static final String TEST_CONFIG_HTTP_FULL = "test-http-full";
  public static final String TEST_CONFIG_TRANS_FULL_25 = "test-trans-full-25";
  public static final String TEST_CONFIG_TRANS_FULL_27 = "test-trans-full-27";
  public static final String TEST_CONFIG_TRANS_PLAIN = "test-trans-plain";
  public static final String TEST_CONFIG_TRANS_PLAIN_SHORT = "test-trans-plain-short";
  public static final String TEST_CONFIG_JMS = "test-jms";
  
  public static final String[] TEST_CONFIGS = new String[] { 
    TEST_CONFIG_HTTP, TEST_CONFIG_TRANS, TEST_CONFIG_NESTED_TRANS,
    TEST_CONFIG_HTTP_FULL, TEST_CONFIG_TRANS_FULL_25, 
    TEST_CONFIG_TRANS_FULL_27, TEST_CONFIG_TRANS_PLAIN, 
    TEST_CONFIG_TRANS_PLAIN_SHORT, TEST_CONFIG_JMS
  };
  
}
