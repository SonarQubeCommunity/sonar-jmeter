package es.excentia.jmeter.report.server.service;

import org.junit.Test;

import es.excentia.jmeter.report.client.JMeterReportConst;


public class OperationServiceTest {

	protected OperationService operationService = ServiceFactory.get(OperationService.class);
	
	@Test
	public void testWriteBucketMetrics() {
		operationService.writeBucketMeasures(
			System.out, JMeterReportConst.TEST_CONFIG_TRANS, 
			"BucketAvgResponseTime", 500
		);
	}
	
}
