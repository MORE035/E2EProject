package e2EProject;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import E2EProject.BrowseOpen;
import pageobjects.LandingPage;




public class BothDOJDORTestCase extends BrowseOpen {
	
	@Test(priority = 1)
	public void DOJDOR() {
		extent.createTest("DateOfJouerny and DateOfReturn TestCases");
		

	LandingPage lp=new LandingPage(driver);
	
	lp.Login("Bapatla","Hyderabad","15","16");
	extent.flush();
	
	}
}
