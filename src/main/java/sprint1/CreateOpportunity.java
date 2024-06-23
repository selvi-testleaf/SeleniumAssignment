package sprint1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;


public class CreateOpportunity extends Hooks{
	
	
	@Test
	
	
	public  void NewOpportunity() throws InterruptedException  {
		//Launch the browser
		
		
		
		
		
		
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

		
	}


}
