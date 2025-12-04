package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports=new ExtentReports();
	public synchronized static ExtentReports createExtentReports() {
	ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
	reporter.config().setReportName("7RMartSupermarketProject");
	extentReports.attachReporter(reporter);

	extentReports.setSystemInfo("Organization", "Obsqura");
	extentReports.setSystemInfo("Name", "Jeena"); // provides context of the report
	return extentReports;
	//extentReportUtility configure with in listner
	}

}
