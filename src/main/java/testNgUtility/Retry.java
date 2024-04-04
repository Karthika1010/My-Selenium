package testNgUtility;



import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import extentreports.ExtentTestManager;

public class Retry implements IRetryAnalyzer  {
    private int retryCount = 0;
    public int maxRetryCount = 2;

// Below method returns 'true' if the test method has to be retried else 'false' 
//and it takes the 'Result' as parameter of the test method that just ran
    public boolean retry(ITestResult result) {
    	//ExtentTestManager=new ExtentTestManager();
    
    	System.out.println("test result  " +result.getStatus());

		if(result.getStatus()==1){
			ExtentTestManager.test.log(Status.PASS, result.getTestName());
                }
		
    	
    	if(retryCount==2) {
    	
    		
    		if(result.getStatus()==2){
    			ExtentTestManager.test.log(Status.FAIL, result.getTestName());
                    }
    	  }
    	  
    	
    	
        if (retryCount < maxRetryCount) {
            System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
            retryCount++;
            return true;
        }
        else {
        	
        
        	
        return false;
        }
       
        
        
       
        	
        
    }
    
    public String getResultStatusName(int status) {
    	String resultName = null;
    	if(status==1)
    		resultName = "SUCCESS";
    	if(status==2)
    		resultName = "FAILURE";
    	if(status==3)
    		resultName = "SKIP";
		return resultName;
    } }

	



	

