package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.WaitUtility;
import webDriverUtility.DriverAction;

public class PomAlerttour {

	WebDriver driver;
	 WaitUtility wait;
	 DriverAction action;
public PomAlerttour(WebDriver driver) {
		 
		 this.driver =driver;
			PageFactory.initElements(driver, this);
			wait =new WaitUtility(driver);	
			 action=new DriverAction(driver);
	 }
@FindBy(xpath="//*[@id=\"step-0\"]/div[3]/button[3]")
public WebElement endtour;

public void clickalertbtn() {
	
	action.click(endtour);
	 
	
}
}
