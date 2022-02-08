package E2EProject;


import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import pageobjects.LandingPage;
@Listeners(ItestListners.Listeners.class)
public class HomePage extends BrowseOpen 
{

	static Logger logger = Logger.getLogger(HomePage.class);  
	//extent.reporter.spark.start=true;
	//extent.reporter.spark.out=Reports/Spark.html;

	@Test
	public void pageinvok()  {
		
		//comment
		//comment2
		//DOMConfigurator.configure("Log4.xml");
		//logger.info("Browser open");
		LandingPage lp=new LandingPage(driver);
		
		lp.Login("Bapatla","Hyderabad","10");

		//logger.info("Browser closed");
	

		

	
	}

}
