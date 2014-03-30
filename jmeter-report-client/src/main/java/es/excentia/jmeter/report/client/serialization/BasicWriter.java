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

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import es.excentia.jmeter.report.client.JMeterReportConst;
import es.excentia.jmeter.report.client.exception.SerializationException;

public abstract class BasicWriter<T> extends StreamWriter<T> {

  DataOutputStream dos;

  public BasicWriter(OutputStream os) {
    super(os);
    dos = new DataOutputStream(os);
  }

  public final void write(T obj) {
    try {
      
      dos.writeInt(JMeterReportConst.RETURN_CODE_OK);
      dos.flush();

      writeObjectToStream(obj);
      
    } catch (IOException e) {
      throw new SerializationException(e);
    }
  }

  public abstract void writeObjectToStream(T obj) throws IOException;

  protected void writeStringList(List<String> list) throws IOException {
    if (list == null || list.isEmpty()) {
      dos.writeInt(0);
      return;
    }

    dos.writeInt(list.size());
    for (String value : list) {
      dos.writeUTF(value);
    }
  }

  protected void writeString(String str) throws IOException {
    dos.writeBoolean(str == null);
    if (str != null) {
      dos.writeUTF(str);
    }
  }

  protected void writeMapLong(Map<String, Long> map) throws IOException {
    if (map == null || map.isEmpty()) {
      dos.writeInt(0);
      return;
    }

    dos.writeInt(map.size());
    for (Entry<String, Long> entry: map.entrySet()) {
      dos.writeUTF(entry.getKey());
      dos.writeLong(entry.getValue());
    }
  }

  protected void writeMapDouble(Map<String, Double> map)
  throws IOException {
    if (map == null || map.isEmpty()) {
      dos.writeInt(0);
      return;
    }

    dos.writeInt(map.size());
    for (Entry<String, Double> entry: map.entrySet()) {
      dos.writeUTF(entry.getKey());
      dos.writeDouble(entry.getValue());
    }
  }

}
