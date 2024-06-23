package sprint1;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;



public class SAL011_3_DeleteOpportunity extends Hooks{
	@Test
	public  void deleteOpportunity() throws InterruptedException  {
		//Launch the browser





		//4. Click on Opportunity tab
		WebElement opportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].scrollIntoView();",opportunities);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",opportunities);

		//5.Search the Opportunity 'Salesforce Automation by Your Name'
		WebElement searchTheList = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
		searchTheList.sendKeys("Salesforce Automation by Selvi"+Keys.ENTER);
		
				//driver.findElement(By.name("Opportunity-search-input")).sendKeys("Salesforce Automation by  Selvi");

		//6.Click on  the Dropdown icon 
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='slds-grid slds-grid--align-spread']//div)[3]")).click();//select list box

		//7. Select Drop down icon.
		driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]")).click();// click on drop down icon
		
		WebElement deletedropDD =driver.findElement(By.xpath("//a[@title='Delete']"));
		deletedropDD.click();
		// select delete option
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		
		// print success message
		Boolean toastMessageCreated = false;
		String toastMessage= driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small')]")).getText();
		System.out.println(toastMessage);
		toastMessageCreated = true;

		//8.Verify Whether Opportunity is Deleted using Opportunity Name.Expected Result: Opportunity is Successfully deleted 
		
		
		 if (toastMessageCreated) {
	            System.out.println("Opportunity is Successfully deleted");
	            System.out.println(toastMessage);
	        } else {
	            System.out.println("Opportunity deletion failed");
	        }
	
	}

}
