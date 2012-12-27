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

import java.io.OutputStream;

import es.excentia.jmeter.report.client.data.GlobalSummary;
import es.excentia.jmeter.report.client.exception.ServerErrorException;

public interface OperationService extends Service {

  /**
   * Write a value for a measure each n milliseconds.
   * @param config jmeter-report-server config name.
   * @param metric The name of metric. By the moment only 
   * 'BucketAvgResponseTime' is available.
   * @param time cell size in milliseconds.
   */
  void writeBucketMeasures(OutputStream os, String config, String metric,
      int millisBucket);

  /**
   * Returns a global summary report. If the test is not finished yet,
   * this method will wait until the test finishes and global summary
   * will reflect the definitive result.
   * 
   * @param config jmeter-report-server config name.
   */
  GlobalSummary getGlobalSummary(String config);
  
  /**
   * Writes a global summary report. If the test is not finished yet,
   * this method will wait until the test finishes and global summary
   * will reflect the definitive result.
   * 
   * @param config jmeter-report-server config name.
   */
  void writeGlobalSummary(OutputStream os, String config);
  
  /**
   * Writes global summary reports for a running or a finished jmeter test.
   *  
   * Last obtained GlobalSummary object will contain total results, but
   * previous obtained GlobalSummary objects will contain partial results.
   * 
   * The fact that a jmeter test has finished does not sure that only one
   * GlobalSummary will be produced. That will depend on the duration of
   * JTL parsing process. Anyway, a GlobalSummary object will be
   * send every 'sleepTime' seconds.
   * 
   * Example to get results from server for every 1 second:
   * 
   *  JMeterReportClient client = new JMeterReportClient("127.0.0.1", 4444);
   *  StreamReader<GlobalSummary> reader = client.getRunningGlobalSummary("myapp", true, 1); 
   *  GlobalSummary summary = reader.read();
   *  while (summary!=null) {
   *     System.out.println(summary.getRequestsOkTotal()+" requests ok, at "+summary.getTestDuration()+ " ms.");
   *     summary = reader.read();
   *  }
   *  
   * @param config jmeter-report-server config name.
   * @param startNewIfNone true to start a new parsing process if there 
   * isn't one running. false to get running parsing results or null if there
   * wasn't a parsing process running.
   * @param sleepTime Time in seconds that that jmeter report server will wait to 
   * send a new GlobalReport object containing partial results.
   * 
   * @return A StreamReader<GlobalSummary> object that have to be used to 
   * receive GlobalSummary objects.
   * 
   * @throws ServerErrorException
   */
  void writeRunningGlobalSummary(OutputStream os, String config, boolean startNewIfNone, int secondsBucket);

}
