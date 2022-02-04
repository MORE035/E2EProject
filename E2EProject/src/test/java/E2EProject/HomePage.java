package E2EProject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.TestNGMethod;
import org.w3c.dom.DOMConfiguration;

import pageobjects.LandingPage;
@Listeners(ItestListners.Listeners.class)
public class HomePage extends BrowseOpen 
{

	static Logger logger = Logger.getLogger(HomePage.class);  
	@Test
	public void pageinvok() throws IOException {
		
		//comment
		//comment2
		//DOMConfigurator.configure("Log4.xml");
		//logger.info("Browser open");
		LandingPage lp=new LandingPage(driver);
		
		lp.Login("Bapatla","Hyderabad","March ");

		logger.info("Browser closed");

		

	
	}

}
