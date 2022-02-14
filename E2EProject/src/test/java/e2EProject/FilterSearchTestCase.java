package e2EProject;

import org.testng.annotations.*;

import E2EProject.BrowseOpen;
import pageobjects.AfterSearchPage;
import pageobjects.LandingPage;




//@Listeners(ItestListners.Listeners.class)

public class FilterSearchTestCase extends BrowseOpen {

	@Test(priority = 2)
public void BusCount() {
		
		extent.createTest("Filter Test cases");
		LandingPage lp = new LandingPage(driver);

		lp.Login("Bapatla", "Hyderabad", "20");
	AfterSearchPage as=new AfterSearchPage(driver);
	
	as.totalbuscount();
	as.ACBusCount();
	as.SleeperBusCount();
	as.SeaterBusCount();
	extent.flush();
	
}
}
