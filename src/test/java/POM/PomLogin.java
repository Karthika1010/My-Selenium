package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.WaitUtility;
import webDriverUtility.DriverAction;
import webDriverUtility.ReadExcelcode;

public class PomLogin {

	WebDriver driver;
	 WaitUtility wait;
	 DriverAction action;
	 
	 public PomLogin(WebDriver driver) {
		 
		 this.driver =driver;
			PageFactory.initElements(driver, this);
			wait =new WaitUtility(driver);	
			 action=new DriverAction(driver);
	 }
	 @FindBy(xpath="//*[@id='username']")
		public WebElement username;
	 @FindBy(xpath="//*[@id='password']")
		public WebElement password;
	 @FindBy(xpath="//button[@type='submit']")
		public WebElement loginbtn;
	 @FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/form/div[1]/div/span/strong")
	 public WebElement invalidMsg;


	 @FindBy(xpath="//*[@id=\"step-0\"]/div[3]/button[3]")
	 public WebElement endtour;
	
	 public void usernameSendKeys(String expectedValue) throws IOException {
	 
	
		action.sendkeys(username,expectedValue);
		
}
	 
	 public void passwordSendKeys(String expectedValue) throws IOException {
		 
			
			action.sendkeys(password,expectedValue);
			
	}
	
	 
		
	 public void clearFeilds() {
			username.clear();
			password.clear();		
		}
	

		public void clickLoginBtn() {

			action.click(loginbtn);

		}
		
		public void clickalertbtn() {
			
			action.click(endtour);
			 
			
		}

		public String getText() {
			String text = action.getText(invalidMsg);
			return text;
		}
}
		

