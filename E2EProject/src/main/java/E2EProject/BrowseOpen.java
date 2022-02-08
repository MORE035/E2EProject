package E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BrowseOpen {
	public WebDriver driver;
	File file = new File("C:\\Users\\SPURGE\\eclipse-workspace\\E2EProject\\src\\main\\java\\E2EProject\\InitialSetUp");

	Properties prop = new Properties();
	public  ExtentReports extent;
	public ExtentSparkReporter htmlReporter;
	@BeforeSuite
	public void startup() {
		  htmlReporter = new ExtentSparkReporter("extent.html");
		    
	        // create ExtentReports and attach reporter(s)
	         extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
		
	}
	@AfterSuite
	public void flashout() {
		 extent.flush();
		
	}
	

	@BeforeTest
	public void open() throws IOException {

		FileInputStream fi = new FileInputStream(file);

		prop.load(fi);
		String url = (String) prop.get("url");

		System.out.println(url);

		System.out.println(prop.get("BrowserName"));
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
	@AfterTest
	public void  close() {
		driver.close();
	}
	
}
