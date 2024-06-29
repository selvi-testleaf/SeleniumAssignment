package sprint1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class Hooks {

	public ChromeDriver driver;

	@BeforeSuite
	public void startReport() {
		System.out.println("Start Report");

	}

	@BeforeClass
	public void testCaseDetails() {
		System.out.println("Assign test case details");

	}


	@DataProvider(name = "loginTestData")
	public Object[][] Logindata() {
		return new Object[][] { 
			{ "https://login.salesforce.com/","bootcamp_2024@testleaf.com", "Bootcamp@123" },
			{ "https://login.salesforce.com/","bootcamp_2024@testleaf.com", "Bootcamp@12" },
			{ "https://login.salesforce.com/","bootcamp_2024@testleaf.com", "Bootcamp123" },
			
			

		};
	}

	@BeforeMethod
	public void PreConditions(Object[] testData) {
		// Handle Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// 1.Login to https://login.salesforce.com/

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String url = (String) testData[0];
        String uname = (String) testData[1];
        String pwd = (String) testData[2];

        // Login to Salesforce
        
            // Login to Salesforce
            driver.get(url);
            driver.findElement(By.id("username")).sendKeys(uname);
            driver.findElement(By.id("password")).sendKeys(pwd);
            driver.findElement(By.id("Login")).click();
            
    }
	

	@AfterMethod
	
	public void ErrorScreenshot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus());
		{
			System.out.println("Test case is failed");
      Utility.TakeSreenshot(driver,result.getName());
		}
    
				
		 if (driver != null) {
	            driver.quit();
	            System.out.println("Browser closed.");
	        }
		

	}
	
	
	@AfterSuite
	public void stopTheScript() {
		System.out.println("Stop The running");

	}
}
