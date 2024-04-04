package POM;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtility.WaitUtility;
import webDriverUtility.DriverAction;

public class PomBrands {
	
	WebDriver driver;
	 WaitUtility wait;
	 DriverAction action;
	 
	 public  PomBrands(WebDriver driver) {
		 
		 this.driver =driver;
			PageFactory.initElements(driver, this);
			wait =new WaitUtility(driver);	
			 action=new DriverAction(driver);
	 }
	 @FindBy(xpath="//*[@id=\"tour_step5_menu\"]")
		public WebElement products;
	 @FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[10]/a/span")
		public WebElement brands;
	 @FindBy(xpath = "/html/body/div[2]/div[1]/section[1]")
		public By brandpageHeader;
		
		@FindBy(xpath = "//*[@id=\"toast-container\"]/div/div")
		public By brandSaveConfirmation;
	 @FindBy(xpath="//button[@class=\"btn btn-block btn-primary btn-modal\"]")
		public WebElement addbrands;
	 @FindBy(xpath="//*[@id=\"name\"]")
		public WebElement brandName;
	 @FindBy(xpath="//*[@id=\"description\"]")
	 public WebElement brandDescription;
	 @FindBy(xpath="//*[@id=\"brand_add_form\"]/div[3]/button[1]")
		public WebElement savebtn;
	 
	
	 public void brand() throws InterruptedException {
		 //action.click(products);
		// Thread.sleep(6000);
			action.click(brands);
			action.click(addbrands);
			
		}

		public void brandNameSendKeys(String expectedValue) throws IOException {

			action.sendkeys(brandName, expectedValue);

		}

		public void brandDescriptionSendKeys(String expectedValue) throws IOException {

			action.sendkeys(brandDescription, expectedValue);

		}

		public void brandSave() {

			action.click(savebtn);

		}

		
	
}

	
	


