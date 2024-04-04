package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.WaitUtility;
import webDriverUtility.DriverAction;

public class PomCategorySearch {
	WebDriver driver;
	 WaitUtility wait;
	 DriverAction action;
	 
	 public  PomCategorySearch(WebDriver driver) {
		 
		 this.driver =driver;
			PageFactory.initElements(driver, this);
			wait =new WaitUtility(driver);	
			 action=new DriverAction(driver);
	 }
	
	 @FindBy(xpath="//*[@id=\"category_table_filter\"]/label/input")
		public WebElement categorysearch;
	 @FindBy(xpath = "//table[@id=\"category_table\"]//tbody/tr[1]/td[1]")
		public WebElement categorySearchResult;
	 public void search(String expectedValue) throws IOException {

			action.sendkeys(categorysearch, expectedValue);
		
		}
	 public String getcategoryTablevalue() {
			
			String data = categorySearchResult.getText();
			return data;

		}

}
