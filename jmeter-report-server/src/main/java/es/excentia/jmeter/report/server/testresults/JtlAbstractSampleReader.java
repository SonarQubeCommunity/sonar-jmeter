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

package es.excentia.jmeter.report.server.testresults;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.excentia.jmeter.report.client.serialization.StreamReader;
import es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample;
import es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument;

/**
 * Reader to get first level Samples and HttpSamples from jtl xml file.
 * This reader is at the most lower level and his function is to
 * translate xml into objects using xmlbeans.
 * 
 * Read method returns only one first level Sample or HttpSample 
 * for each call, but each returned object will contain
 * descendant elements info inside.
 * 
 * Read process with stax and xmlbeans extracted from 
 * http://www.devx.com/xml/Article/34037/1954 by Michael Pilone.
 * 
 * @author cfillol
 */
public class JtlAbstractSampleReader extends StreamReader<AbstractSample> {

  public static final String NAMESPACE = "http://xmlbeans.testresults.server.report.jmeter.excentia.es";

  private static final int NODE_READ_BUFFER_MAX_BYTES = 1024 * 1024;

  private static final String HTTPSAMPLE_TAG_NAME = "httpSample";
  private static final String SAMPLE_TAG_NAME = "sample";

  private static final Logger log = LoggerFactory
      .getLogger(JtlAbstractSampleReader.class);
  private static final boolean LOG_DEBUG = log.isDebugEnabled();
  private static final boolean LOG_TRACE = log.isTraceEnabled();

  protected XMLEventReader reader;
  protected XMLEventWriter writer;
  protected XmlOptions options;
  protected XmlOptions validationOptions;
  protected List<XmlValidationError> validationErrors = new ArrayList<XmlValidationError>();
  protected ResettableStringWriter swriter;
  protected int readCount = 0;

  public JtlAbstractSampleReader(InputStream is) {
    super(is);

    if (LOG_DEBUG) {
      log.debug("Creating JtlAbstractSampleReader ...");
    }

    try {

      // Create the input reader to read the file. We will
      // use the defaults here, but it could be configured
      // using the properties.
      XMLInputFactory inFactory = XMLInputFactory.newInstance();
      reader = inFactory.createXMLEventReader(is);

      // Create an output writer. The writer uses the resetable
      // buffer so we can use the same writer continuously.
      XMLOutputFactory outFactory = XMLOutputFactory.newInstance();
      outFactory.setProperty("javax.xml.stream.isRepairingNamespaces", true);
      swriter = new ResettableStringWriter(NODE_READ_BUFFER_MAX_BYTES);
      writer = outFactory.createXMLEventWriter(swriter);

      options = new XmlOptions();
      Map<String, String> ns = new HashMap<String, String>();
      ns.put("", NAMESPACE);
      options.setLoadSubstituteNamespaces(ns);
      options.setDocumentType(TestResultsDocument.TestResults.type);

      validationOptions = new XmlOptions();
      validationOptions.setErrorListener(validationErrors);

    } catch (XMLStreamException e) {
      if (LOG_DEBUG) {
        log.debug("Cannot create JtlReader", e);
      }
      throw new JtlReaderException("Cannot create JtlReader", e);
    }
  }
  

  /**
   * Returns one first level Sample or one HttpSample for each call,
   * that contains child info inside.
   */
  @Override
  public AbstractSample read() {
    try {
      
      // Begin reading events
      int sampleDepth = 0;
      while (reader.hasNext()) {
  
        XMLEvent evt = reader.nextEvent();
        
  
        if (evt.isStartElement()) {
          StartElement elem = (StartElement) evt;
          String tagName = elem.getName().getLocalPart();
          if (HTTPSAMPLE_TAG_NAME.equals(tagName)
              || SAMPLE_TAG_NAME.equals(tagName)) {
            
            // Empieza un HttpSample ...
            sampleDepth++;
          }
        } 
  
        
        if (sampleDepth > 0) {
          // Sample o HttpSample. Take xml from sample and all its descendants
          writer.add(evt);
        } else {
          // Root node. Discard info but include text into xml 
          // so it will be valid
          writer.add(evt);
          writer.flush();
          swriter.reset();
        }
        
        
        if (evt.isEndElement()) {
          EndElement elem = (EndElement) evt;
          String tagName = elem.getName().getLocalPart();
          if (HTTPSAMPLE_TAG_NAME.equals(tagName)
              || SAMPLE_TAG_NAME.equals(tagName)) {
            
            // HttpSample or Sample ends ...
            
            readCount++; // Update read elements counter
  
            if (sampleDepth == 1) {
              // End of parent Sample/HttpSample
              // Save xml and return object
  
              // Get xml from buffer and reset
              writer.flush();
              String sampleXml = swriter.reset();
  
              if (LOG_TRACE) {
                log.trace(sampleXml);
              }
  
              // Convert xml into XmlBeans object
              // We have to use container node TestResults to save inner html
              TestResultsDocument.TestResults testResults = (TestResultsDocument.TestResults) XmlObject.Factory
                  .parse(sampleXml, options);
              if (!testResults.validate(validationOptions)) {
                throw new JtlReaderException(validationErrors.get(0).toString());
              }
  
              // Return read sample
              if (HTTPSAMPLE_TAG_NAME.equals(tagName)) {
                return testResults.getHttpSampleArray(0);
              } else {
                return testResults.getSampleArray(0);
              }
            }
            
            sampleDepth--;
          }
  
        }
        
      }
  
      if (LOG_DEBUG) {
        log.debug(String.format("JtlAbstractSampleReader read %d nodes",
            readCount));
      }
  
      return null;
    
    } catch (XMLStreamException e) {
      throw new JtlReaderException(e);
    } catch (XmlException e) {
      throw new JtlReaderException(e);
    }
  
  }
  
}
