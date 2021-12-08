package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	
	public ConfirmationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using="//h1[text()='Thank you for your purchase today!']")	
	private WebElement thanksMsg;	
	
	@FindBy(how = How.XPATH, using="//td[text()='Id']//following-sibling::td")
	private WebElement confirmationId;	
	
	public WebElement getThanksMsg() {
		return thanksMsg;
		
	}

	public WebElement getConfirmationId() {
		return confirmationId;
	}


}
