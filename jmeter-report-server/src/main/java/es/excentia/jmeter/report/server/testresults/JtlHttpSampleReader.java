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

package es.excentia.jmeter.report.server.testresults;

import java.io.InputStream;
import java.util.List;

import es.excentia.jmeter.report.client.serialization.StreamReader;
import es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample;

/**
 * Reader to get all HttpSamples from jtl xml file.
 * Well, not all. HttpSamples inside another HttpSample will be
 * discarted because parent time and size values reflect total 
 * children size or time values.
 * 
 * This reader uses JtlSampleMixReader to get first level Samples (transactions) 
 * and HttpSample. When it gets a transaction sample, the sample itself
 * will be discarted but inner HttpSamples will be covered and will be
 * returned through read method.
 * HttpSamples inside another HttpSample will be discarted because 
 * parent time and size values reflect total children size or time values.
 * 
 * Read method returns one HttpSample for each call.
 * 
 * @author cfillol
 * 
 */
public class JtlHttpSampleReader extends StreamReader<AbstractSample> {

  protected JtlSampleMixReader jtlReader;
  protected List<AbstractSample> httpSamples;
  protected int httpSamplesIndex;

  public JtlHttpSampleReader(InputStream is) {
    this(is, 0);
  }
  
  public JtlHttpSampleReader(InputStream is, int growingJtlWaitTime) {
    super(is);
    jtlReader = new JtlSampleMixReader(is, growingJtlWaitTime);
  }

  /**
   * Read method returns one HttpSample for each call.
   * Transaction Samples will be discarted but inner HttpSamples inside 
   * the transaction will be covered and will be returned through read method.
   * HttpSamples inside another HttpSample will be discarted because 
   * parent time and size values reflect total children size or time values.
   */
  @Override
  public AbstractSample read() {
    if (httpSamples != null && httpSamplesIndex < httpSamples.size()) {
    	AbstractSample httpSample = httpSamples.get(httpSamplesIndex);
      httpSamplesIndex++;
      return httpSample;
    }

    while (true) {
      SampleMix sampleMix = jtlReader.read();
      if (sampleMix == null)
        return null;

      List<AbstractSample> newHttpSamples = sampleMix.getHttpSamples();

      if (newHttpSamples == null || newHttpSamples.size() == 0) {
        continue;
      } else {
        httpSamples = newHttpSamples;
        httpSamplesIndex = 1;
        return httpSamples.get(0);
      }
    }
  }

}
