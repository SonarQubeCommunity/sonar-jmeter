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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.excentia.jmeter.report.client.JMeterReportConst;
import es.excentia.jmeter.report.server.exception.JMeterReportServerException;
import es.excentia.jmeter.report.server.service.ConfigService;
import es.excentia.jmeter.report.server.service.OperationService;
import es.excentia.jmeter.report.server.service.ServiceFactory;

/**
 * Servidor de resultados de tests de JMeter para Sonar
 * 
 * @author cfillol
 */
public class JMeterReportServer {

  private static final Logger LOG = LoggerFactory.getLogger(JMeterReportServer.class);
  private static final boolean LOG_DEBUG = LOG.isDebugEnabled();
  private static final boolean LOG_TRACE = LOG.isTraceEnabled();

  private ServerSocket listener;
  private Thread serverThread;
  private int connections = 0;
  private int maxConnections = 0;
  private boolean stopWhenPossible = false;

  protected ConfigService configService = ServiceFactory.get(ConfigService.class);
  protected OperationService operationService = ServiceFactory.get(OperationService.class);

  /**
   * Atendemos en forma de hilos las peticiones de los clientes
   */
  class RequestThread implements Runnable {

    private Socket socket;

    RequestThread(Socket socket) {
      this.socket = socket;
    }

    public void run() {

      try {

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        int op = in.readInt();
        if (LOG_DEBUG) {
          LOG.debug("Attending client request operation: " + op);
        }

        try {

          String config;
          String metric;

          switch (op) {
            case JMeterReportConst.OP_GET_GLOBAL_SUMMARY:
              config = in.readUTF();
              operationService.writeGlobalSummary(out, config);
              break;
              
            case JMeterReportConst.OP_GET_RUNNING_GLOBAL_SUMMARY:
              config = in.readUTF();
              boolean startNewIfNone = in.readBoolean();
              int sleepTime = in.readInt();
              operationService.writeRunningGlobalSummary(out, config, startNewIfNone, sleepTime);
              break;

            case JMeterReportConst.OP_GET_BUCKET_MEASURES:
              config = in.readUTF();
              metric = in.readUTF();
              int millisBucket = in.readInt();
              operationService.writeBucketMeasures(out, config, metric, millisBucket);
              break;

            default:
              throw new JMeterReportServerException("Invalid operation code: "
                  + op);
          }

        } catch (IOException ioe) {
          LOG.error("IOException on socket when serving request", ioe);
        } catch (Exception e) {
          LOG.error("Report request exception", e);

          // Send error to client
          out.writeInt(JMeterReportConst.RETURN_CODE_ERROR);
          out.writeUTF(e.toString());
        }

      } catch (IOException ioe) {
        LOG.error("Could not get socket streams", ioe);
      } finally {
        try {
          connections--;
          socket.close();
          LOG.debug("Request finished");
        } catch (Exception e) {
          LOG.error("Could not close server socket", e);
        }
      }
    }

  }

  
  /**
   * Send error to client and close the socket
   */
  private void connectionLimitExceeded(Socket socket) {
    if (LOG_DEBUG) {
      LOG.debug("Connection limit exceeded ("+maxConnections+"). Closing socket ...");
    }
    try {
      socket.close();
    } catch (Exception e) {
      LOG.error("Could not close server socket", e);
    }
  }
  
    
  
  /**
   * Listen for incoming connections and handle them
   */
  private void startListening() {
    try {

      int port = configService.getPort();
      LOG.info("Starting server on port " + port);

      maxConnections = configService.getMaxConnections();
      
      listener = new ServerSocket(port);
      Socket socket;

      do {
        socket = listener.accept();
        
        if (maxConnections!=0 && connections>=maxConnections) {
          // The number of opened connections is limited and has been exceeded
          connectionLimitExceeded(socket);
        } else {
          // Serve request
          connections++;
          RequestThread requestThread = new RequestThread(socket);
          Thread t = new Thread(requestThread);
          t.start();
        }
      } while (true);

    } catch (IOException ioe) {
      if (LOG_TRACE) {
        LOG.trace("IOException on socket listen", ioe);
      } else if (!stopWhenPossible) {
        LOG.error("IOException on socket listen", ioe);
      }
    }

    LOG.info("Server stopped");
  }

  /**
   * Listen for incoming connections and handle them in a thread, without
   * stopping execution
   */
  public void start() {
    if (serverThread == null) {
      stopWhenPossible = false;
      serverThread = new Thread(new Runnable() {
        public void run() {
          startListening();
        }
      });
      serverThread.start();
    }
  }

  public void stop() {
    if (listener != null) {
      LOG.info("Stopping server ...");

      stopWhenPossible = true;

      try {
        listener.close();
      } catch (IOException e) {
        LOG.error("Error stoping server", e);
      } finally {
        listener = null;
      }
    }
  }

  public static void main(String[] args) {
    new JMeterReportServer().startListening();
  }

}
