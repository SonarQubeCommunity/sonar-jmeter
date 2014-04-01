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

public class BucketMeasuresTransformerFactory {

	private BucketMeasuresTransformerFactory() {}
	
  private static final String IMPL_PACKAGE = "es.excentia.jmeter.report.server.transformer";

  @SuppressWarnings("unchecked")
  public static synchronized Transformer<AbstractSample, Measure> get(String name,
      StreamReader<AbstractSample> reader, StreamWriter<Measure> writer,
      int millisBucket) {
    try {

      Class<Transformer<AbstractSample, Measure>> clazz = (Class<Transformer<AbstractSample, Measure>>) Class
          .forName(IMPL_PACKAGE + "." + name + "Transformer");

      return clazz.getConstructor(
          new Class<?>[] { StreamReader.class, StreamWriter.class, int.class })
          .newInstance(new Object[] { reader, writer, millisBucket });

    } catch (Exception e) {
      throw new BuckedMeasuresTransformerFactoryException(e);
    }
  }
}
