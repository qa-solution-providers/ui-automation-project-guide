package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtils {
	
	   public static void select_list(WebElement ddElement,String visibleText){

		     WaitUtils.waitForElementVisibilty(BaseClass.getDriver(), ddElement);
		     Select statusDropdown = new Select(ddElement);
		     statusDropdown.selectByVisibleText(visibleText);
		  }

}
