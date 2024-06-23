package sprint2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SAL011_7_EditAccounts {
	public static void main(String[] args) throws InterruptedException {

		//Handle Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//1.Login to https://login.salesforce.com/
		
		ChromeDriver driver=new ChromeDriver(options);
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
		
		//4.click on accounts

		WebElement accounts=driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].scrollIntoView();",accounts);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",accounts);
        
        //5.click on search
         driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Selvi" +Keys.ENTER);
        
         
         // 6.click on drop down
         WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
         
         WebElement accountDD = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-aura-class='uiInput forceVirtualCheckbox uiInput--default'])[2]")));
        driver.findElement(By.xpath("//a[@title='Show 4 more actions']")).click();
         accountDD.click();

//7.click on edit
driver.findElement(By.xpath("//a[@title='Edit']")).click();

//8.Select Type as Technology Partner
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.xpath("//span[text()=\"Technology Partner\"]")).click();
        
        //9.Select Industry as Healthcare 
        driver.findElement(By.xpath("//button[@aria-label='Industry']")).click();
		
}}
