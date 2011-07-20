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
import java.util.Map;

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
import es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample;
import es.excentia.jmeter.report.server.transformer.BucketMeasuresTransformerFactory;

public class OperationServiceImpl implements OperationService {

  protected ReaderService readerService = ServiceFactory.get(ReaderService.class);

  
  public void writeBucketMeasures(OutputStream os, String config,
      String metric, int millisBucket) {

    StreamReader<HttpSample> reader = readerService.getHttpSampleReaderByTestConfig(config);
    StreamWriter<Measure> writer = new MeasureWriter(os);
    Transformer<HttpSample, Measure> transformer = BucketMeasuresTransformerFactory
        .get(metric, reader, writer, millisBucket);
    transformer.transform();
  }

  
  public GlobalSummary getGlobalSummary(String config) {

    // Get report with necessary data to fill the GlobalSummary
    Report report = new Report();
    report.addData(OkCounter.class, Report.SCOPE_ALL);
    report.addData(OkResponseTimeAverage.class, Report.SCOPE_ALL);
    report.addData(OkBytesAverage.class, Report.SCOPE_ALL);
    report.addData(TransOrder.class, Report.SCOPE_TRANS_GLOBAL);
    report.extract(config);

    // Fill GlobalSummary

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

    // Tipos de transacciones
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

  
  public void writeGlobalSummary(OutputStream os, String config) {
    GlobalSummary summary = getGlobalSummary(config);
    new GlobalSummaryWriter(os).write(summary);
  }

  
}
