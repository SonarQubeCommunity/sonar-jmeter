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

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.net.SocketFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.excentia.jmeter.report.client.data.GlobalSummary;
import es.excentia.jmeter.report.client.data.Measure;
import es.excentia.jmeter.report.client.exception.FatalJMeterReportServerException;
import es.excentia.jmeter.report.client.exception.ServerErrorException;
import es.excentia.jmeter.report.client.serialization.GlobalSummaryReader;
import es.excentia.jmeter.report.client.serialization.MeasureReader;
import es.excentia.jmeter.report.client.serialization.StreamReader;

public class JMeterReportClient {

  private static final Logger LOG = LoggerFactory.getLogger(JMeterReportClient.class);
  private static final boolean LOG_DEBUG = LOG.isDebugEnabled();

  private String serverHost = JMeterReportConst.DEFAULT_HOST;
  private int serverPort = JMeterReportConst.DEFAULT_PORT;

  public JMeterReportClient() {
    // Client with default connection parameters
  }

  public JMeterReportClient(String serverHost, int serverPort) {
    this.serverHost = serverHost;
    this.serverPort = serverPort;
  }

  protected Socket openSocket() throws IOException {
    SocketFactory socketFactory = SocketFactory.getDefault();
    return socketFactory.createSocket(serverHost, serverPort);
  }

  /**
   * Returns a global summary report. If a jmeter test was running,
   * this method would wait until the end of the test and would return
   * definitive global summary result.
   * 
   * @param config jmeter-report-server config name.
   * 
   * @throws ServerErrorException
   */
  public GlobalSummary getGlobalSummary(String config) {
    if (LOG_DEBUG) {
      LOG.debug("getGlobalSummary");
      LOG.debug("config: " + config);
    }

    Socket socket = null;
    try {
      socket = openSocket();

      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
      dos.writeInt(JMeterReportConst.OP_GET_GLOBAL_SUMMARY);
      dos.writeUTF(config);

      return new GlobalSummaryReader(socket.getInputStream()).readUntilEnd();

    } catch (IOException e) {
      throw new FatalJMeterReportServerException(e);
    }

    // Do not close socket. It will be closed by server.
    
  }
  
  /**
   * Gets global summary reports for a running or a finished jmeter test.
   *  
   * Last obtained GlobalSummary object will contain total results, but
   * previous obtained GlobalSummary objects will contain partial results.
   * 
   * The fact that a jmeter test has finished does not sure that only one
   * GlobalSummary will be produced. That will depend on the duration of
   * JTL parsing process. Anyway, a GlobalSummary object will be
   * send from server every 'sleepTime' seconds, and remote JTL file must
   * exists or a ServerErrorException will be produced.
   * 
   * Example to get results from a local server for every 1 second:
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
   * receive GlobalSummary objects. StreamReader.read() will return null
   * if report finishes. Last obtained GlobalReport object will contain
   * definitive total results.
   * 
   * @throws ServerErrorException
   */
  public StreamReader<GlobalSummary> getRunningGlobalSummary(String config, boolean startNewIfNone, int sleepTime) {
    if (LOG_DEBUG) {
      LOG.debug("getRunningGlobalSummary");
      LOG.debug("config: " + config);
      LOG.debug("startNewIfNone: " + startNewIfNone);
      LOG.debug("sleepTime: " + sleepTime);
    }

    Socket socket = null;
    try {
      socket = openSocket();

      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
      dos.writeInt(JMeterReportConst.OP_GET_RUNNING_GLOBAL_SUMMARY);
      dos.writeUTF(config);
      dos.writeBoolean(startNewIfNone);
      dos.writeInt(sleepTime);

      return new GlobalSummaryReader(socket.getInputStream());

    } catch (IOException e) {
      throw new FatalJMeterReportServerException(e);
    }

    // Do not close socket. It will be closed by server.
    
  }

  /**
   * Get a value for a measure every n milliseconds.
   * @param config jmeter-report-server config name.
   * @param metric The name of metric. By the moment only 
   * 'BucketAvgResponseTime' is available.
   * 
   * @param time cell size in milliseconds.
   * 
   * @throws ServerErrorException
   */
  public StreamReader<Measure> getBuckedMeasures(String config, String metric,
      int millisBucket) {
    if (LOG_DEBUG) {
      LOG.debug("getBuckedMeasures");
      LOG.debug("config: " + config);
      LOG.debug("metric: " + metric);
      LOG.debug("millisBucket: " + millisBucket);
    }

    Socket socket = null;
    try {
      socket = openSocket();

      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
      dos.writeInt(JMeterReportConst.OP_GET_BUCKET_MEASURES);
      dos.writeUTF(config);
      dos.writeUTF(metric);
      dos.writeInt(millisBucket);

      return new MeasureReader(socket.getInputStream());

    } catch (IOException e) {
      throw new FatalJMeterReportServerException(e);
    }

    // Do not close socket. It will be closed by server.
    
  }

}
