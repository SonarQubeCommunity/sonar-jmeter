/*
 * JMeter Report Client
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

package es.excentia.jmeter.report.client;

public class JMeterReportConst {

  public static final String REPORT_SERVER_PROPERTIES = "jmeter-report-server.properties";

  public static final String DEFAULT_HOST = "localhost";
  public static final int DEFAULT_PORT = 4444;

  public static final int RETURN_CODE_OK = Integer.MAX_VALUE;
  public static final int RETURN_CODE_ERROR = Integer.MIN_VALUE;

  public static final int OP_GET_AVALIABLE_CONFIGS = 1;
  public static final int OP_GET_AVALIABLE_METRICS = 2;
  public static final int OP_GET_BUCKET_MEASURES = 3;
  public static final int OP_GET_GLOBAL_SUMMARY = 4;

  public static final String METRIC_BUCKET_AVG_RESPONSE_TIME = "BucketAvgResponseTime";

  public static final String TEST_CONFIG_HTTP = "test-http";
  public static final String TEST_CONFIG_TRANS = "test-trans";
  public static final String TEST_CONFIG_TRANS_PLAIN = "test-trans-plain";
  public static final String TEST_CONFIG_TRANS_PLAIN_SHORT = "test-trans-plain-short";

  public static final String[] TEST_CONFIGS = new String[] { TEST_CONFIG_HTTP,
      TEST_CONFIG_TRANS, TEST_CONFIG_TRANS_PLAIN, TEST_CONFIG_TRANS_PLAIN_SHORT };

}
