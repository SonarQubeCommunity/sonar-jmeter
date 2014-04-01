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

package es.excentia.jmeter.report.client.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for checking java version
 */
public class JavaUtil {

	private JavaUtil() {}
	
	private static Pattern JAVA_VERSION_PATTERN = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\w+)");
	
	public static String getVersion() {
		return System.getProperty("java.version");
	}
	
	private static String getGroup(int groupidx) {
		Matcher m = JAVA_VERSION_PATTERN.matcher(getVersion());
    if (m.matches()) {
    	return m.group(groupidx);
    } 
    return "0";
	}
	
  /**
   * Return jre major version or 0 if couldn't parse java.version
   */
	public static Integer getJREMajorVersion() {
		return Integer.parseInt(getGroup(1));
	}
	
	/**
   * Return jre minor version or 0 if couldn't parse java.version
   */
	public static Integer getJREMinorVersion() {
		return Integer.parseInt(getGroup(2));
	}
  
}
