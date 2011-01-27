/*
 * JMeter Report Client
 * Copyright (C) 2010 eXcentia
 * mailto:info AT excentia DOT es
 *
 * SONAR JMeter Plugin is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * SONAR JMeter Plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */

package es.excentia.jmeter.report.client.serialization;

import java.io.DataOutputStream;
import java.io.OutputStream;

import es.excentia.jmeter.report.client.JMeterReportConst;

public abstract class ErrorCheckStreamWriter<T> extends StreamWriter<T> {
	
	DataOutputStream dos;
	
	public ErrorCheckStreamWriter(OutputStream os) {
		super(os);
		dos = new DataOutputStream(os);
	}
	
	public final void write(T obj) {
		try {
			dos.writeInt(JMeterReportConst.RETURN_CODE_OK);
			dos.flush();
			
			writeObjectToStream(obj);
		} catch(StreamException e) {
			throw e;
		} catch(Exception e) {
			throw new StreamException(e);
		}
	}
	
	public abstract void writeObjectToStream(T obj) throws Exception;
	
}