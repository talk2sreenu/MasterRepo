package utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Reporter;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;
import testCases.BaseClass;


public class KeywordLibrary extends BaseClass{
	

	public boolean verifyObject(WebElement element,String elementName) {
		boolean ObjectVerification = false;
		try {
			if(element.isDisplayed()) {
				System.out.println("The "+elementName+" displayed as expected in the application");
				//logger.info("The "+elementName+" displayed as expected in the application");
				test.log(LogStatus.PASS, "Validating "+elementName+" display" , "The "+elementName+" displayed as expected in the application");
				takeScreenshot(driver,elementName);
				Assert.assertTrue(true);
				ObjectVerification = true;
			}
		}catch(Exception e)
		{
			System.out.println("The "+elementName+" NOT displayed as expected in the application");
			test.log(LogStatus.FAIL, "Validating "+elementName+" display" , "The "+elementName+" NOT displayed as expected in the application");
			//logger.error("The "+elementName+" NOT displayed as expected in the application");
			ObjectVerification = false;
		}
		return ObjectVerification;
	}
	
	public void typeText(WebElement element, String elementName, String value) {
		try {
			if(element.isDisplayed())
			{
				element.sendKeys(value);
				System.out.println("Given value entered in " +elementName+" text box as expected in the application");
				logger.info("Given value entered in " +elementName+" text box as expected in the application");
			}
		}catch(Exception e) {
			System.out.println("The "+elementName+" NOT displayed as expected in the application");
			logger.error("The "+elementName+" NOT displayed as expected in the application");
		}
	}
	
	public void takeScreenshot(WebDriver driver, String picName) {
		try {
		TakesScreenshot scrSht = (TakesScreenshot) driver;
		File imgFile = scrSht.getScreenshotAs(OutputType.FILE);
		
		String fileWithPath = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+picName+".png";
		File DestFile=new File(fileWithPath);

        Files.copy(imgFile, DestFile);
		
		}catch(Exception e)
		{
			System.out.println("Error while capturing screenshot");
		}
	}
	
}
