package sprint1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;


	import java.io.IOException;

	public class CustomListener implements ITestListener {

	    private static final Logger logger = LogManager.getLogger(CustomListener.class);

	  
	    public void onTestStart(ITestResult result) {
	        logger.info("Test started: " + result.getName());
	    }

	  
	    public void onTestSuccess(ITestResult result) {
	        logger.info("Test passed: " + result.getName());
	    }

	    
	    public void onTestFailure(ITestResult result) {
	        logger.error("Test failed: " + result.getName());
	        logger.error("Error: " + result.getThrowable());
	        takeScreenshot(result);
	    }

	  
	    public void onTestSkipped(ITestResult result) {
	        logger.warn("Test skipped: " + result.getName());
	    }
	   
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Not often used
	    }

	    public void onStart(ITestContext context) {
	        logger.info("Test suite started: " + context.getName());
	    }

	    
	    public void onFinish(ITestContext context) {
	        logger.info("Test suite finished: " + context.getName());
	    }

	    private void takeScreenshot(ITestResult result) {
	        Object testInstance = result.getInstance();
	        if (testInstance instanceof Hooks) {
	            ChromeDriver driver = ((Hooks) testInstance).driver;
	            try {
	                Utility.TakeSreenshot(driver, result.getName());
	            } catch (IOException e) {
	                logger.error("Failed to take screenshot: " + e.getMessage());
	            }
	        }
	    }
	}


