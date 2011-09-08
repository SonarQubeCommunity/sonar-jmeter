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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.excentia.jmeter.report.client.JMeterReportClient;
import es.excentia.jmeter.report.client.JMeterReportConst;
import es.excentia.jmeter.report.client.data.GlobalSummary;
import es.excentia.jmeter.report.client.data.Measure;
import es.excentia.jmeter.report.client.serialization.StreamReader;
import es.excentia.jmeter.report.server.data.ConfigInfo;
import es.excentia.jmeter.report.server.exception.ConfigException;
import es.excentia.jmeter.report.server.service.ConfigService;
import es.excentia.jmeter.report.server.service.ServiceFactory;

public class JMeterReportServerTest {

  private static final Logger log = LoggerFactory.getLogger(JMeterReportClient.class);

  private static final String LOCALHOST = "127.0.0.1";
  private static final double MARGEN = 0.01;
  private static final int SERVER_START_TIME = 2000;
  private static final int SERVER_STOP_TIME = 2000;

  ConfigService configService = ServiceFactory.get(ConfigService.class);
  
  JMeterReportServer server;
  JMeterReportClient client;

  @Before
  public void before() throws InterruptedException {
    client = new JMeterReportClient(LOCALHOST, configService.getPort());
    server = new JMeterReportServer();
    server.start();

    Thread.sleep(SERVER_START_TIME);
  }

  @After
  public void after() throws InterruptedException {
    server.stop();
    Thread.sleep(SERVER_STOP_TIME);
  }

  @Test
  public void testMemoryConfig() {
    log.info("** TEST testMemoryConfig ");

    Exception error = null;
    try {
      configService.setTestConfigInfo("myMemoryConfig", new ConfigInfo(null));
    } catch (ConfigException e) {
      error = e;
    }
    Assert.assertNotNull(error);
    
    
    ConfigInfo myMemoryConfig = new ConfigInfo("myMemoryConfig", "classpath:/test-trans-plain-short.jtl.xml");
    
    error = null;
    try {
      configService.setTestConfigInfo(null, myMemoryConfig);
    } catch (ConfigException e) {
      error = e;
    }
    Assert.assertNotNull(error);
    
    configService.setTestConfigInfo("myMemoryConfig", myMemoryConfig);
    Assert.assertNotNull(configService.getTestConfigInfo("myMemoryConfig"));
    client.getGlobalSummary("myMemoryConfig");
    
    
    error = null;
    try {
      configService.getTestConfigInfo("notExistingConfig");
    } catch (ConfigException e) {
      error = e;
    }
    Assert.assertNotNull(error);
  }
  
  @Test
  public void testNotExistingConfig() {
    log.info("** TEST testNotExistingConfig ");

    Exception error = null;
    try {
      configService.getTestConfigInfo("notExistingConfig");
    } catch (ConfigException e) {
      error = e;
    }
    Assert.assertNotNull(error);
  }
  
  @Test
  public void testIntegrationGetGlobalSummaryHttp() {
    log.info("** TEST testIntegrationGetGlobalSummaryHttp "
        + JMeterReportServerTestConst.TEST_CONFIG_HTTP);
    GlobalSummary summary = client
        .getGlobalSummary(JMeterReportServerTestConst.TEST_CONFIG_HTTP);
    log.debug(summary.toString());

    Assert.assertEquals(2735, summary.getRequestsTotal());
    Assert.assertEquals(1570, summary.getRequestsOkTotal());
    Assert.assertEquals(1165, summary.getRequestsErrorTotal());
    Assert.assertEquals(42.59, summary.getRequestsErrorPercent(), MARGEN);
    Assert.assertEquals(32.76, summary.getRequestsOkPerMinute(), MARGEN);
    Assert.assertEquals(148.18, summary
        .getRequestsResponseTimeOkAvgDevPercent(), MARGEN);

    Assert.assertEquals(0, summary.getTransTotal());
  }

