package e2EProject;



import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import E2EProject.BrowseOpen;
import pageobjects.AfterSearchPage;
import pageobjects.LandingPage;


//@Listeners(ItestListners.Listeners.class)
public class HomePageTestCase extends BrowseOpen 
{

	static Logger logger = Logger.getLogger(HomePageTestCase.class);  
	//extent.reporter.spark.start=true;
	//extent.reporter.spark.out=Reports/Spark.html;

	@Test(testName = "valid data bus search")
	public void pageinvok()  {
		
		//comment
		//comment2
	test=report.startTest("Valid data bus Search");
		DOMConfigurator.configure("Log4.xml");
		logger.info("Browser open");
		LandingPage lp=new LandingPage(driver);
		
		lp.Login("Bapatla","Hyderabad","15");

		logger.info("Browser closed");
	

		AfterSearchPage as=new AfterSearchPage(driver);
		Assert.assertTrue(as.verification());

		test.log(LogStatus.INFO, "test end");
		report.flush();

	}

}
