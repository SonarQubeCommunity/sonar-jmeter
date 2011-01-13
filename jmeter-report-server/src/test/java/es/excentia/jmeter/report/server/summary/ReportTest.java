package es.excentia.jmeter.report.server.summary;

import org.junit.Test;

import es.excentia.jmeter.report.client.JMeterReportConst;
import es.excentia.jmeter.report.server.report.OkBytesAverage;
import es.excentia.jmeter.report.server.report.OkCounter;
import es.excentia.jmeter.report.server.report.OkResponseTimeAverage;
import es.excentia.jmeter.report.server.report.Report;
import es.excentia.jmeter.report.server.report.TransOrder;

public class ReportTest {
	
	@Test
	public void testReport() {
		
		Report report = new Report();

		report.addData(OkCounter.class, Report.SCOPE_ALL);
		report.addData(OkResponseTimeAverage.class, Report.SCOPE_ALL);
		report.addData(OkBytesAverage.class, Report.SCOPE_ALL);
		report.addData(TransOrder.class, Report.SCOPE_TRANS_GLOBAL);
		report.extract(JMeterReportConst.TEST_CONFIG_TRANS);
		
		System.out.print(report.toString());
	}
}
