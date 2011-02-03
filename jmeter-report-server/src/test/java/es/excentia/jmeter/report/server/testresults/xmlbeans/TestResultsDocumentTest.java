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

package es.excentia.jmeter.report.server.testresults.xmlbeans;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.apache.xmlbeans.XmlOptions;
import org.junit.Test;

import es.excentia.jmeter.report.server.testresults.JtlAbstractSampleReader;
import es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument;
import es.excentia.jmeter.report.server.testresults.xmlbeans.TestResultsDocument.TestResults;

public class TestResultsDocumentTest {

  @Test
  public void testLoadFile() throws Exception {

    // Bind the incoming XML to an XMLBeans type.
    InputStream is = getClass().getResourceAsStream("/test-http.jtl.xml");
    Assert
        .assertNotNull("No se encontró en el classpath test-http.jtl.xml", is);

    XmlOptions options = new XmlOptions();
    Map<String, String> ns = new HashMap<String, String>();
    ns.put("", JtlAbstractSampleReader.NAMESPACE);

    options.setLoadSubstituteNamespaces(ns);
    TestResultsDocument doc = TestResultsDocument.Factory.parse(is, options);

    TestResults testResults = doc.getTestResults();
    Assert.assertNotNull(testResults.getHttpSampleArray());
    Assert.assertTrue(testResults.getHttpSampleArray().length > 0);
  }

}
