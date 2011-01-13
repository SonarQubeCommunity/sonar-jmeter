package es.excentia.jmeter.report.server.service;

import org.junit.Assert;
import org.junit.Test;


public class ConfigServiceTest {

	protected ConfigService configService = ServiceFactory.get(ConfigService.class);
	
	@Test
	public void testLoadJTLConfigAFileNotFound() {
		boolean error = false;
		
		try {
			configService.getAbstractSampleReaderByConfig("A");
		} catch (Exception e) {
			error = true;
			Assert.assertTrue(e.getMessage().startsWith("JTL file defined"));
		}
		
		Assert.assertTrue(error);
	}
	
}
