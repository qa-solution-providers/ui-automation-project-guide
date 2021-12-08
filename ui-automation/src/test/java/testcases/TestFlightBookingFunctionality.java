package testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.LogStatus;

import pages.ConfirmationPage;
import pages.FlightListPage;
import pages.HomePage;
import pages.PurchasePage;
import utils.BaseClass;
import utils.DropDownUtils;
import utils.FileReaderUtils;
import utils.ReportUtils;
import utils.ScreenshotUtils;

public class TestFlightBookingFunctionality extends BaseClass {
	
	final static String URL=FileReaderUtils.getPropertyValue("url");
	final static String expectedTitle = FileReaderUtils.getPropertyValue("expectedTitle");
	final static String Source=FileReaderUtils.getPropertyValue("departure");
	final static String Destination=FileReaderUtils.getPropertyValue("destination");
	final static String name=FileReaderUtils.getPropertyValue("name");
	final static String address=FileReaderUtils.getPropertyValue("address");
	final static String city=FileReaderUtils.getPropertyValue("city");
	final static String state=FileReaderUtils.getPropertyValue("state");
	final static String zipCode=FileReaderUtils.getPropertyValue("zipCode");
	final static String ccNum=FileReaderUtils.getPropertyValue("ccNum");
	final static String ccType=FileReaderUtils.getPropertyValue("ccType");
	final static String ccMonth=FileReaderUtils.getPropertyValue("ccMonth");
	final static String ccYear=FileReaderUtils.getPropertyValue("ccYear");
	final static String ccName=FileReaderUtils.getPropertyValue("ccName");
	final static String imgPath=FileReaderUtils.getPropertyValue("imgPath");
	HomePage homePage;
	FlightListPage flightListPage; 
	PurchasePage purchasePage;
	ConfirmationPage confirmationPage;
	String scrnShot;
	

	@BeforeClass
    public void setUp() {
    	homePage = new HomePage(BaseClass.getDriver());
    	flightListPage = new FlightListPage(BaseClass.getDriver());
    	purchasePage = new PurchasePage(BaseClass.getDriver());
    	confirmationPage = new ConfirmationPage(BaseClass.getDriver());
        BaseClass.getUrl(URL);
    }

		
	@Test(testName="---Flight Booking from Source to Destination---",enabled=true)
	public void test_Single_Flight_Booking_On_Same_Route() {
		ReportUtils.startReport(".\\Reports\\"," "+ "Test Flight Booking Functionality", "***Booking a Flight from Source - Paris to Destination - Argentina***");
		String homePageTitle = homePage.getHomePageTitle(BaseClass.getDriver());
		if(expectedTitle.equalsIgnoreCase(homePageTitle)) {
			Assert.assertEquals(homePageTitle, expectedTitle);
			if(homePage.getwelcomeMsg().isDisplayed()) {
				ReportUtils.reportLog(LogStatus.PASS, "User is in HomePage");
				DropDownUtils.select_list(homePage.getdepartureDropDown(), Source);
				DropDownUtils.select_list(homePage.getdestinationDropDown(), Destination);
				homePage.getfindFlightBtn().click();
				flightListPage.getUnitedAirlines().click();
				purchasePage.fillForm(name, address, city, state, zipCode, ccType,ccNum, ccMonth, ccYear, ccName);
				if(confirmationPage.getThanksMsg().isDisplayed() && confirmationPage.getConfirmationId().isDisplayed()) {
					ReportUtils.reportLog(LogStatus.PASS, "Flight Booking is Successful");
					ReportUtils.reportLog(LogStatus.PASS, "Confirmation Id for the Booking is --> "+confirmationPage.getConfirmationId().getText());
				}
			}
		}else {

			ReportUtils.reportLog(LogStatus.FAIL, "Home Page Title is Incorrect --> "+ homePageTitle);
		}
	}
	
	@AfterMethod
    public void cleanUp(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE){
			scrnShot = ScreenshotUtils.getScreenShot(BaseClass.getDriver(), imgPath, result.getName());
			ReportUtils.reportLog(LogStatus.FAIL,result.getThrowable().getMessage()+ReportUtils.attachScreenshotInReport(scrnShot));
		}
			ReportUtils.endReport();
			BaseClass.getDriver().quit();
		
	    }

}
