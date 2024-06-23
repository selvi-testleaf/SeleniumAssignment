package sprint1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class SAL_Assignment_Selvi extends Hooks{
	@Test
 public  void createOpportunity() throws InterruptedException {
	
	 
	
		
		
		 //5. Select Home from the DropDown
		//driver.findElement(By.xpath("(//button[@part='button button-icon']//lightning-primitive-icon)[3]")).click();
		
		 //6. Add CLOSED + OPEN values and result should set as the GOAL (If the result is less than 10000 then set the goal as 10000)
		// 7. Navigate to Dashboard tab
		
		// 8. Click on  Dashboard
		
		WebElement dashboards = driver.findElement(By.xpath("//span[text()='Dashboards']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", dashboards);
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
		System.out.println("8.New Dashboard page opened.");
		
		
		// 9. Enter the Dashboard name as "YourName_Workout"
		WebElement frameDashboardElement = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frameDashboardElement);
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Selvi_Workout");
		
		// 10. Enter Description as Testing and Click on Create
		driver.findElement(By.id("dashboardDescriptionInput")).sendKeys("Testing");
		
		//11. Click on Create
		driver.findElement(By.id("submitBtn")).click();
		driver.switchTo().defaultContent();
		

		// 12. Click on Done
		driver.switchTo().frame(frameDashboardElement);
		WebElement done = driver.findElement(By.xpath("//button[text()='Done']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", done);
		driver.switchTo().defaultContent();
		
						
		// 13. Click on Dashboard tab
         driver.executeScript("arguments[0].click();",dashboards);
         
		// 14. Verify the Dashboard is Created
         List<WebElement> dashboardNames = driver.findElements(By.xpath("//th[@data-label='Dashboard Name']//a"));
         boolean dashboardCreated = false;
         for (WebElement dashboardName : dashboardNames) {
             if (dashboardName.getText().equals("Selvi_Workout")) {
                 dashboardCreated = true;
                 break;
             }
         }
         if (dashboardCreated) {
             System.out.println("14.The dashboard 'Selvi_Workout' has been created.");
         } else {
             System.out.println("14.The dashboard 'Selvi_Workout' does not exist.");
         }
        
        
      // 15. Click on the newly created Dashboard
 		
        WebElement SelviWorkoutDashboardName = driver.findElement(By.xpath("//a[@title='Selvi_Workout']"));
  		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", SelviWorkoutDashboardName);
  		Thread.sleep(3000);
 		// 16. Click on Subscribe

  		//WebElement subscribe=driver.findElement(By.xpath("(//button[contains(@class,'slds-button slds-button_icon-border')]//lightning-primitive-icon)[2]"));
  		//subscribe.click();
  		//driver.findElement(By.xpath("//span[text()='Subscribe']")).click();
  		
  		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
  		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
  		
  		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[2]")));
  		Thread.sleep(3000);
  		WebElement Subscribe = driver.findElement(By.xpath("//button[text()='Subscribe']"));
 		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", Subscribe);
 		driver.switchTo().defaultContent();
 		
  		
           
 		// 14. Select Frequency as "Daily"
         WebElement frequencyDropdown = driver.findElement(By.xpath("//span[@class='slds-radio--faux button-group-button-label']"));
         frequencyDropdown.click();
         frequencyDropdown.findElement(By.xpath("//option[text()='Daily']")).click();

 		// 15. Time as 10:00 AM
         WebElement timeDropdown = driver.findElement(By.xpath("//select[@id='time']"));
         timeDropdown.click();
         timeDropdown.findElement(By.xpath("//option[text()='10:00 AM']")).click();
         
 		// 16. Click on Save
         driver.findElement(By.xpath("//button[text()='Save']")).click();
         
         
 		// 17. Verify "You started Dashboard Subscription" message displayed or not
         
         
         WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(),'You started Dashboard Subscription')]"));
         if (successMessage.isDisplayed()) {
             System.out.println("20. Subscription started successfully.");
         } else {
             System.out.println("20. Subscription start failed.");
         }
         
 		// 18. Click on Dashboards tab
         
          driver.executeScript("arguments[0].click();", dashboards);

 		// 19. Verify the newly created Dashboard is available
          
          List<WebElement> updatedDashboardNames = driver.findElements(By.xpath("//th[@data-label='Dashboard Name']//a"));
          boolean newDashboardCreated = false;
          for (WebElement dashboardName : updatedDashboardNames) {
              if (dashboardName.getText().equals("Selvi_Workout")) {
                  newDashboardCreated = true;
                  break;
              }
          }
          if (newDashboardCreated) {
              System.out.println("22. The dashboard 'Selvi_Workout' is available.");
          } else {
              System.out.println("22. The dashboard 'Selvi_Workout' is not available.");
          }
          
 		 //20. Click on dropdown for the item
          
          WebElement dropdownButton = driver.findElement(By.xpath("(//button[contains(@class,'slds-button slds-button_icon-border')]//lightning-primitive-icon)[2]"));
          dropdownButton.click();
          
 		// 21. Select Delete
          WebElement deleteOption = driver.findElement(By.xpath("//span[text()='Delete']"));
          deleteOption.click();
          
 		 //22. Confirm the Delete
          WebElement confirmDeleteButton = driver.findElement(By.xpath("//button[@title='Delete']"));
          confirmDeleteButton.click();

 		// 23. Verify the item is not available under Private Dashboard folder
          List<WebElement> finalDashboardNames = driver.findElements(By.xpath("//th[@data-label='Dashboard Name']//a"));
          boolean isDashboardDeleted = true;
          for (WebElement dashboardName : finalDashboardNames) {
              if (dashboardName.getText().equals("Selvi_Workout")) {
                  isDashboardDeleted = false;
                  break;
              }
          }
          if (isDashboardDeleted) {
              System.out.println("26. The dashboard 'Selvi_Workout' has been deleted successfully.");
          } else {
              System.out.println("26. The dashboard 'Selvi_Workout' still exists.");
          }

        
      }

 }
 
 
	
		


