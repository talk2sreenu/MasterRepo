package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		//PageFactory.initElements(rdriver, this);
	}

	@FindBy(how=How.XPATH, using="//*[@id='login-email']")
	public static WebElement txtLoginEmail;
	
	@FindBy(how=How.XPATH, using="//*[@id='login-password']")
	public static WebElement txtLoginPassword;
	
	@FindBy(how=How.XPATH, using="//*[@id='login-submit']")
	public static WebElement btnSignIn;
	
	@FindBy(how=How.CLASS_NAME, using="link-forgot-password")
	public static WebElement lnkForgotPassword;
	
	@FindBy(how=How.CLASS_NAME, using="assword")
	public static WebElement dummyObject;
}
