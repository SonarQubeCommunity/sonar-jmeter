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
package es.excentia.jmeter.report.server.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.excentia.jmeter.report.client.serialization.StreamReader;
import es.excentia.jmeter.report.server.testresults.SampleMix;

public abstract class ReportThread extends Thread  {
  
  private static final Logger log = LoggerFactory.getLogger(ReportThread.class);
  
  
  private RuntimeException resultException;
  private Report report;
  private StreamReader<SampleMix> reader;
  
  
  public ReportThread(Report report, StreamReader<SampleMix> reader) {
    this.report = report;
    this.reader = reader;
  }
  
  
  public Report getReport() {  return report; }
  public RuntimeException getResultException() { return resultException; }
  
  
  public void run() {
    
    try {
      report.extract(reader);
    } catch(RuntimeException ex) {
      log.debug("ReportThread running finished with exception", ex);
      resultException = ex;
    }
    
    onFinished();
  }
  
  public abstract void onFinished();
  
}
