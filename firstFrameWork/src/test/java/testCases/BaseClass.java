package testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass {

	public String myURL = "https://www.linkedin.com/";
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setUp()
	{
		String driverPath = System.getProperty("user.dir")+File.separator+"Drivers"+File.separator+"chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		logger = Logger.getLogger("firstFrameWork");
		PropertyConfigurator.configure("log4j.properties");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown()
	{
		//Added comment in Base Class
		driver.quit();
	}
	
}
