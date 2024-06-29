package sprint1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class CreateOpportunity extends Hooks{
	
	
	@Test(dataProvider = "loginTestData",retryAnalyzer = RetryClass.class)
	
	
	public  void NewOpportunity(String url, String uname, String pwd) throws InterruptedException, IOException  {
	
		
		

		// 2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click View All and click Sales from the Application Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();// click on 'view all'
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");// type sales
																											// in search
																											// box
		driver.findElement(By.xpath("(//p[@class='slds-truncate']//mark)[3]")).click();// click on sales

		

		//Initialize webDriver Wait
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		
		//4. click on Opportunity
			WebElement opportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));

	        driver.executeScript("arguments[0].scrollIntoView();",opportunities);
	        //JavascriptExecutor js = (JavascriptExecutor) driver;
	        driver.executeScript("arguments[0].click();",opportunities);
	        
	        
	     
		
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
    
        
        
	        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")));
	        dropdown.click();
         //WebElement dropdown =driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']"));

        // dropdown.click();// drop down data value  selection

      						
        
		
		 //9. click Save 
         
         WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Save'])[2]")));
         saveButton.click();//explicit wait
		
         //driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		    
         //Thread.sleep(3000);
			
		
		//close error box if any
		
        //driver.findElement(By.xpath("//button[@title='Close error dialog']//lightning-primitive-icon[1]")).click();
		
	
		//10.verify opportunity is created
		
		
	    	driver.executeScript("arguments[0].click();",opportunities);
			System.out.println("Dashboard is clicked");
			//SoftAssert soft = new SoftAssert();

		List<WebElement> opportunityNames = driver.findElements(By.xpath("//th[@class='slds-cell-edit cellContainer']//span"));
		Boolean newOpportunityNameCreated = false;

		for (WebElement newOpportunity : opportunityNames) {
		    if (newOpportunity.getText().equals("Salesforce Automation by Selvi")) {
		        newOpportunityNameCreated = true;
		        break;
		    }
		}
		TakesScreenshot ts =(TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		int randomNum = new Random().nextInt(1000);
		File destFile = new File("C:\\Testleaf\\SalesforceAutomation\\Screenshot/"+"_" + randomNum+ ".jpg");
		FileUtils.copyFile(sourceFile, destFile);
		System.out.println("Screenshot saved successfully: " + destFile.getAbsolutePath());
		SoftAssert soft= new SoftAssert();
		soft.assertTrue(newOpportunityNameCreated, "The 'Salesforce Automation by Selvi' opportunity was not created.");
		

		 
		//if (newOpportunityNameCreated) {
		  //  System.out.println(" The 'Salesforce Automation by Selvi' opportunity was created successfully.");
		//} else {
		  //  System.out.println("New opportunity was not created.");
		//}

		
	}


}
