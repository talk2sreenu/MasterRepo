package testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class BaseClass {

	public String myURL = "https://www.linkedin.com/";
	public static WebDriver driver;
	public static Logger logger;
    
    public static ExtentReports extent;
    //helps to generate the logs in test report.
    public static ExtentTest test;
	
	@BeforeClass
	public void setUp()
	{
		extent = new ExtentReports(System.getProperty("user.dir") +"\\STMExtentReport.html", true);
		 //extent.addSystemInfo("Environment","Environment Name")
		 extent
		                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
		                .addSystemInfo("Environment", "Automation Testing")
		                .addSystemInfo("User Name", "Srinivasu Kaki");
		                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
		                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
		                extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\java\\testResources\\extent-config.xml"));

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
	
	public void testMethod()
	{
		//This method added from Srini-Dev-Branch-Local branch
	}
	
}
