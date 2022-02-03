package E2EProject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.w3c.dom.DOMConfiguration;

import pageobjects.LandingPage;

public class HomePage extends BrowseOpen
{
	 static Logger logger = Logger.getLogger(HomePage.class);  
	@Test
	public void pageinvok() throws IOException {
		
		//comment
		
		open();
		DOMConfigurator.configure("Log4.xml");
		logger.info("Browser open");
		LandingPage lp=new LandingPage(driver);
		
		lp.Login("Tirupati","Hyderabad","March ");

		driver=close();
		logger.info("Browser closed");

		

	
	}

}
