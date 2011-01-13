/*
 * JMeter Report Server
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

package es.excentia.jmeter.report.server.testresults;

import java.io.IOException;
import java.io.Writer;

/**
 * A Writer that buffers the data in memory as a string. The buffer can be reset
 * at any time and the contents of the buffer will be returned.
 */
public class ResettableStringWriter extends Writer {
	
	/**
	 * The internal buffer used to store the data written to this stream.
	 */
	private StringBuilder mBuffer = new StringBuilder();

	/**
	 * The maximum bytes this writer will buffer.
	 */
	private int mMaxBytes = 1024;

	/**
	 * Constructs the writer which will hold a fixed maximum of bytes. If more
	 * bytes are written, an exception will be raised.
	 * 
	 * @param maxBytes
	 *            the maximum number of bytes this writer will buffer
	 */
	public ResettableStringWriter(int maxBytes) {
		mMaxBytes = maxBytes;
	}

	@Override
	public void close() throws IOException {
		// no op
	}

	@Override
	public void flush() throws IOException {
		// no op
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		mBuffer.append(cbuf, off, len);

		if (mBuffer.length() > mMaxBytes) {
			throw new IOException("Memory buffer overflow");
		}
	}

	/**
	 * Resets the stream to a length of zero. Any data written to the stream
	 * since the last call to reset will be returned.
	 * 
	 * @return the contents of the stream buffer
	 */
	public String reset() {
		String data = mBuffer.toString();
		mBuffer.setLength(0);
		return data;
	}
}