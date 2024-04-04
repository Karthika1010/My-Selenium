package POM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.WaitUtility;
import webDriverUtility.DriverAction;

public class PomUnits {
	WebDriver driver;
	 WaitUtility wait;
	 DriverAction action;
public PomUnits(WebDriver driver) {
		 
		 this.driver =driver;
			PageFactory.initElements(driver, this);
			wait =new WaitUtility(driver);	
			 action=new DriverAction(driver);
	 }
	@FindBy(xpath="//*[@id=\"tour_step5_menu\"]")
	public WebElement products;
	@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[8]/a/span")
	public WebElement units;
	@FindBy(xpath="//button[@class=\"btn btn-block btn-primary btn-modal\"]")
	public WebElement addunits;

	 @FindBy(xpath="//*[@id=\"actual_name\"]")
		public WebElement name;
	 @FindBy(xpath="//*[@id=\"short_name\"]")
		public WebElement shortname;
	 @FindBy(xpath="//*[@id=\"allow_decimal\"]")
		public WebElement allowdecimal;
	 @FindBy(xpath="//*[@id=\"unit_add_form\"]/div[3]/button[1]")
		public WebElement savebtn;
	 
	 public void unit() throws InterruptedException {
		 //action.click(products);
		// Thread.sleep(6000);
			action.click(units);
			action.click(addunits);
			
		}
	 public void nameSendKeys(String expectedValue) throws IOException {

			action.sendkeys(name, expectedValue);

		}

		public void shortnameSendKeys(String expectedValue) throws IOException {

			action.sendkeys(shortname, expectedValue);

		}
		
		public void allowdecimalselectByvalue(String expectedValue) throws IOException {
			
			action.DropdownselectByvalue(allowdecimal, expectedValue);
		}
	 
		public void unitSave() {

			action.click(savebtn);

		}
		
	
}
