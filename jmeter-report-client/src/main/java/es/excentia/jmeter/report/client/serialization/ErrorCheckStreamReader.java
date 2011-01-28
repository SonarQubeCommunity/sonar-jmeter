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
import java.io.InputStream;

import es.excentia.jmeter.report.client.JMeterReportConst;

public abstract class ErrorCheckStreamReader<T> extends StreamReader<T> {
	
	DataInputStream dis;
	
	public ErrorCheckStreamReader(InputStream is) {
		super(is);
		dis = new DataInputStream(is);
	}
	
	public final T read() {

		try {
			
			int errorControl = dis.readInt();
			if (errorControl==JMeterReportConst.RETURN_CODE_ERROR) {
				throw new StreamException("Server error: "+dis.readUTF());
			}
			
			return getObjectFromStream();
			
		} catch(EOFException e) {
			return null;
		} catch(StreamException e) {
			throw e;
		} catch(Exception e) {
			throw new StreamException(e);
		}
		
	}
	
	protected abstract T getObjectFromStream() throws Exception;
}
