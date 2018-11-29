package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
//import interfaces.AbstractPageUI;
//import interfaces.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	//input email address
	public void inputEmailAddress(String emailAddress) {
		waitForVisible(driver, interfaces.AbstractPageUI.DYNAMIC_INPUT_FIELD, emailAddress);
		sendKeyToDynamicInputElement(driver, "emailid", emailAddress);
	}
	//click Submit button
	public void clickSubmitButton() {
		clickToDynamicElement(driver, "btnLogin");
	}
	//get UserID text
	public String getUserIdText() {
		waitForVisible(driver, interfaces.RegisterPageUI.USER_ID);
		return getTextElement(driver, interfaces.RegisterPageUI.USER_ID);
	}
	//get Password text
	public String getPasswordText() {
		return getTextElement(driver, interfaces.RegisterPageUI.PASSWORD);
	}
}