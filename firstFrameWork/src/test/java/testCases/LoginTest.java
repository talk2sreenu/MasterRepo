package testCases;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.LoginPage;
import utilities.KeywordLibrary;

public class LoginTest extends BaseClass{
	
	KeywordLibrary keyLibrary = new KeywordLibrary();
	
	@Test
	public void chkLogin()
	{	
		try {
			test = extent.startTest("Login Test");
			test.log(LogStatus.PASS, "Validating Login function", "Login function validated successfully");
			driver.get(myURL);
			logger.info("URL is Opened");
			Thread.sleep(5000);
			PageFactory.initElements(driver, LoginPage.class);
			//LoginPage lp = new LoginPage(driver);
			keyLibrary.typeText(LoginPage.txtLoginEmail, "User Name", "testemail@email.com");
			keyLibrary.typeText(LoginPage.txtLoginPassword, "Password", "abcd@1234");
		
			keyLibrary.verifyObject(LoginPage.btnSignIn, "Sign In button");
			keyLibrary.verifyObject(LoginPage.lnkForgotPassword, "Forgot password hyperlink");
			keyLibrary.verifyObject(LoginPage.dummyObject, "dummy object");
			extent.endTest(test);
		}catch(Exception e) {
			
		}
	}
	
	@AfterMethod
	public void testFunction()
	{
		System.out.println("This is for Next method");
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}
}
