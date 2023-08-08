package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports createReports() {
		
		ExtentSparkReporter htmlReports = new ExtentSparkReporter("extentReports.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReports);
		extent.setSystemInfo("Facebook", "RegressionTest");
		extent.setSystemInfo("Tested By", "Subodh");
		return extent;
	}
	
}
