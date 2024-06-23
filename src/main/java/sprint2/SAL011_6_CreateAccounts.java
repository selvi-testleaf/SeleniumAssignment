package sprint2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SAL011_6_CreateAccounts {
	
	
@Test
	public  void createAccounts() throws InterruptedException {

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
		
        //5.Click on New
        driver.findElement(By.xpath("//div[@title='New']")).click();
        
        //6.Enter 'your name' as account name
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Selvi");
        
        //7. Select Ownership as Public  
        WebElement ownership=driver.findElement(By.xpath("(//button[@aria-haspopup='listbox'])[4]"));
        driver.executeScript("arguments[0].scrollIntoView();",ownership);
        ownership.click();
        
        WebElement ownershipDD = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Public']"));
        ownershipDD.click();
        
        
        //8.click on save
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        
        //9.Validate successful message.
        String toastMessage = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
        System.out.println("Toastmessage is "+toastMessage);
        Thread.sleep(3000);
        
        //10 clicked on account
        driver.executeScript("arguments[0].scrollIntoView();",accounts);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();",accounts);
        
        //10.validate account
        List<WebElement> accountNames = driver.findElements(By.xpath("//th[@class='slds-cell-edit cellContainer']//span"));
		Boolean newaccountNameCreated = false;

		for (WebElement newAccountName : accountNames) {
		    if (newAccountName.getText().equals("Selvi")) {
		    	newaccountNameCreated = true;
		        break;
		    }
		}

		if (newaccountNameCreated) {
		    System.out.println(" The 'Selvi' account was created successfully.");
		} else {
		    System.out.println("New account was not created.");
		}
        
        
        
        
        
	}

}