  @Test
  public void testIntegrationGetGlobalSummaryHttpFull() {
    log.info("** TEST testIntegrationGetGlobalSummaryHttpFull "
        + JMeterReportServerTestConst.TEST_CONFIG_HTTP_FULL);
    GlobalSummary summary = client
        .getGlobalSummary(JMeterReportServerTestConst.TEST_CONFIG_HTTP_FULL);
    log.debug(summary.toString());

    /*
    Assert.assertEquals(352, summary.getRequestsTotal());
    Assert.assertEquals(344, summary.getRequestsOkTotal());
    Assert.assertEquals(8, summary.getRequestsErrorTotal());
    Assert.assertEquals(2.27, summary.getRequestsErrorPercent(), MARGEN);
    Assert.assertEquals(346.00, summary.getRequestsOkPerMinute(), MARGEN);
    Assert.assertEquals(19.31, summary.getRequestsResponseTimeOkAvg(), MARGEN);
    Assert.assertEquals(58.81, summary.getRequestsResponseTimeOkAvgDev(),
        MARGEN);

    Assert.assertEquals(165.83, summary.getTransResponseTimeOkAvg(), MARGEN);
    Assert.assertEquals(227.57, summary.getTransResponseTimeOkAvgDev(), MARGEN);
    Assert.assertEquals(137.23, summary.getTransResponseTimeOkAvgDevPercent(),
        MARGEN);

    double homeErrorTotal = summary.getTransMapErrorTotal().get("HOME");
    Assert.assertEquals(8.0, homeErrorTotal, MARGEN);

    double detalleCentroDevPerc = summary
        .getTransMapResponseTimeOkAvgDevPercent().get("DETALLE_CENTRO");
    Assert.assertEquals(67.82, detalleCentroDevPerc, MARGEN);
    */
  }
  
  @Test
  public void testIntegrationGetGlobalSummaryTrans() {
    log.info("** TEST testIntegrationGetGlobalSummaryTrans "
        + JMeterReportServerTestConst.TEST_CONFIG_TRANS);
    GlobalSummary summary = client
        .getGlobalSummary(JMeterReportServerTestConst.TEST_CONFIG_TRANS);
    log.debug(summary.toString());

    Assert.assertEquals(288, summary.getRequestsTotal());
    Assert.assertEquals(283, summary.getRequestsOkTotal());
    Assert.assertEquals(5, summary.getRequestsErrorTotal());
    Assert.assertEquals(1.74, summary.getRequestsErrorPercent(), MARGEN);
    Assert.assertEquals(16.18, summary.getRequestsOkPerMinute(), MARGEN);
    Assert.assertEquals(19.94, summary.getRequestsResponseTimeOkAvg(), MARGEN);
    Assert.assertEquals(34.77, summary.getRequestsResponseTimeOkAvgDev(),
        MARGEN);

    Assert.assertEquals(76.37, summary.getTransResponseTimeOkAvg(), MARGEN);
    Assert.assertEquals(99.69, summary.getTransResponseTimeOkAvgDev(), MARGEN);
    Assert.assertEquals(130.53, summary.getTransResponseTimeOkAvgDevPercent(),
        MARGEN);

    double homeTimeAvg = summary.getTransMapResponseTimeOkAvgDevPercent().get(
        "TR_HOME");
    Assert.assertEquals(30.15, homeTimeAvg, MARGEN);
  }

  @Test
  public void testIntegrationGetGlobalSummaryTransFull25() {
    log.info("** TEST testIntegrationGetGlobalSummaryTransFull25 "
        + JMeterReportServerTestConst.TEST_CONFIG_TRANS_FULL_25);
    GlobalSummary summary = client
        .getGlobalSummary(JMeterReportServerTestConst.TEST_CONFIG_TRANS_FULL_25);
    log.debug(summary.toString());

    /*
    Assert.assertEquals(352, summary.getRequestsTotal());
    Assert.assertEquals(344, summary.getRequestsOkTotal());
    Assert.assertEquals(8, summary.getRequestsErrorTotal());
    Assert.assertEquals(2.27, summary.getRequestsErrorPercent(), MARGEN);
    Assert.assertEquals(346.00, summary.getRequestsOkPerMinute(), MARGEN);
    Assert.assertEquals(19.31, summary.getRequestsResponseTimeOkAvg(), MARGEN);
    Assert.assertEquals(58.81, summary.getRequestsResponseTimeOkAvgDev(),
        MARGEN);

    Assert.assertEquals(165.83, summary.getTransResponseTimeOkAvg(), MARGEN);
    Assert.assertEquals(227.57, summary.getTransResponseTimeOkAvgDev(), MARGEN);
    Assert.assertEquals(137.23, summary.getTransResponseTimeOkAvgDevPercent(),
        MARGEN);

    double homeErrorTotal = summary.getTransMapErrorTotal().get("HOME");
    Assert.assertEquals(8.0, homeErrorTotal, MARGEN);

    double detalleCentroDevPerc = summary
        .getTransMapResponseTimeOkAvgDevPercent().get("DETALLE_CENTRO");
    Assert.assertEquals(67.82, detalleCentroDevPerc, MARGEN);
    */
  }
  
