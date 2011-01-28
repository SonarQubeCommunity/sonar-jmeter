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

package es.excentia.jmeter.report.server.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import es.excentia.jmeter.report.client.JMeterReportConst;
import es.excentia.jmeter.report.client.serialization.StreamReader;
import es.excentia.jmeter.report.server.exception.ConfigException;
import es.excentia.jmeter.report.server.service.ConfigService;
import es.excentia.jmeter.report.server.testresults.JtlAbstractSampleReader;
import es.excentia.jmeter.report.server.testresults.JtlHttpSampleReader;
import es.excentia.jmeter.report.server.testresults.JtlSampleMixReader;
import es.excentia.jmeter.report.server.testresults.SampleMix;
import es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample;
import es.excentia.jmeter.report.server.testresults.xmlbeans.HttpSample;

public class ConfigServiceImpl implements ConfigService {

	/**
     * Load jmeter report server properties file from the classpath
     */
    protected static Properties getPropertiesFromClasspath() {
        Properties props = new Properties();
        
        String propsName = JMeterReportConst.REPORT_SERVER_PROPERTIES;
        URL url = ClassLoader.getSystemResource(propsName);
        if (url==null) {
        	throw new ConfigException(
        		"Properties file '"+propsName+"' doesn't exist");
		}
        
        try {
			props.load(url.openStream());
		} catch (IOException e) {
			throw new ConfigException(
				"Cannot load properties file: "+propsName);
		}
		
        return props;
    }
    
	protected InputStream getInputStreamByConfig(String config) {
		
		InputStream is = null;
		
		if (config.startsWith("test")) {
			// Modo test: Las métricas se recogerán a partir de archivos
			// de recursos de test del classpath
			is = getClass().getResourceAsStream("/"+config+".jtl.xml");
		}
		
		if (is==null) {
			// Obtenemos la ubicación del fichero jtl a partir del fichero
			// de properties
			Properties props = getPropertiesFromClasspath();
			String jtlPathProp = "testconfig."+config+".jtlpath";
			String jtlPath = props.getProperty(jtlPathProp);
			
			if (jtlPath==null) {
				throw new ConfigException(
					"There is no property "+jtlPathProp+" in "+
					JMeterReportConst.REPORT_SERVER_PROPERTIES
				);
			}
			
			try {
				is = new FileInputStream(new File(jtlPath));
			} catch (FileNotFoundException e) {
				throw new ConfigException(
					"JTL file defined for config '"+config+"' doesn't exist"
				);
			}
		}
		
		return is;
	}
	
	public StreamReader<AbstractSample> getAbstractSampleReaderByConfig(String config) {
		InputStream is = getInputStreamByConfig(config);
		return new JtlAbstractSampleReader(is);
	}
	
	public StreamReader<HttpSample> getHttpSampleReaderByConfig(String config) {
		InputStream is = getInputStreamByConfig(config);
		return new JtlHttpSampleReader(is);
	}
	
	public StreamReader<SampleMix> getSampleMixReaderByConfig(String config) {
		InputStream is = getInputStreamByConfig(config);
		return new JtlSampleMixReader(is);
	}
		
}
