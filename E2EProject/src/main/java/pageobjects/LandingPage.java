package pageobjects;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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
	
	@FindBy(xpath = "//ul[@id=\"ui-id-1\"]/li")
	List<WebElement> listofL;
	@FindBy(xpath = "//ul[@id=\"ui-id-2\"]/li")
	List<WebElement> listofG;
	@FindBy(id = "datepicker1")
	WebElement DOJ;
	@FindBy(xpath = "(//div[@class=\"ui-datepicker-title\"]//span[@class=\"ui-datepicker-month\"])[1]")
	WebElement month;
	@FindBy(xpath = "//a[@class=\"ui-datepicker-next ui-corner-all\"]/span")
	WebElement Next;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Login(String Source ,String Dest,String Month) {
		Leaving.clear();
		Leaving.sendKeys(Source);
		for (int i = 0; i < listofL.size(); i++) {
			if(listofL.equals(Source)) {
			listofL.get(i).click();
		}}
		Going.clear();

		Going.sendKeys(Dest);

		for (int i = 0; i < listofG.size(); i++) {
			if(listofG.contains(Dest)) {
			listofG.get(i).click();
		}}
		DOJ.click();
		String seleniumMonth = month.getText();
		System.out.println(seleniumMonth);

		while(seleniumMonth!=(Month)) {
			Next.click();
			seleniumMonth = month.getText();
			System.out.println("selenium generated month   "+seleniumMonth);
		}
	}

}
