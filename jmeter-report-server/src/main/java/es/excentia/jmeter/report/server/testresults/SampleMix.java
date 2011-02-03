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

import java.util.List;

import es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample;
import es.excentia.jmeter.report.server.testresults.xmlbeans.Sample;

public class SampleMix {

  List<Sample> transactions;
  List<HttpSample> httpSamples;

  public SampleMix(List<Sample> transactions, List<HttpSample> httpSamples) {
    this.transactions = transactions;
    this.httpSamples = httpSamples;
  }

  public List<Sample> getTransactions() {
    return transactions;
  }

  public List<HttpSample> getHttpSamples() {
    return httpSamples;
  }

}
