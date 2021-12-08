package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	private String actualHomePageTitle;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="//h1[text()='Welcome to the Simple Travel Agency!']")	
	private WebElement welcomeMsg;
	
	@FindBy(how = How.NAME, using="fromPort")	
	private WebElement departureDropDown;	
	
	@FindBy(how = How.NAME, using="toPort")
	private WebElement destinationDropDown;	
	
	@FindBy(how = How.XPATH, using="//input[@type=\"submit\"]")
	private WebElement findFlightBtn;
	
	public WebElement getwelcomeMsg() {	
		return welcomeMsg;
		
	}
	
	
	public WebElement getdepartureDropDown() {	
		return departureDropDown;
		
	}
	
	public WebElement getdestinationDropDown() {	
		return destinationDropDown;
		
	}
	
	public WebElement getfindFlightBtn() {
		return findFlightBtn;
		
	}

	public String getHomePageTitle(WebDriver driver) {
		actualHomePageTitle = driver.getTitle();
		return actualHomePageTitle;
	}
	
	
}
