package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
//import interfaces.AbstractPageUI;
//import interfaces.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver mapdriver) {
		driver = mapdriver;
	}
	
	public void clickToGenderCheckBox(WebDriver driver, String value) {
		waitForVisible(driver, interfaces.AbstractPageUI.DYNAMIC_GENDER_CHECKBOX, value);
		clickToElement(driver, interfaces.AbstractPageUI.DYNAMIC_GENDER_CHECKBOX, value);
	}
	
	public void sendKeyToTextAreaField(WebDriver driver, String value) {
		sendKeyToElement(driver, interfaces.NewCustomerPageUI.ADDRESS_TEXTAREA, value);
	}
	
	public boolean isNewCustomerRegisteredSuccessfully() {
		waitForVisible(driver, interfaces.NewCustomerPageUI.NEWCUSTOMER_REGISTER_SUCCESS_TEXT);
		return isControlDisplayed(driver, interfaces.NewCustomerPageUI.NEWCUSTOMER_REGISTER_SUCCESS_TEXT);
	}
	
	public String getNewCustomerIdText() {
		waitForVisible(driver, interfaces.NewCustomerPageUI.NEWCUSTOMER_ID);
		return getTextElement(driver, interfaces.NewCustomerPageUI.NEWCUSTOMER_ID);
	}

}
