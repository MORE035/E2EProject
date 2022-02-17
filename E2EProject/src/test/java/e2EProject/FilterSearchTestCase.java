package e2EProject;

import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import E2EProject.BrowseOpen;
import pageobjects.AfterSearchPage;
import pageobjects.LandingPage;




//@Listeners(ItestListners.Listeners.class)

public class FilterSearchTestCase extends BrowseOpen {

	@Test()
public void BusCount() {
		test=report.startTest("FilterSearchTestCase");

		LandingPage lp = new LandingPage(driver);

		lp.Login("Bapatla", "Hyderabad", "20");
	AfterSearchPage as=new AfterSearchPage(driver);
	
	as.totalbuscount();
	as.ACBusCount();
	as.SleeperBusCount();
	as.SeaterBusCount();
	test.log(LogStatus.INFO, "test end");


}
}
