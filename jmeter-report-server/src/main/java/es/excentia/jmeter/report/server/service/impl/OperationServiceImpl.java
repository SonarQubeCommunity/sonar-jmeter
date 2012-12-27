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

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.excentia.jmeter.report.client.data.GlobalSummary;
import es.excentia.jmeter.report.client.data.Measure;
import es.excentia.jmeter.report.client.serialization.GlobalSummaryWriter;
import es.excentia.jmeter.report.client.serialization.MeasureWriter;
import es.excentia.jmeter.report.client.serialization.StreamReader;
import es.excentia.jmeter.report.client.serialization.StreamWriter;
import es.excentia.jmeter.report.client.serialization.Transformer;
import es.excentia.jmeter.report.server.report.OkBytesAverage;
import es.excentia.jmeter.report.server.report.OkCounter;
import es.excentia.jmeter.report.server.report.OkResponseTimeAverage;
import es.excentia.jmeter.report.server.report.Report;
import es.excentia.jmeter.report.server.report.ReportThread;
import es.excentia.jmeter.report.server.report.TransOrder;
import es.excentia.jmeter.report.server.report.transmapsimp.BytesOkAvgDevPercentTransMapSimp;
import es.excentia.jmeter.report.server.report.transmapsimp.BytesOkAvgDevTransMapSimp;
import es.excentia.jmeter.report.server.report.transmapsimp.BytesOkAvgTransMapSimp;
import es.excentia.jmeter.report.server.report.transmapsimp.ErrorTotalTransMapSimp;
import es.excentia.jmeter.report.server.report.transmapsimp.OkTotalTransMapSimp;
import es.excentia.jmeter.report.server.report.transmapsimp.ResponseTimeOkAvgDevPercentTransMapSimp;
import es.excentia.jmeter.report.server.report.transmapsimp.ResponseTimeOkAvgDevTransMapSimp;
import es.excentia.jmeter.report.server.report.transmapsimp.ResponseTimeOkAvgTransMapSimp;
import es.excentia.jmeter.report.server.service.OperationService;
import es.excentia.jmeter.report.server.service.ReaderService;
import es.excentia.jmeter.report.server.service.ServiceFactory;
import es.excentia.jmeter.report.server.testresults.SampleMix;
import es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample;
import es.excentia.jmeter.report.server.transformer.BucketMeasuresTransformerFactory;

/**
 * @author carlos
 *
 */
/**
 * @author carlos
 *
 */
public class OperationServiceImpl implements OperationService {

  private static final Logger log = LoggerFactory.getLogger(OperationServiceImpl.class);
  
  private ReaderService readerService = ServiceFactory.get(ReaderService.class);

  
  /* (non-Javadoc)
   * @see es.excentia.jmeter.report.server.service.OperationService#writeBucketMeasures(java.io.OutputStream, java.lang.String, java.lang.String, int)
   */
  public void writeBucketMeasures(OutputStream os, String config,
      String metric, int millisBucket) {

    StreamReader<HttpSample> reader = readerService.getHttpSampleReaderByTestConfig(config);
    StreamWriter<Measure> writer = new MeasureWriter(os);
    Transformer<HttpSample, Measure> transformer = BucketMeasuresTransformerFactory
        .get(metric, reader, writer, millisBucket);
    transformer.transform();
  }

  
  ////////////////////////////////////////
  // Global Summary Reports
  //
  
  private Map<String, ReportThread> runningGlobalSummaryReports = new HashMap<String, ReportThread>();
  
