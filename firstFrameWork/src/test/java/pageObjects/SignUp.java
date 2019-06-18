package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUp {
	
	@FindBy(how=How.XPATH, using="//h2[.='Be great at what you do']")
	public static WebElement lblSignUpBanner;
	
	@FindBy(how=How.NAME, using="firstName")
	public static WebElement txtFirstName;
	
	@FindBy(how=How.NAME, using="lastName")
	public static WebElement txtLastName;
	
	@FindBy(how=How.ID, using="reg-email")
	public static WebElement txtEmail;
	
	@FindBy(how=How.ID, using="reg-password")
	public static WebElement txtPassword;
	
	@FindBy(how=How.ID, using="registration-submit")
	public static WebElement btnJoinNow;
	
}
