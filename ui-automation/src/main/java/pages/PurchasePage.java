package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.DropDownUtils;

public class PurchasePage {
	
	public PurchasePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using="inputName")	
	private WebElement nameEdt;	
	
	@FindBy(how = How.NAME, using="address")
	private WebElement addressEdt;	
	
	@FindBy(how = How.NAME, using="city")
	private WebElement cityEdt;	
	
	@FindBy(how = How.NAME, using="state")
	private WebElement stateEdt;	
	
	@FindBy(how = How.NAME, using="zipCode")
	private WebElement zipCodeEdt;	
	
	@FindBy(how = How.NAME, using="cardType")
	private WebElement cardTypeDropDown;	
	
	@FindBy(how = How.NAME, using="creditCardNumber")
	private WebElement creditCardNumberEdt;	
	
	@FindBy(how = How.NAME, using="creditCardMonth")
	private WebElement creditCardMonthEdt;	
	
	@FindBy(how = How.NAME, using="creditCardYear")
	private WebElement creditCardYearEdt;	
	
	@FindBy(how = How.NAME, using="nameOnCard")
	private WebElement nameOnCardEdt;
	
	@FindBy(how = How.XPATH, using="//input[@value='Purchase Flight']")
	private WebElement purchaseFlightBtn;

	
	public void fillForm(String name, String address, String city, String state, String zipCode,String ccType,String ccNum,String ccMonth,String ccYear,String ccName) {
		nameEdt.sendKeys(name);
		addressEdt.sendKeys(address);
		cityEdt.sendKeys(city);
		stateEdt.sendKeys(state);
		zipCodeEdt.sendKeys(zipCode);
		DropDownUtils.select_list(cardTypeDropDown, ccType);
		creditCardNumberEdt.sendKeys(ccNum);
		creditCardMonthEdt.sendKeys(ccMonth);
		creditCardYearEdt.sendKeys(ccYear);
		nameOnCardEdt.sendKeys(ccName);
		purchaseFlightBtn.click();
	}

}
