package utils;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {
	
	private static WebDriver driver;
	final static String chromeProperty="webdriver.chrome.driver";
	final static String firefoxProperty="webdriver.gecko.driver";
	final static String edgeProperty="webdriver.edge.driver";
	final static String	chromeDriverPath=".\\src\\main\\resources\\drivers\\chromedriver.exe";
	final static String	geckoDriverPath=".\\src\\main\\resources\\drivers\\geckodriver.exe";
	final static String edgeDriverPath=".\\src\\main\\resources\\drivers\\msedgedriver.exe";
	final static String	browserType=FileReaderUtils.getPropertyValue("browser");
	

		
	public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        if(browserType.equalsIgnoreCase("chrome")) {
        	System.setProperty(chromeProperty,chromeDriverPath);
    		driver = new ChromeDriver(); 	
        }else if (browserType.equalsIgnoreCase("firefox")) {
        	System.setProperty(firefoxProperty,geckoDriverPath);
    		driver = new FirefoxDriver(); 	
		}else if(browserType.equalsIgnoreCase("edge")) {
			System.setProperty(edgeProperty,edgeDriverPath);
    		driver = new EdgeDriver(); 	
		}
		return driver;
	}
	
    public static void getUrl(String url) {
    	BaseClass.getDriver().get(url);
    	BaseClass.getDriver().manage().window().maximize();
    	BaseClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));    	
    }
}