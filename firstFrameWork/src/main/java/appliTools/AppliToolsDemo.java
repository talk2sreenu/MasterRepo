package appliTools;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class AppliToolsDemo {
	public static void main(String[] args) {
		String driverPath = System.getProperty("user.dir")+File.separator+"Drivers"+File.separator+"chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Eyes eyes = new Eyes();

		// Set the API key from the env variable. Please read the "Important Note"
		// section above.
		eyes.setApiKey("OmVjD6DouqEDme7CfSV1gsISXBaYQt6TmEFWRt105106MXw110");
		//try {
			// Call getTestInfoForPart to get the appropriate test information.
			//HashMap<String, String> testInfo = App.getTestInfoForPart(args);
			// Start the test by setting AUT's name, window or the page name that's being tested, viewport width and height
			//driver = eyes.open(driver, "appName","windowName", new RectangleSize(1366, 768));
			driver = eyes.open(driver, "appName","windowName2");
			try {
			
			// Navigate the browser to the "ACME" demo app
			driver.get("https://demo.applitools.com");
			//driver.get("https://www.phptravels.net/demo");
			// Visual checkpoint #1.
			eyes.checkWindow("Login window");
            //🌟 Note: You can have multiple "checkWindow" to create multiple test steps within a test.🌟  
            //For example, you may want to test errors in the login window after clicking a login button,
            //In that case, you may add the following before you call eyes.close(). 
            //This will create a test with two test steps.
            //driver.click("login");
            //eyes.checkWindow("Login Window Error");

			// End the test.
			eyes.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			// Close the browser.
			driver.quit();

			// If the test was aborted before eyes.close was called, ends the test as
			// aborted.
			eyes.abortIfNotClosed();

			// End main test
			System.exit(0);
		}

	}
}