  @Test
  public void testIntegrationGetGlobalSummaryTransPlain() {
    log.info("** TEST testIntegrationGetGlobalSummaryTransPlain "
        + JMeterReportServerTestConst.TEST_CONFIG_TRANS_PLAIN);
    GlobalSummary summary = client
        .getGlobalSummary(JMeterReportServerTestConst.TEST_CONFIG_TRANS_PLAIN);
    log.debug(summary.toString());

    Assert.assertEquals(352, summary.getRequestsTotal());
    Assert.assertEquals(344, summary.getRequestsOkTotal());
    Assert.assertEquals(8, summary.getRequestsErrorTotal());
    Assert.assertEquals(2.27, summary.getRequestsErrorPercent(), MARGEN);
    Assert.assertEquals(346.00, summary.getRequestsOkPerMinute(), MARGEN);
    Assert.assertEquals(19.31, summary.getRequestsResponseTimeOkAvg(), MARGEN);
    Assert.assertEquals(58.81, summary.getRequestsResponseTimeOkAvgDev(),
        MARGEN);

    Assert.assertEquals(165.83, summary.getTransResponseTimeOkAvg(), MARGEN);
    Assert.assertEquals(227.57, summary.getTransResponseTimeOkAvgDev(), MARGEN);
    Assert.assertEquals(137.23, summary.getTransResponseTimeOkAvgDevPercent(),
        MARGEN);

    double homeErrorTotal = summary.getTransMapErrorTotal().get("HOME");
    Assert.assertEquals(8.0, homeErrorTotal, MARGEN);

    double detalleCentroDevPerc = summary
        .getTransMapResponseTimeOkAvgDevPercent().get("DETALLE_CENTRO");
    Assert.assertEquals(67.82, detalleCentroDevPerc, MARGEN);
  }

  @Test
  public void testIntegrationGetGlobalSummaryTransPlainShort() {
    log.info("** TEST testIntegrationGetGlobalSummaryTransPlainShort "
        + JMeterReportServerTestConst.TEST_CONFIG_TRANS_PLAIN_SHORT);
    GlobalSummary summary = client
        .getGlobalSummary(JMeterReportServerTestConst.TEST_CONFIG_TRANS_PLAIN_SHORT);
    log.debug(summary.toString());

    Assert.assertEquals(120000, summary.getTestDuration());
    Assert.assertEquals(1, summary.getUsersLogged());

    // Requests
    Assert.assertEquals(7, summary.getRequestsTotal());
    Assert.assertEquals(6, summary.getRequestsOkTotal());
    Assert.assertEquals(1, summary.getRequestsErrorTotal());
    Assert.assertEquals(14.28, summary.getRequestsErrorPercent(), MARGEN);

    Assert.assertEquals(3.0, summary.getRequestsOkPerMinute(), MARGEN);
    Assert.assertEquals(3.0, summary.getRequestsOkPerMinuteAndUser(), MARGEN);

    Assert.assertEquals(5.58, summary.getRequestsBytesOkAvgDevPercent(), MARGEN);
    Assert.assertEquals(1.0, summary.getRequestsResponseTimeOkAvg(),MARGEN);
    Assert.assertEquals(0.0, summary.getRequestsResponseTimeOkAvgDevPercent(),MARGEN);

    // Transactions
    Assert.assertEquals(5, summary.getTransTotal());
    Assert.assertEquals(4, summary.getTransOkTotal());
    Assert.assertEquals(1, summary.getTransErrorTotal());
    Assert.assertEquals(20.0, summary.getTransErrorPercent(), MARGEN);

    Assert.assertEquals(2.0, summary.getTransOkPerMinute(), MARGEN);
    Assert.assertEquals(2.0, summary.getTransOkPerMinuteAndUser(), MARGEN);

    Assert.assertEquals(1.0, summary.getTransBytesOkAvg(),MARGEN);
    Assert.assertEquals(0.0, summary.getTransBytesOkAvgDevPercent(), MARGEN);
    Assert.assertEquals(81.64, summary.getTransResponseTimeOkAvgDevPercent(), MARGEN);

    // TransMapErrorTotal
    double value = summary.getTransMapErrorTotal().get("ERROR_TRANS");
    Assert.assertEquals(1.0, value, MARGEN);

    value = summary.getTransMapErrorTotal().get("OK_TRANS");
    Assert.assertEquals(0.0, value, MARGEN);

    // TransMapOkTotal
    value = summary.getTransMapOkTotal().get("ERROR_TRANS");
    Assert.assertEquals(0.0, value, MARGEN);

    value = summary.getTransMapOkTotal().get("OK_TRANS");
    Assert.assertEquals(4.0, value, MARGEN);
  }
  
