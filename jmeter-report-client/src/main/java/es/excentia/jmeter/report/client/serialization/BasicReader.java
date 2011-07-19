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
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.excentia.jmeter.report.client.JMeterReportConst;
import es.excentia.jmeter.report.client.exception.SerializationException;
import es.excentia.jmeter.report.client.exception.ServerErrorException;

public abstract class BasicReader<T> extends StreamReader<T> {

  protected DataInputStream dis;

  public BasicReader(InputStream is) {
    super(is);
    dis = new DataInputStream(is);
  }
  
  public final T read() {

    try {

      int errorControl = dis.readInt();
      if (errorControl == JMeterReportConst.RETURN_CODE_ERROR) {
        throw new ServerErrorException("Server error: " + dis.readUTF());
      }

      return getObjectFromStream();

    } catch (EOFException e) {
      return null;
    } catch (IOException e) {
        throw new SerializationException(e);
    } 

  }

  protected abstract T getObjectFromStream() throws IOException;
  
  
  protected String readString() throws IOException {
    boolean isNull = dis.readBoolean();
    return isNull ? null : dis.readUTF();
  }

  protected List<String> readStringList() throws IOException {
    int size = dis.readInt();
    List<String> list = new ArrayList<String>();
    for (int i = 0; i < size; i++) {
      list.add(dis.readUTF());
    }
    return list;
  }

  protected Map<String, Long> readMapLong() throws IOException {
    int size = dis.readInt();
    Map<String, Long> map = new HashMap<String, Long>();
    for (int i = 0; i < size; i++) {
      map.put(dis.readUTF(), dis.readLong());
    }
    return map;
  }

  protected Map<String, Double> readMapDouble() throws IOException {
    int size = dis.readInt();
    Map<String, Double> map = new HashMap<String, Double>();
    for (int i = 0; i < size; i++) {
      map.put(dis.readUTF(), dis.readDouble());
    }
    return map;
  }
  
}
