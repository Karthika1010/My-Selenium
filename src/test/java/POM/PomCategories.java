package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.WaitUtility;
import webDriverUtility.DriverAction;

public class PomCategories {
	WebDriver driver;
	 WaitUtility wait;
	 DriverAction action;
	 
	 public  PomCategories(WebDriver driver) {
		 
		 this.driver =driver;
			PageFactory.initElements(driver, this);
			wait =new WaitUtility(driver);	
			 action=new DriverAction(driver);
	 }
	//// @FindBy(xpath="//*[@id=\"tour_step5_menu\"]")
		//public WebElement products;
	 @FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[9]/a")
		public WebElement categories;
	 @FindBy(xpath="//button[@class=\"btn btn-block btn-primary btn-modal\"]")
		public WebElement addcategories;
	 @FindBy(xpath="//*[@id=\"name\"]")
		public WebElement categoryname;
	 @FindBy(xpath="//*[@id=\"short_code\"]")
		public WebElement categorycode;
	 @FindBy(xpath="//*[@id=\"category_add_form\"]/div[3]/button[1]")
		public WebElement savebtn;
	 public void category() throws InterruptedException {
		 //action.click(products);
		// Thread.sleep(6000);
			action.click(categories);
			action.click(addcategories);
			
		}
	 public void categorynameSendKeys(String expectedValue) throws IOException {

			action.sendkeys(categoryname, expectedValue);

		}

		public void categorycodeSendKeys(String expectedValue) throws IOException {

			action.sendkeys(categorycode, expectedValue);

		}

		public void categorySave() {

			action.click(savebtn);

	 
}
		}
