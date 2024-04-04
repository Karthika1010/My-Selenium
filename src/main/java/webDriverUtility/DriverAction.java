package webDriverUtility;

//import javax.swing.JInternalFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.html.HTMLIFrameElement;

public class DriverAction {
	WebDriver driver;
	private String iframe;
public DriverAction(WebDriver driver)
{
	this.driver=driver;

}

//Common method implementation for By
	public void click(By value) {
		driver.findElement(value).click();
	}
	
	public void sendkeys(By value,String value1) {
		driver.findElement(value).clear();
		driver.findElement(value).sendKeys(value1);
	}
	public String getText(WebElement invalidMsg) {
		String Value = invalidMsg.getText();
		return Value;
	}
	
	public void DropdownselectByvalue(By dropdown,String value)
	{
		
		WebElement drop = driver.findElement(dropdown);
		Select objSelect = new Select(drop);
		objSelect.selectByValue(value);
		
		
	}
	public void DropdownselectByIndex(By dropdown,int value) {
		WebElement drop = driver.findElement(dropdown);
		Select objSelect = new Select(drop);
		objSelect.selectByIndex(value);
	}
	
	public void Alertaccept() {
		org.openqa.selenium.Alert objalert= driver.switchTo().alert();
		objalert.accept();
		
	}
	public void Alertdismiss()
	{
		org.openqa.selenium.Alert objalert= driver.switchTo().alert();
		objalert.dismiss();
	}
	
	
	
	public void iframes(By value) { 
		driver.findElement(value);
		driver.switchTo().frame(iframe);
		 }
	 
	 public void Javascripttestcase(WebElement Inputform) 
	 { 
	 
	 JavascriptExecutor js = (JavascriptExecutor)driver; 
	    js.executeScript("arguments[0].click();",Inputform); 
	    js.executeAsyncScript("window.scrollBy(0,document.body.scrollHeight)"); 
	
}
	 public void Actiontestcase(WebElement element,Actions action )
	 {
		
		action.moveToElement(element).contextClick().perform();
		 
	 }

//Common method implementation for webelement

	 public void click(WebElement value) {
		 value.click();
		}
	 
	 public void sendkeys(WebElement value,String value1) {
		 value.clear();
		 value.sendKeys(value1);
		}
	 
	 public void DropdownselectByvalue(WebElement dropdown,String value)
		{
			Select objSelect = new Select(dropdown);
			objSelect.selectByValue(value);
			
			
		}
		public void DropdownselectByIndex(WebElement dropdown,int value) {
			Select objSelect = new Select(dropdown);
			objSelect.selectByIndex(value);
		}

}





