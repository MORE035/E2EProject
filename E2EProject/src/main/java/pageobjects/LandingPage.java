package pageobjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E2EProject.BrowseOpen;

public class LandingPage extends BrowseOpen {

	@FindBy(id = "source")
	WebElement Leaving;

	@FindBy(id = "destination")
	WebElement Going;
	@FindBy(name = "rkgjzvmj")
	WebElement DateJourney;
	@FindBy(tagName = "Search")
	WebElement Search;
	
	@FindBy(xpath = "//ul[@id='ui-id-1\']/li")
	List<WebElement> listofL;
	@FindBy(xpath = "//ul[@id='ui-id-2']/li")
	List<WebElement> listofG;
	@FindBy(id = "datepicker1")
	WebElement DOJ;
	@FindBy(xpath = "(//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-month'])[1]")
	WebElement month;
	@FindBy(xpath = "//a[@class='ui-datepicker-next ui-corner-all']/span")
	WebElement Next;
	@FindBy(tagName="tr")
	List<WebElement> trElements;
	@FindBy(tagName="td")
	List<WebElement> tdElements;
	@FindBy(xpath = "//*[@onclick='javascript:validateSearch();']")
	WebElement search;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Login(String Source ,String Dest,String date)  {
		//---Leaving from code----------------------------------------
		Leaving.clear();
		Leaving.sendKeys(Source);
		for (int i = 0; i < listofL.size(); i++) {
			if(listofL.get(i).getText().contains(Source)) {
			listofL.get(i).click();
		}}
		//-------------------------------------------------------------
		//-----------------Going to code---------------------------------
		Going.clear();

		Going.sendKeys(Dest);

		for (int i = 0; i < listofG.size(); i++) {
			if(listofG.get(i).getText().contains(Dest)) {
			listofG.get(i).click();
		}}
		//-------------------------------------------------------------------------
		//----------------Date code--------------------------------------------
		DOJ.click();
		/*	String seleniumMonth = month.getText().trim();
		System.out.println(seleniumMonth);

		while(!seleniumMonth.contains(Month)) {
			Next.click(); 
			seleniumMonth = month.getText();
				}
				*/
		for (int i = 1; i < trElements.size(); i++) {
			for (int j = 0; j < tdElements.size(); j++) {
				String seleniumdate = tdElements.get(j).getText();
				if (seleniumdate.contains(date)) {
					tdElements.get(j).click();
					break;
				}
			}
			
		}
	//--------------------------------------------------------------------
	//-----------search code-------------------------
		search.click();
		
}

}
