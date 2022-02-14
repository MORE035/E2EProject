package extendReports;

import java.util.Date;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import E2EProject.BrowseOpen;

public class ExtendReportManager  extends BrowseOpen {

	@BeforeTest
	public void startup() {
		    
	        // create ExtentReports and attach reporter(s)
		Date dd=new Date();
	String cdate = dd.toString().replace(" ","").replace(":", "_");

	
		  htmlReporter = new ExtentSparkReporter(".//extentreport//"+cdate+".html");

	         extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        htmlReporter.config().setReportName("Automation Results");
	        htmlReporter.config().setDocumentTitle("Test Results");
	        extent.setSystemInfo("Tester", "Vasanth");

}}