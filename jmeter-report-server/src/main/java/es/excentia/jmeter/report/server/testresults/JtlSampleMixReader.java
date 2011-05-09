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
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.excentia.jmeter.report.client.serialization.StreamReader;
import es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample;
import es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample;
import es.excentia.jmeter.report.server.testresults.xmlbeans.Sample;

/**
 * Reader para obtener los objetos HttpSample y Sample de un fichero jtl
 * 
 * @author cfillol
 * 
 */
public class JtlSampleMixReader extends StreamReader<SampleMix> {

  private static final Logger log = LoggerFactory
      .getLogger(JtlSampleMixReader.class);
  private static final boolean LOG_WARN = log.isWarnEnabled();

  protected JtlAbstractSampleReader jtlReader;

  public JtlSampleMixReader(InputStream is) {
    super(is);
    jtlReader = new JtlAbstractSampleReader(is);
  }

  protected boolean isTransaction(Sample sample) {
    if (sample.getRm() != null
        && sample.getRm().contains("Number of samples in transaction")) {
      return true;
    } else {
      return false;
    }
  }

  protected boolean addTransaction(Sample sample, List<Sample> samples,
      List<HttpSample> httpSamples) {
    if (!isTransaction(sample)) {
      return false;
    }

    samples.add(sample);

    // Anotamos los HttpSamples que cuelgan de la transacción
    for (HttpSample httpSample : sample.getHttpSampleArray()) {
      httpSamples.add(httpSample);
    }

    // Anotamos las transacciones hijas
    for (Sample s : sample.getSampleArray()) {
      addTransaction(s, samples, httpSamples);
    }

    return true;
  }

  @Override
  public SampleMix getObjectFromStream() throws Exception {
    AbstractSample abstractSample = jtlReader.read();
    if (abstractSample == null) {
      return null;
    }

    List<Sample> transactions = new ArrayList<Sample>();
    List<HttpSample> httpSamples = new ArrayList<HttpSample>();

    boolean addedNodes = false;
    while (abstractSample != null) {

      // Se trata de un Sample o de un HttpSample?
      if (abstractSample instanceof Sample) {
        addedNodes = addTransaction((Sample) abstractSample, transactions,
            httpSamples);
      } else if (abstractSample instanceof HttpSample) {
        httpSamples.add((HttpSample) abstractSample);
        addedNodes = true;
      } else {
        if (LOG_WARN) {
          log.warn("Tipo de sample no reconocido: "
              + abstractSample.getClass().getSimpleName());
        }
      }

      if (addedNodes) {
        return new SampleMix(transactions, httpSamples);
      }

      abstractSample = jtlReader.read();
    }

    return null;
  }

}
