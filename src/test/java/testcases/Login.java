package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import excelutility.ReadExcelcode;
import extentreports.ExtentTestManager;
import POM.PomUnits;
import POM.PomAlerttour;
import POM.PomLogin;
import webDriverUtility.BrowserUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login extends ExtentTestManager {
  public static WebDriver driver; 
  PomLogin login;
  PomAlerttour alert;
  //AddUnits unit;
  ReadExcelcode objLogin;
  
  @Test(priority=2,groups= {"functional"},description = "Verify whether user is able to login with valid username and valid password",enabled=true)	
	
   public void Login() throws IOException, InterruptedException {
	  objLogin = new ReadExcelcode();
		//System.out.println("hello");
		String expectedusername = objLogin.readStringData(1, 0);
		String expectedpwd = objLogin.readIntegerData(1, 1);	
		login = new PomLogin(driver);
		login.usernameSendKeys(expectedusername);
		login.passwordSendKeys(expectedpwd);
		login.clickLoginBtn();
		String currUrlActl = driver.getCurrentUrl();
		String currUrlExpct = "https://qalegend.com/billing/public/products";
		Assert.assertEquals(currUrlActl, currUrlExpct);
		test.log(Status.PASS, "Valid login testcase validation");
		
		Thread.sleep(5000);
	 }
  @Test(priority=3,groups= {"functional"},enabled=true)
  public void alerttour()
  {
	  alert = new PomAlerttour(driver);
	  alert.clickalertbtn();
	  test.log(Status.PASS, "Test validate alert");
  }
  
  
  @Test(priority = 1,groups= {"functional"},dataProvider="data-provider",enabled=true)	
	
 public void Invalidlogin(String value,String value1) throws IOException, InterruptedException {
	  
		
		login = new PomLogin(driver);
		login.usernameSendKeys(value);
		login.passwordSendKeys(value1);
		login.clickLoginBtn();
		String actualMessage = login.getText();
		String expectedMessage = "These credentials do not match our records.";
		Assert.assertEquals(expectedMessage, actualMessage);
		test.log(Status.PASS, "invalid login testcase validation");
		Thread.sleep(1000);
		
  }
 
  
  
  @BeforeTest
  @Parameters({"Browser","Url"})
  public void beforeTest(String Browser,String Url) {
	  BrowserUtility objutil = new BrowserUtility(); 
		objutil.launchBrowser(Browser, Url); 
		driver =objutil.baseDriver();
		 test=extent.createTest("test case for product creation", "test  validate product");
		
  }

 // @AfterTest
 // public void afterTest() {
	// driver.close(); 
  //}
  @DataProvider (name = "data-provider")
  public Object[][] dpMethod(){
	 return new Object[][] {{"admin","123456A"}};
  }
}

