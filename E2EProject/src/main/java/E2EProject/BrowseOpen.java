package E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BrowseOpen {
	public static WebDriver driver=null;
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
	public String getScreenShot() throws Exception
	{
		Date dd=new Date();
		String ss1 = dd.toString().replace(" ","_").replace(":", "_");
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 String screenshotpath =  System.getProperty("user.dir")+"/Screenshots/"+ss1+".png";
		 File DestFile=new File(screenshotpath);
		 FileUtils.copyFile(SrcFile, DestFile);
		 return screenshotpath;
	}

@AfterMethod
	public void Screenshots(ITestResult result) throws IOException {
		  if (result.getStatus() == ITestResult.FAILURE) {
		try {
			test.log(LogStatus.FAIL, test.addScreenCapture(getScreenShot()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}

}


	
	@AfterSuite
	public void flashout() {
		report.endTest(test);
		report.flush();	
		driver.close();

	}

	
	
	

	
	
}
