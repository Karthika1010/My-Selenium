package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.WaitUtility;
import webDriverUtility.DriverAction;

public class PomUnitSearch {
	WebDriver driver;
	 WaitUtility wait;
	 DriverAction action;
public PomUnitSearch(WebDriver driver) {
		 
		 this.driver =driver;
			PageFactory.initElements(driver, this);
			wait =new WaitUtility(driver);	
			 action=new DriverAction(driver);
 }
	//@FindBy(xpath="//*[@id=\"tour_step5_menu\"]")
	//public WebElement products;
	//@FindBy(xpath="//*[@id=\\\"tour_step5\\\"]/ul/li[8]/a")
	//public WebElement units;
	@FindBy(xpath="//*[@id=\"unit_table_filter\"]/label/input")
	public WebElement unitsearch;
	@FindBy(xpath = "//table[@id='unit_table']//tbody//tr[1]//td[1]")
	public WebElement unitSearchResult;

	 public void search(String expectedValue) throws IOException {

			action.sendkeys(unitsearch, expectedValue);
		
		}
	 public String getUnitTablevalue() {
			
			String data = unitSearchResult.getText();
			return data;

		}

}
