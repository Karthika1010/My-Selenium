package extentreports;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentTestManager {
	public static ExtentReports extent;
	public static ExtentTest test;
	@BeforeSuite
	public void extendreportgenerate() {
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html"); 
	//create ExtentReports and attach reporter(s) 
	 extent = new ExtentReports(); 
	extent.attachReporter(htmlReporter);
	 
	
}
	@AfterSuite
	public void closereport()
	{
		extent.flush();
	}
	
	
}