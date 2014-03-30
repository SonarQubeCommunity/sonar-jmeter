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

package es.excentia.jmeter.report.server.transformer;

import es.excentia.jmeter.report.client.data.Measure;
import es.excentia.jmeter.report.client.serialization.StreamReader;
import es.excentia.jmeter.report.client.serialization.StreamWriter;
import es.excentia.jmeter.report.client.serialization.Transformer;
import es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample;
import es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample;

public class BucketAvgResponseTimeTransformer extends
    Transformer<HttpSample, Measure> {

  private static final int DEFAULT_MILLIS_BUCKET = 500;
  private int millisBucket;

  public BucketAvgResponseTimeTransformer(StreamReader<HttpSample> reader,
      StreamWriter<Measure> writer, int millisBucket) {
    super(reader, writer);
  }

  @Override
  public void transform() {
    if (millisBucket <= 0) {
      millisBucket = DEFAULT_MILLIS_BUCKET;
    }

    AbstractSample httpSample = reader.read();
    if (httpSample == null) {
      return;
    }

    long ts = httpSample.getTs();
    int digitsToReset = (int) Math.log10(ts);
    long bucketGround = ((long) (ts / digitsToReset)) * digitsToReset;
    long bucketRoof = bucketGround + millisBucket;

    do {

      long total = 0;
      int values = 0;
      while (httpSample != null && httpSample.getTs() < bucketRoof) {
        total += httpSample.getT();
        values++;
        httpSample = reader.read();
      }

      if (values != 0) {
        // Si no hay valores, no hay medida

        Measure measure = new Measure();
        measure.setTimeStamp(bucketRoof - millisBucket / 2);
        measure.setValue(((double) total) / values);

        writer.write(measure);
      }

      bucketRoof += millisBucket;

    } while (httpSample != null);
  }

}
