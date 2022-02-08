package extendReports;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import E2EProject.BrowseOpen;

public class ExtendReportManager  extends BrowseOpen {

	 public static final ExtentReports extentReports = new ExtentReports();
	 @BeforeTest
	    public synchronized static ExtentReports createExtentReports() {
	        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
	        reporter.config().setReportName("Sample Extent Report");
	        extentReports.attachReporter(reporter);
	        extentReports.setSystemInfo("Blog Name", "SW Test Academy");
	        extentReports.setSystemInfo("Author", "Onur Baskirt");
	        return extentReports;
	    }
	}