  @Test
  public void testIntegrationGetGlobalSummary() {
    for (String config : JMeterReportServerTestConst.TEST_CONFIGS) {
      log.info("** TEST testIntegrationGetGlobalSummary " + config);
      GlobalSummary summary = client.getGlobalSummary(config);
    }
  }

  @Test
  public void testIntegrationGetBuckedMeasures() {
    for (String config : JMeterReportServerTestConst.TEST_CONFIGS) {
      log.info("** TEST IntegrationGetBuckedMeasures " + config);

      StreamReader<Measure> reader = client.getBuckedMeasures(config,
          JMeterReportConst.METRIC_BUCKET_AVG_RESPONSE_TIME, 500);

      Measure measure = reader.read();
      while (measure != null) {
        log.debug(measure.getTimeStamp() + "\t" + measure.getValue());
        measure = reader.read();
      }
    }
  }
  
  @Test
  public void testIntegrationError() {
    log.info("** TEST IntegrationError blank config");

    boolean error = false;

    try {
      client.getGlobalSummary("");
    } catch (Exception e) {
      error = true;
      System.out.println(e);
      Assert.assertTrue(e.getMessage().startsWith("Server"));
    }

    Assert.assertTrue(error);
  }
  
  

  String reachedConnectionLimitErrorMsg = null;
  
  @Test
  @Ignore("In some machines this test fails because of: diferent thread performance?")
  public void testConnectionLimitExceededError() {
    log.info("** TEST testConnectionLimitExceededError");

    // Start one connection ...
    Thread thread1 = new Thread(new Runnable() {
      public void run() {
        JMeterReportClient client1 = new JMeterReportClient(LOCALHOST, configService.getPort());
        
        try {
          client1.getGlobalSummary(JMeterReportServerTestConst.TEST_CONFIG_HTTP);
        } catch(Exception e) {
          log.error("client1: ", e);
          reachedConnectionLimitErrorMsg = e.getMessage();
        }
      }
    });
    
    // And, at the same time, in parallel, start another connection
    Thread thread2 = new Thread(new Runnable() {
      public void run() {
        JMeterReportClient client2 = new JMeterReportClient(LOCALHOST, configService.getPort());
        
        try {
          client2.getGlobalSummary(JMeterReportServerTestConst.TEST_CONFIG_HTTP);
        } catch(Exception e) {
          log.error("client2: ", e);
          reachedConnectionLimitErrorMsg = e.getMessage();
        }
      }
    });
    
    
    // This must launch an exception because maxConnections=1 in tests properties file
    thread1.start();
    thread2.start();
    
    // Wait for the results
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      log.error("Interrupted: ", e);
    }
    
    Assert.assertNotNull(reachedConnectionLimitErrorMsg);
  }
}
