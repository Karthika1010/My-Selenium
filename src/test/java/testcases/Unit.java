package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import POM.PomBrandSearch;
import POM.PomBrands;
import POM.PomUnitSearch;
import POM.PomUnits;
import commonUtility.ConfigFileReader;
import extentreports.ExtentTestManager;
import webDriverUtility.BrowserUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Unit extends ExtentTestManager{
	 public static WebDriver driver; 
	 PomUnits objUnits;
	 PomUnitSearch objunitsearch;
	 ConfigFileReader objconfigreader;
	
  @Test(groups= {"functional"},priority=8,description="user is able to add unit",enabled=true)
  public void unitadd() throws InterruptedException, IOException {
	  BrowserUtility objutil = new BrowserUtility();
	  driver = objutil.baseDriver();
	  Thread.sleep(7000);
	  
	  objUnits = new PomUnits(driver);
	  
	  objUnits.unit();
	  Thread.sleep(7000);
	  objUnits.nameSendKeys("Large box");
	  Thread.sleep(4000);
	  objUnits.shortnameSendKeys("boxes288");
	  Thread.sleep(4000);
	  objUnits.allowdecimalselectByvalue("1");
	  objUnits.unitSave();
	  test.log(Status.PASS, "Test validate add unit");
	  Thread.sleep(7000);
  }
	  @Test(groups= {"functional"},priority=9,description="user is able to search with unitname",enabled=true)
	  public void unitsearch() throws IOException, InterruptedException {
	objunitsearch=new PomUnitSearch(driver);
	  objconfigreader=new ConfigFileReader();
	  String searchValue2  =ConfigFileReader.readConfigFile("searchValue2");
	  objunitsearch.search(searchValue2);
		Thread.sleep(2000);
		String data =  objunitsearch.getUnitTablevalue();
		Thread.sleep(4000);
		Assert.assertEquals(searchValue2, data);
		test.log(Status.PASS, "Test validate  unit search");
  }
	

	  }

