package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.WaitUtility;
import webDriverUtility.DriverAction;

public class PomBrandSearch {
	WebDriver driver;
	 WaitUtility wait;
	 DriverAction action;
	 
	 public  PomBrandSearch(WebDriver driver) {
		 
		 this.driver =driver;
			PageFactory.initElements(driver, this);
			wait =new WaitUtility(driver);	
			 action=new DriverAction(driver);
	 }
	
	@FindBy(xpath="//*[@id=\"brands_table_filter\"]/label/input")
	public WebElement brandsearch;
	@FindBy(xpath = "//table[@id='brands_table']//tbody//tr[1]//td[1]")
	public WebElement brandSearchResult;

	public void search(String expectedValue) throws IOException {

		action.sendkeys(brandsearch, expectedValue);
		
	
	}
	
	public String getBrandTablevalue() {
		
		String data = brandSearchResult.getText();
		return data;

	}


}
