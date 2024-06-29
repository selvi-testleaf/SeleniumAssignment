package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SAL011_3_DeleteOpportunity extends Hooks {

	@Test(dataProvider = "loginTestData", dataProviderClass = Hooks.class,retryAnalyzer = RetryClass.class)

	public void deleteOpportunity(String url, String uname, String pwd) throws InterruptedException {
		// Launch the browser

		// 2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click View All and click Sales from the Application Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();// click on 'view all'
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");// type sales in search box
		driver.findElement(By.xpath("(//p[@class='slds-truncate']//mark)[3]")).click();// click on sales

		// Initialize webDriver Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		// 4. Click on Opportunity tab
		WebElement opportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].scrollIntoView();", opportunities);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", opportunities);

		// 5.Search the Opportunity 'Salesforce Automation by Your Name'
		WebElement searchTheList = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
		searchTheList.sendKeys("Salesforce Automation by Selvi" + Keys.ENTER);

		// driver.findElement(By.name("Opportunity-search-input")).sendKeys("Salesforce Automation by Selvi");

		// 6.Click on the Dropdown icon
		
			
		
		Thread.sleep(3000);
		WebElement listBox=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='slds-grid slds-grid--align-spread']//div)[3]")));
		listBox.click();
		//driver.findElement(By.xpath("(//span[@class='slds-grid slds-grid--align-spread']//div)[3]")).click();//select list box

		// 7. Select Drop down icon.
		driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button--icon-x-small')]")).click();// click on drop dwn
																												

		WebElement deletedropDD = driver.findElement(By.xpath("//a[@title='Delete']"));
		deletedropDD.click();
		// select delete option
		driver.findElement(By.xpath("//span[text()='Delete']")).click();

		// print success message
		
		String toastMessage = driver
				.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small')]")).getText();
		System.out.println(toastMessage);
	

		// 8.Verify Whether Opportunity is Deleted using Opportunity Name.Expected
		// Result: Opportunity is Successfully deleted
		 Assert.assertTrue(toastMessage.contains("deleted"), "Opportunity deletion confirmation message not found");
		//if (toastMessageCreated) {
			//System.out.println("Opportunity is Successfully deleted");
			//System.out.println(toastMessage);
		//} else {
			//System.out.println("Opportunity deletion failed");
		//}

	}

}
