package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

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
	@BeforeMethod
	public void PreConditions() {
		//Handle Notification
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				
				//1.Login to https://login.salesforce.com/
				
				driver=new ChromeDriver(options);
				driver.get("https://login.salesforce.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				driver.findElement(By.id("username")).sendKeys("bootcamp_2024@testleaf.com");
				driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
				driver.findElement(By.id("Login")).click();
				
				//2. Click on the toggle menu button from the left corner
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				
				//3. Click View All and click Sales from the Application Launcher
				driver.findElement(By.xpath("//button[text()='View All']")).click();//click on 'view all'
				driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");// type sales in search box
				driver.findElement(By.xpath("(//p[@class='slds-truncate']//mark)[3]")).click();// click on sales
				
				

	}
	@AfterMethod
	public void PostConditions() {
		 // 11.Close the browser
		
        driver.quit();
        
        

	}
	@AfterSuite
	private void stopTheScript() {
		System.out.println("Stop The running");

	}
}
