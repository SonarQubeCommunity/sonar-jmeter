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
import es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample;

/**
 * Reader para obtener sólo los objetos HttpSample de un fichero jtl
 * 
 * @author cfillol
 * 
 */
public class JtlHttpSampleReader extends StreamReader<HttpSample> {

  protected JtlSampleMixReader jtlReader;
  protected List<HttpSample> httpSamples;
  protected int httpSamplesIndex;

  public JtlHttpSampleReader(InputStream is) {
    super(is);
    jtlReader = new JtlSampleMixReader(is);
  }

  @Override
  public HttpSample read() {
    if (httpSamples != null && httpSamplesIndex < httpSamples.size()) {
      HttpSample httpSample = httpSamples.get(httpSamplesIndex);
      httpSamplesIndex++;
      return httpSample;
    }

    while (true) {
      SampleMix sampleMix = jtlReader.read();
      if (sampleMix == null)
        return null;

      List<HttpSample> newHttpSamples = sampleMix.getHttpSamples();

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
