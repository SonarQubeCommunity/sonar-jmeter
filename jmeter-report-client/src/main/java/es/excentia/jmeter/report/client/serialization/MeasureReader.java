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

package es.excentia.jmeter.report.client.serialization;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import es.excentia.jmeter.report.client.data.Measure;

public class MeasureReader extends ErrorCheckStreamReader<Measure> {

  protected DataInputStream dis;

  public MeasureReader(InputStream is) {
    super(is);
    dis = new DataInputStream(is);
  }

  @Override
  public Measure getObjectFromStream() throws IOException {
    Measure measure = new Measure();
    measure.setTimeStamp(dis.readLong());
    measure.setValue(dis.readDouble());
    return measure;
  }

}
