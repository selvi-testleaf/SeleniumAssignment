package sprint1;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class SAL011_4_CreateOpportunityWithoutMandatoryFields extends Hooks{
@Test
		
		public  void createOpportunityWithoutMandatoryFields()  {
			//Launch the browser
			
			
			
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
	        if (alertStageMessage1.isDisplayed()) {
	            System.out.println("Alert message displayed: Complete this field.");
	        } else {
	            System.out.println("Alert message not displayed.");
	        }

	        WebElement alertOpportunityNameMessage2 = driver.findElement(By.xpath("(//div[text()='Complete this field.'])[2]"));
	        if (alertOpportunityNameMessage2.isDisplayed()) {
	            System.out.println("Alert message displayed: Complete this field.");
	        } else {
	            System.out.println("Alert message not displayed.");
	        }

		

		        // 9.Close the browser
		        driver.quit();
		}

	}


