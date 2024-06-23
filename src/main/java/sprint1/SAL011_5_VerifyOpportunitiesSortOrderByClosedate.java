package sprint1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class SAL011_5_VerifyOpportunitiesSortOrderByClosedate extends Hooks{
 public static void main(String[] args) {
	//Launch the browser
		
		
		
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
