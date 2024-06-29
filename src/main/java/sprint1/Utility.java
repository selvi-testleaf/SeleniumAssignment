package sprint1;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {
	

	public static void TakeSreenshot(ChromeDriver driver,String ScreenshotName) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
				try {
					File sourceFile = ts.getScreenshotAs(OutputType.FILE);
					  int randomNum = new Random().nextInt(1000);
				
				File destFile = new File("./Screenshot/"+ScreenshotName+"_" + randomNum+".jpg");
				FileUtils.copyFile(sourceFile, destFile);
				System.out.println("Screenshot saved successfully: " + destFile.getAbsolutePath());
	}
	catch (IOException e) {
		System.err.println("Failed to capture screenshot: " + e.getMessage());
	}
	}
}

