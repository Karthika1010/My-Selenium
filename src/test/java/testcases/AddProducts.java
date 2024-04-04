package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import POM.PomAddProducts;
import extentreports.ExtentTestManager;
import webDriverUtility.BrowserUtility;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class AddProducts extends ExtentTestManager {
	
	 public static WebDriver driver; 
	 PomAddProducts objproduct;
	 
  @Test(groups= {"functional"},priority=10,description="user is able to add products",enabled=true)
  public void addProduct() throws InterruptedException, IOException {
	  BrowserUtility objutil = new BrowserUtility();
	  driver = objutil.baseDriver();
	  Thread.sleep(6000); 
	  objproduct=new PomAddProducts(driver);
	  objproduct.productMenuClick();
	  objproduct.addproductName("parker Pen");
	  Thread.sleep(2000);	  
	  objproduct.selectBrand();
	  Thread.sleep(2000);	  
	  objproduct.selectUnit();
	  Thread.sleep(2000);	  
	  objproduct.selectBarcodeType();
	  Thread.sleep(2000);	 
	  objproduct.addselectAlertQty("20");
	  Thread.sleep(2000);
	  objproduct.addpurchaseIncTax("4");
	  Thread.sleep(2000);
	  objproduct.addexpiry("15");
	  objproduct.productSaveBtnClick();
	  test.log(Status.PASS, "Test validate Add products");
	  Thread.sleep(2000);
	  objutil.Screenshot();
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
