package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	public static String getScreenShot(WebDriver driver, String filePath, String fileName) {
		
		TakesScreenshot srnShot = (TakesScreenshot) driver;
		File src = srnShot.getScreenshotAs(OutputType.FILE);
		String destination = filePath + fileName + ".jpg" + "_"+ new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		File dest = new File(destination);
		try {
			FileUtils.copyFile(src, dest);
			
		}catch (IOException e) {
			e.getMessage();
		}
		return destination;
		
	}

}
