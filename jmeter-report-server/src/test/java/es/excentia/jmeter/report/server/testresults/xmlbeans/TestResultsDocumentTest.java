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
		Assert.assertNotNull("No se encontró en el classpath test-http.jtl.xml", is);
		
		XmlOptions options = new XmlOptions();
		Map<String, String> ns = new HashMap<String, String>(); 
	    ns.put("", JtlAbstractSampleReader.NAMESPACE); 
	    
	    options.setLoadSubstituteNamespaces(ns); 
		TestResultsDocument doc = TestResultsDocument.Factory.parse(is, options);
		
		TestResults testResults = doc.getTestResults();
		Assert.assertNotNull(testResults.getHttpSampleArray());
		Assert.assertTrue(testResults.getHttpSampleArray().length>0);
	}
    
}
