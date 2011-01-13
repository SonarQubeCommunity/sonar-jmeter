package es.excentia.jmeter.report.server.testresults;

import java.io.InputStream;

import junit.framework.Assert;

import org.junit.Test;

import es.excentia.jmeter.report.client.JMeterReportConst;
import es.excentia.jmeter.report.server.testresults.JtlAbstractSampleReader;
import es.excentia.jmeter.report.server.testresults.xmlbeans.AbstractSample;

public class JtlReaderTest {
		
	@Test
	public void testReadJtlFile() throws Exception {
		for (String config : JMeterReportConst.TEST_CONFIGS) {
			InputStream is = getClass().getResourceAsStream("/"+config+".jtl.xml");
			Assert.assertNotNull("No se encontró en el classpath "+config+".jtl.xml", is);
			
			JtlAbstractSampleReader jtlReader = new JtlAbstractSampleReader(is);
			AbstractSample sample = jtlReader.read();
			while (sample!=null) {
				Assert.assertTrue(sample.getTs()>-1);
				sample = jtlReader.read();
			}
		}
	}
}
