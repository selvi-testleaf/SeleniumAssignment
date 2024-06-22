package sprint1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class SAL011_5_VerifyOpportunitiesSortOrderByClosedate {
 public static void main(String[] args) {
	//Launch the browser
		
		
		
		//Handle Notification
	 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	
	//1. Login to https://login.salesforce.com. 
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("bootcamp_2024@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		driver.findElement(By.id("Login")).click();
		
	//2.Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
	//3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();//click on 'view all'
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");// type sales in search box
		driver.findElement(By.xpath("(//p[@class='slds-truncate']//mark)[3]")).click();// click on sales
		
	//4. Click on Opportunity tab
		WebElement opportunities = driver.findElement(By.xpath("//span[text()='Opportunities']"));

        driver.executeScript("arguments[0].scrollIntoView();",opportunities);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",opportunities);
        
	//5. Select the Table view
        List<WebElement>allData=driver.findElements(By.xpath("//table[@role='grid']"));
        
        for(WebElement ele:allData)
        {
        	
        	String tableView= ele.getText();
        	System.out.println(tableView);
        }
	//6. Sort the Opportunities by Close Date in ascending order
        //List<WebElement> opportunityName =
        
	//7. Verify the Opportunities displayed in ascending order by Close dateExpected Result:Opportunities should be displayed in ascending order by Close dateStep 
}
}
