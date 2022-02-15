package e2EProject;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import E2EProject.BrowseOpen;
import pageobjects.LandingPage;




public class BothDOJDORTestCase extends BrowseOpen {
	
	@Test()
	public void DOJDOR() {
		test=report.startTest("BothDOJDORTestCase");
		

	LandingPage lp=new LandingPage(driver);
	
	lp.Login("Bapatla","Hyderabad","20","21");
	test.log(LogStatus.INFO, "test end");


	
	}
}
