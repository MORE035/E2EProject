package E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BrowseOpen {
	public static WebDriver driver;
	File file = new File("C:\\Users\\SPURGE\\eclipse-workspace\\E2EProject\\src\\main\\java\\E2EProject\\InitialSetUp");

	Properties prop = new Properties();
	public static ExtentReports report;
	public static ExtentTest test;
	public String url;
	

	@BeforeSuite
	public void open() throws IOException {

		FileInputStream fi = new FileInputStream(file);

		prop.load(fi);
	//	test.log(LogStatus.INFO, "File loaded");
		 url = (String) prop.get("url");


	//	test.log(LogStatus.INFO, "Browser name entered");
	//	test.log(LogStatus.valueOf(BrowserName),"invoked");


		Object BName = prop.get("BrowserName");
		if (BName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();

		} else if (BName.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "Browsers/geckodriver.exe");
			driver = new FirefoxDriver();


		} else if (BName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "Browsers/msedgedriver.exe");
			driver = new EdgeDriver();


		}
	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

	}
/*	@BeforeTest
	public void getbrowser() {
		driver.get(url);

	}
*/	
	@BeforeSuite
	public void startup() {
		    
		Date dd=new Date();
		String cdate = dd.toString().replace(" ","_").replace(":", "_");
//----------------------------------------------------------------------------------------------------
//-----ExtentReports for provide by relevent codes--------------------------------------------------
		report=new ExtentReports((".//extentreportByReleventCodes//"+cdate+".html"), true);
//--------------------------------------------------------------------------------------------------
	
	}

	
	@AfterSuite
	public void flashout() {
		report.endTest(test);
		report.flush();	
		driver.close();

	}

	
	
	

	
	
}
