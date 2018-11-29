package stepDefinitions;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginSteps {
	WebDriver driver;

	    @Given("^I open application$")
	    public void i_open_application() {
	        driver = new FirefoxDriver();
	        driver.get("http://demo.guru99.com/v4/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    }

	    @When("^I input Username as \"([^\"]*)\"$")
	    public void i_input_username_as_something(String userName) {
	        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userName);
	    }
	    
	    @And("^I input Password as \"([^\"]*)\"$")
	    public void i_input_password_as_something(String passWord)  {
	    	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
	    }

	    @And("^I click to Login button$")
	    public void i_click_to_login_button() {
	    	driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	    }

	    @Then("^I verify if Homepage is displayed as expected with message \"([^\"]*)\"$")
	    public void i_verify_if_homepage_is_displayed_as_expected(String messageName) {
	        Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"" +   messageName + "\"]")).isDisplayed());
	    }
	    
	    @Then("^I close browser$")
	    public void i_close_browser() {
	    	driver.quit();
	    }
	}