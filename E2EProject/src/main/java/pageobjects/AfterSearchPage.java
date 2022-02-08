package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E2EProject.BrowseOpen;

public class AfterSearchPage  extends BrowseOpen{
	
	@FindBy(xpath = "//span[@class='f-left sidebar-header']")
	WebElement Filter;
	
	
	
	public AfterSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}



	//----------bus list verifivation----------------
	public boolean verification() {
		
		Filter.isDisplayed();
		return true;
	}

}