  /**
   * Gets GlobalSummary info from report.
   * If report extraction isn't finished returned GlobalSummary will contain
   * actual status.
   *
   * @param config jmeter-report-server config name
   * @param report running or finished report
   */
  protected GlobalSummary getGlobalSummaryFromReport(String config, Report report) {
    while (!report.isInitialized()) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        // continue 100 after ...
      }
    }

    GlobalSummary globalSummary = new GlobalSummary();
    globalSummary.setTestDesc(config);
    globalSummary.setUsersLogged(report.getNumUsersLogged());
    globalSummary.setTestDuration(report.getTestDuration());

    // Requests
    OkCounter okCounter = report.getDataRequestGlobal(OkCounter.class);
    globalSummary.setRequestsTotal(okCounter.getTotal());
    globalSummary.setRequestsOkTotal(okCounter.getCounter());
    globalSummary.setRequestsErrorTotal(okCounter.getOpositeCounter());
    globalSummary.setRequestsErrorPercent(okCounter.getOpositePercent());
    globalSummary.setRequestsOkPerMinute(okCounter.getCounterPerMinute());
    globalSummary.setRequestsOkPerMinuteAndUser(okCounter.getCounterPerMinuteAndUser());

    OkResponseTimeAverage okResponseTimeAverage = report.getDataRequestGlobal(OkResponseTimeAverage.class);
    globalSummary.setRequestsResponseTimeOkAvg(okResponseTimeAverage.getAverage());
    globalSummary.setRequestsResponseTimeOkAvgDev(okResponseTimeAverage.getDeviation());
    globalSummary.setRequestsResponseTimeOkAvgDevPercent(okResponseTimeAverage.getDeviationPercent());

    OkBytesAverage okBytesAverage = report.getDataRequestGlobal(OkBytesAverage.class);
    globalSummary.setRequestsBytesOkAvg(okBytesAverage.getAverage());
    globalSummary.setRequestsBytesOkAvgDev(okBytesAverage.getDeviation());
    globalSummary.setRequestsBytesOkAvgDevPercent(okBytesAverage.getDeviationPercent());

    // Transactions
    okCounter = report.getDataTransGlobal(OkCounter.class);
    globalSummary.setTransTotal(okCounter.getTotal());
    globalSummary.setTransOkTotal(okCounter.getCounter());
    globalSummary.setTransErrorTotal(okCounter.getOpositeCounter());
    globalSummary.setTransErrorPercent(okCounter.getOpositePercent());
    globalSummary.setTransOkPerMinute(okCounter.getCounterPerMinute());
    globalSummary.setTransOkPerMinuteAndUser(okCounter.getCounterPerMinuteAndUser());

    okResponseTimeAverage = report.getDataTransGlobal(OkResponseTimeAverage.class);
    globalSummary.setTransResponseTimeOkAvg(okResponseTimeAverage.getAverage());
    globalSummary.setTransResponseTimeOkAvgDev(okResponseTimeAverage.getDeviation());
    globalSummary.setTransResponseTimeOkAvgDevPercent(okResponseTimeAverage.getDeviationPercent());

    okBytesAverage = report.getDataTransGlobal(OkBytesAverage.class);
    globalSummary.setTransBytesOkAvg(okBytesAverage.getAverage());
    globalSummary.setTransBytesOkAvgDev(okBytesAverage.getDeviation());
    globalSummary.setTransBytesOkAvgDevPercent(okBytesAverage.getDeviationPercent());

    // Transaction types
    TransOrder transOrder = report.getDataTransGlobal(TransOrder.class);
    globalSummary.setTransOrder(transOrder.getTransOrderedList());

    // OkCounter
    Map<String, OkCounter> mapOkCounter = report.getDataTransType(OkCounter.class);
    globalSummary.setTransMapOkTotal(new OkTotalTransMapSimp().toSimpleMap(mapOkCounter));
    globalSummary.setTransMapErrorTotal(new ErrorTotalTransMapSimp().toSimpleMap(mapOkCounter));

    // OkResponseTimeAverage
    Map<String, OkResponseTimeAverage> mapOkRespTimeAvg = report.getDataTransType(OkResponseTimeAverage.class);
    globalSummary.setTransMapResponseTimeOkAvg(new ResponseTimeOkAvgTransMapSimp().toSimpleMap(mapOkRespTimeAvg));
    globalSummary.setTransMapResponseTimeOkAvgDev(new ResponseTimeOkAvgDevTransMapSimp().toSimpleMap(mapOkRespTimeAvg));
    globalSummary.setTransMapResponseTimeOkAvgDevPercent(new ResponseTimeOkAvgDevPercentTransMapSimp().toSimpleMap(mapOkRespTimeAvg));

    // OkBytesAverage
    Map<String, OkBytesAverage> mapOkBytesAvg = report.getDataTransType(OkBytesAverage.class);
    globalSummary.setTransMapBytesOkAvg(new BytesOkAvgTransMapSimp().toSimpleMap(mapOkBytesAvg));
    globalSummary.setTransMapBytesOkAvgDev(new BytesOkAvgDevTransMapSimp().toSimpleMap(mapOkBytesAvg));
    globalSummary.setTransMapBytesOkAvgDevPercent(new BytesOkAvgDevPercentTransMapSimp().toSimpleMap(mapOkBytesAvg));
    
    return globalSummary;
  }

  
  /**
   * Gets running global summary ReportThread for specified config or start one.
   * 
   * @param config jmeter-report-server config name.
   * @param startNewIfNone true to start a new parsing process if there 
   * isn't one running. false to get running parsing results or null if there
   * wasn't a parsing process running.
   * 
   * @return Running ReportThread or null if there isn't one and 
   * startNewIfNoExistingThread is false.
   */
  protected synchronized ReportThread getRunningGlobalSummaryReportThread(final String config, boolean startNewIfNone) {
    
    ReportThread reportThread = runningGlobalSummaryReports.get(config);
    if (reportThread!=null) {
      
      log.debug(
          "There is no need to start a new global summary report " +
          "process because there is one running allready for config: '"+config+"'"
      );
      
    } else if (startNewIfNone) {
      
      Report report = new Report();
      report.addData(OkCounter.class, Report.SCOPE_ALL);
      report.addData(OkResponseTimeAverage.class, Report.SCOPE_ALL);
      report.addData(OkBytesAverage.class, Report.SCOPE_ALL);
      report.addData(TransOrder.class, Report.SCOPE_TRANS_GLOBAL);
      
      StreamReader<SampleMix> reader = readerService.getSampleMixReaderByTestConfig(config);
      
      reportThread = new ReportThread(report, reader) {
        public void onFinished() {
          runningGlobalSummaryReports.remove(config);
          
          if (this.getResultException()==null) {
            log.info("Global summary report successful finished for config '"+config+ "'");
          } else {
            log.error(
                "Error extracting global summary report for config '"+config+ "'",
                this.getResultException()
            );
          }
        }
      };

      runningGlobalSummaryReports.put(config, reportThread);
      log.info("Starting global summary report for config '"+config+ "'");
      reportThread.start();
    }
    
    return reportThread;
    
  }
  
  /* (non-Javadoc)
   * @see es.excentia.jmeter.report.server.service.OperationService#getGlobalSummary(java.lang.String)
   */
  public GlobalSummary getGlobalSummary(String config) {
    ReportThread reportThread = getRunningGlobalSummaryReportThread(config, true);
    try {
      // Wait for the end of the thread
      reportThread.join();
    } catch (InterruptedException e) {
      if (reportThread.getResultException()!=null) {
        throw reportThread.getResultException();
      }
    }
    
    Report report = reportThread.getReport();
    return getGlobalSummaryFromReport(config, report);
  }
  
  /* (non-Javadoc)
   * @see es.excentia.jmeter.report.server.service.OperationService#writeGlobalSummary(java.io.OutputStream, es.excentia.jmeter.report.client.data.GlobalSummary)
   */
  public void writeGlobalSummary(OutputStream os, GlobalSummary globalSummary) {
    new GlobalSummaryWriter(os).write(globalSummary);
  }
  
  /* (non-Javadoc)
   * @see es.excentia.jmeter.report.server.service.OperationService#writeGlobalSummary(java.io.OutputStream, es.excentia.jmeter.report.client.data.GlobalSummary)
   */
  public void writeGlobalSummary(OutputStream os, String config) {
    new GlobalSummaryWriter(os).write(getGlobalSummary(config));
  }
  
  /* (non-Javadoc)
   * @see es.excentia.jmeter.report.server.service.OperationService#writeGlobalSummary(java.io.OutputStream, es.excentia.jmeter.report.client.data.GlobalSummary)
   */
  public void writeRunningGlobalSummary(OutputStream os, String config, boolean startNewIfNoExistingThread, int secondsBucket) {
    ReportThread reportThread = getRunningGlobalSummaryReportThread(config, startNewIfNoExistingThread);
    Report report = reportThread.getReport();
    StreamWriter<GlobalSummary> writer = new GlobalSummaryWriter(os);
    
    do {
      writer.write(getGlobalSummaryFromReport(config, report));
      
      try {
        Thread.sleep(1000*secondsBucket);
      } catch (InterruptedException e) {
        // continue 1000*secondsBucket seconds after ...
      }
    } while (getRunningGlobalSummaryReportThread(config, false)==reportThread);
    
    // Write the global result and finish
    writer.write(getGlobalSummaryFromReport(config, report));
  }

}
