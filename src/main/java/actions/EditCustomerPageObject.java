package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
//import interfaces.EditCustomerPageUI;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver mapdriver) {
		driver = mapdriver;
	}
	
	public void sendKeyToEditAddressTextAreaField(WebDriver driver, String value) {
		sendKeyToElement(driver, interfaces.EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA, value);
	}
	
	public boolean isEditCustomerSuccessfully() {
		waitForVisible(driver, interfaces.EditCustomerPageUI.EDITCUSTOMER_SUCCESS_TEXT);
		return isControlDisplayed(driver, interfaces.EditCustomerPageUI.EDITCUSTOMER_SUCCESS_TEXT);
	}

}
