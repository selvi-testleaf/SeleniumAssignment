package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;




public class SAL011_1_CreateOpportunity {

	
		

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
		        
		        
		     
			
			//5. Click on the New button
			driver.findElement(By.xpath("//div[@title='New']")).click();
			
             //6. Enter Opportunity name as 'Salesforce Automation by Your Name,	
			driver.findElement(By.xpath("//span[text()='Select a date for Close Date']/following::input")).sendKeys("Salesforce Automation by Selvi");
			
             //7. Choose close date as Today
			WebElement calendarIcon = driver.findElement(By.xpath("//label[text()='Close Date']/following::input")); // 
	        calendarIcon.click();
	        driver.findElement(By.xpath("//span[text()='15']")).click();
	       
	      
			
			 //8. Select 'Stage' as Need Analysis
	        WebElement stageSelect = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[2]"));
	        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", stageSelect);
        
	        
	        
	      
	         WebElement dropdown =driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']"));

	         dropdown.click();// drop down data value  selection
	
	      						
	        
			
			 //9. click Save 
			
	         driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			    
	         Thread.sleep(3000);
				
			
			//close error box
			
            //driver.findElement(By.xpath("//button[@title='Close error dialog']//lightning-primitive-icon[1]")).click();
			
			driver.executeScript("arguments[0].click();",opportunities);
			System.out.println("Dashboard is clicked");
			
			
			List<WebElement> opportunityNames = driver.findElements(By.xpath("//th[@class='slds-cell-edit cellContainer']//span"));
			Boolean newOpportunityNameCreated = false;

			for (WebElement newOpportunity : opportunityNames) {
			    if (newOpportunity.getText().equals("Salesforce Automation by Selvi")) {
			        newOpportunityNameCreated = true;
			        break;
			    }
			}

			if (newOpportunityNameCreated) {
			    System.out.println(" The 'Salesforce Automation by Selvi' opportunity was created successfully.");
			} else {
			    System.out.println("New opportunity was not created.");
			}

								
		      // 11.Close the browser
			
		        driver.quit();
		}

	

	}


