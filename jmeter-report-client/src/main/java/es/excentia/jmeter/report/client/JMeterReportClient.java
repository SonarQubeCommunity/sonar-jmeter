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
import es.excentia.jmeter.report.client.exception.JMeterReportException;
import es.excentia.jmeter.report.client.serialization.GlobalSummaryReader;
import es.excentia.jmeter.report.client.serialization.MeasureReader;
import es.excentia.jmeter.report.client.serialization.StreamReader;

public class JMeterReportClient {

  private static final Logger log = LoggerFactory
      .getLogger(JMeterReportClient.class);
  private static final boolean LOG_DEBUG = log.isDebugEnabled();

  private String serverHost = JMeterReportConst.DEFAULT_HOST;
  private int serverPort = JMeterReportConst.DEFAULT_PORT;

  public JMeterReportClient() {
    // Cliente con parámetros de conexión por defecto
  }

  public JMeterReportClient(String serverHost, int serverPort) {
    this.serverHost = serverHost;
    this.serverPort = serverPort;
  }

  protected Socket openSocket() throws IOException {
    SocketFactory socketFactory = SocketFactory.getDefault();
    return socketFactory.createSocket(serverHost, serverPort);
  }

  public GlobalSummary getGlobalSummary(String config) {
    if (LOG_DEBUG) {
      log.debug("getGlobalSummary");
      log.debug("config: " + config);
    }

    Socket socket = null;
    try {
      socket = openSocket();

      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
      dos.writeInt(JMeterReportConst.OP_GET_GLOBAL_SUMMARY);
      dos.writeUTF(config);

      return new GlobalSummaryReader(socket.getInputStream()).read();

    } catch (JMeterReportException e) {
      throw e;
    } catch (Exception e) {
      throw new JMeterReportException(e);
    }

    // No cerramos el socket.
    // El socket lo cerrará el servidor cuando termine de servir todos
    // los datos.
  }

  public StreamReader<Measure> getBuckedMeasures(String config, String metric,
      int millisBucket) {
    if (LOG_DEBUG) {
      log.debug("getBuckedMeasures");
      log.debug("config: " + config);
      log.debug("metric: " + metric);
      log.debug("millisBucket: " + millisBucket);
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

    } catch (JMeterReportException e) {
      throw e;
    } catch (Exception e) {
      throw new JMeterReportException(e);
    }

    // No cerramos el socket.
    // El socket lo cerrará el servidor cuando termine de servir todos
    // los datos.
  }

}
