package actions;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
//import interfaces.AbstractPageUI;
//import interfaces.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	public LoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public LoginPageObject openURL(String url) {
		openAnyUrl(driver, url);
		return PageManageDriver.getLoginPage(driver);
	}
	
	public String getLoginPageURL() {
		return getCurrentUrl(driver);
	}

	public RegisterPageObject clickHereLink() {
		clickToDynamicElement(driver, "here");
		return PageManageDriver.getRegisterPage(driver);
	}
	
	public RegisterPageObject clickHereLinkByJavaS() {
		executeForWebElement(driver, interfaces.LoginPageUI.HERE_LINK);
		return PageManageDriver.getRegisterPage(driver);
	}
	
	public void inputUserIDTextbox(String userID) {
		waitForVisible(driver, interfaces.AbstractPageUI.DYNAMIC_INPUT_FIELD, userID); 
		sendKeyToDynamicInputElement(driver, "uid", userID);
	}
	
	public void inputPasswordTextbox(String password) {
		waitForVisible(driver, interfaces.AbstractPageUI.DYNAMIC_INPUT_FIELD, password); 
		sendKeyToDynamicInputElement(driver, "password", password);
	}
	
	public HomePageObject clickLoginButton() {
		clickToDynamicElement(driver, "btnLogin");
		return PageManageDriver.getHomePage(driver);
	}
}