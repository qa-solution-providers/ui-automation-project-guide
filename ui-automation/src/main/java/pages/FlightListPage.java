package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class FlightListPage {

	
	public FlightListPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="//td[text()='United Airlines']//preceding-sibling::td[2]//input[@value='Choose This Flight']")
	private WebElement unitedAirlines;	
	
	public WebElement getUnitedAirlines() {
		return unitedAirlines;
	}

	@FindBy(how = How.ID, using="//td[text()='Lufthansa']//preceding-sibling::td[2]//input[@value='Choose This Flight']")
	private WebElement lufthansa;	
	
	
	public WebElement getLufthansa() {
		return lufthansa;
	}
	
	
}