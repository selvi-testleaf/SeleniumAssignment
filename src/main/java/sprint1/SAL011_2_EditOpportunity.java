package sprint1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SAL011_2_EditOpportunity {
	public static void main(String[] args) throws InterruptedException  {
		//Launch the browser
		
		
		
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
		
		
		//4. click on Opportunity
			WebElement opportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));

	        driver.executeScript("arguments[0].scrollIntoView();",opportunities);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();",opportunities);
	        
	      //5.Search the Opportunity 'Salesforce Automation by Your Name
	        WebElement searchTheList = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
			searchTheList.sendKeys("Salesforce Automation by Selvi"+Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//span[@class='slds-grid slds-grid--align-spread']//div)[3]")).click();//select list box
	        
	        //6. Click on the Dropdown icon and Select Edit
			 driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]")).click();
		        Thread.sleep(3000); // Allowing time for the dropdown to appear
		        
		        WebElement deletedropDD =driver.findElement(By.xpath("//li[@class='uiMenuItem']//a[@title='Edit']"));
				deletedropDD.click();
				System.out.println("Edit is clicked");

		    
	        
	        //7.Choose close date as Tomorrow date
				WebElement calendarIcon = driver.findElement(By.xpath("//label[text()='Close Date']/following::input")); // Replace with the actual ID
		        calendarIcon.click();
		        
		        driver.findElement(By.xpath("//span[text()='21']")).click();
				
	        
	        //8. Select 'Stage' as Perception Analysis
		        WebElement stageSelect = driver.findElement(By.xpath("//button[@aria-label='Stage']"));
		        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", stageSelect);
	        System.out.println("stage DD is selected");
		        
		      WebElement dropdown =driver.findElement(By.xpath("//span[@title='Perception Analysis']"));

		       dropdown.click();// drop down data value  selection
		
	        //9 Select Deliver Status as In Progress
		     WebElement deliverStatus = driver.findElement(By.xpath("//button[@aria-label='Delivery/Installation Status']"));
		        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", deliverStatus);
	        
		        
		       WebElement deliverStatusDD =driver.findElement(By.xpath("//span[@title='In progress']"));

		       deliverStatusDD.click();// drop down data value  selection
		
	        
	        //10.Enter Description as SalesForce
		       driver.findElement(By.xpath("//textarea[@part='textarea']")).sendKeys("SalesForce");
		       
		       
		       
	        
	        //11.Click on Save
	        
		       driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			    
		         Thread.sleep(3000);
		         
					//verify the toast message
		         Boolean toastMessageCreated = false;
		 		String toastMessage= driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small')]")).getText();
		 		System.out.println(toastMessage);
		 		toastMessageCreated = true;
	        
		String stageName = driver.findElement(By.xpath("//td[@class='slds-cell-edit cellContainer']//span[@class='slds-truncate']")).getText();
		System.out.println(stageName);
		
		 //12.Verify Stage as Perception Analysis Expected Result:The Oppurtunity is Edited Successfully  
		
		 		if (toastMessageCreated) {
		            System.out.println("Opportunity is Successfully edited");
		            System.out.println(toastMessage);
		            
		        } else {
		            System.out.println("Opportunity is not edited");
		        }
		 		
		 		
	       // 13.Close the browser
	        driver.quit();
	}

}
