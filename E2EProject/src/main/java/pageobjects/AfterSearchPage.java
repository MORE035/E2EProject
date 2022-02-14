package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E2EProject.BrowseOpen;

public class AfterSearchPage  extends BrowseOpen{
	
	@FindBy(xpath = "//span[@class='f-left sidebar-header']")
	WebElement Filter;
	@FindBy(xpath = "//div[@class='travele clearfix rSet ng-scope']")
	List<WebElement> buslist;
	@FindBy(xpath = "(//a[@class='text-red']//small)[1]")
	WebElement clearAllFilter;
	@FindBy(id = "Bustypes1")
	WebElement acbus;
	@FindBy(id = "Bustypes2")
	WebElement nonacbus;
	@FindBy(id = "Bustypes3")
	WebElement seater;
	@FindBy(id = "Bustypes4")
	WebElement sleeper;
	public AfterSearchPage(WebDriver driver) {
		BrowseOpen.driver = driver;
		PageFactory.initElements(driver, this);

	}



	//----------bus list verifivation----------------
	public boolean verification() {
		
		Filter.isDisplayed();
		return true;
	}
	public void totalbuscount() {
		
	int numberofbuses = buslist.size();
	
	System.out.println("Total buses  =  "+ numberofbuses);
	}
	public void ACBusCount() {
		clearAllFilter.click();
		acbus.click();
		int numberofbuses = buslist.size();
		
		System.out.println("Total ac buses  =  "+ numberofbuses);
		
	}
	public void SleeperBusCount() {
		clearAllFilter.click();
		sleeper.click();
		int numberofbuses = buslist.size();
		
		System.out.println("Total sleeper buses  =  "+ numberofbuses);
		
	}
	public void SeaterBusCount() {
		clearAllFilter.click();
		seater.click();
		int numberofbuses = buslist.size();
		
		System.out.println("Total seater buses  =  "+ numberofbuses);
		
	}

}
