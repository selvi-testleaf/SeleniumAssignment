package sprint1;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SAL011_4_CreateOpportunityWithoutMandatoryFields extends Hooks{
@Test(dataProvider = "loginTestData",dataProviderClass = Hooks.class,retryAnalyzer = RetryClass.class)
		
		public  void createOpportunityWithoutMandatoryFields(String url, String uname, String pwd)  {
			//Launch the browser
			

	// 2. Click on the toggle menu button from the left corner
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

	// 3. Click View All and click Sales from the Application Launcher
	driver.findElement(By.xpath("//button[text()='View All']")).click();// click on 'view all'
	driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");// type sales in search box
    driver.findElement(By.xpath("(//p[@class='slds-truncate']//mark)[3]")).click();// click on sales

	
	
			
			//4. click on Opportunity
				WebElement opportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));

				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", opportunities);

		        	        
		        		     
			
			//5. Click on the New button
			driver.findElement(By.xpath("//div[@title='New']")).click();
			
			 			
			//6.Choose close date is tomorrow
			
			WebElement calendarIcon = driver.findElement(By.xpath("//label[text()='Close Date']/following::input")); // Replace with the actual ID
	        calendarIcon.click();
	        
	        driver.findElement(By.xpath("//span[text()='16']")).click();
			
	        
			//7.Click on the save button
			
			driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		    
			driver.findElement(By.xpath("//button[@title='Close error dialog']//lightning-primitive-icon[1]")).click();//close hit snag
			
			
			//8. Verify the Alert message. Expected Result: Complete this field message should be displayed for Name and Stage fields     
		    WebElement alertStageMessage1 = driver.findElement(By.xpath("//div[text()='Complete this field.']"));
		    Assert.assertTrue(alertStageMessage1.isDisplayed(), "Alert message1 for Opportunity Name  displayed.");
		   // if (alertStageMessage1.isDisplayed()) {
	           // System.out.println("Alert message displayed: Complete this field.");
	        //} else {
	            //System.out.println("Alert message not displayed.");
	       // }

	        WebElement alertOpportunityNameMessage2 = driver.findElement(By.xpath("(//div[text()='Complete this field.'])[2]"));
	        Assert.assertTrue(alertOpportunityNameMessage2.isDisplayed(), "Alert message2 for Opportunity Name  displayed.");
	        //if (alertOpportunityNameMessage2.isDisplayed()) {
	           // System.out.println("Alert message displayed: Complete this field.");
	       // } else {
	           // System.out.println("Alert message not displayed.");
	       // }

		

		}

	}


