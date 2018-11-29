package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
//import interfaces.HomePageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;

	public HomePageObject(WebDriver mapdriver) {
		driver = mapdriver;
	}
	
	public boolean isHomePageDisplayed() {
		waitForVisible(driver, interfaces.HomePageUI.WELCOME_TEXT);
		return isControlDisplayed(driver, interfaces.HomePageUI.WELCOME_TEXT);
	}
	
}