package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import cucumberOptions.Hooks;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class creatNewCustomerSteps {
	WebDriver driver;
	WebDriverWait wait;
	static String userID, passWord, loginPageUrl;
	String email = "hongauto" + randomNumber() + "@gmail.com";
	
	
	public creatNewCustomerSteps() {
		driver  = Hooks.openBrowser();
	}
	
	@When("^I get Login Page URL$")
	public void i_get_login_page_url()  {
		loginPageUrl = driver.getCurrentUrl();
	}
	
	@When("^I click here link$")
	public void i_click_here_link()  {
		driver.findElement(By.xpath("//a[text()='here']")).click();
	}
	
	@And("^I input to email textbox with a random email address$")
	public void i_input_to_email_textbox_with_data()  {
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
	}
	
	@And("^I click to Submit button at Register page$")
	public void i_click_to_submit_button_at_register_page()  {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}
	
	@Then("^I get UserID information$")
	public void i_get_userid_information()  {
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	}
	
	@And("^I get Password information$")
	public void i_get_password_information()  {
		passWord = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	}
	
	@When("^I open Login page again$")
	public void i_open_login_page_again()  {
		driver.get(loginPageUrl);
	}

	@Given("^I input to Username textbox$")
	public void i_input_to_username_textbox() throws Exception  {
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
	}
	
	@And("^I input to Password textbox$")
	public void i_input_to_password_textbox()  {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
	}

	@And("^I click to Login button at Login page$")
	public void i_click_to_login_button_at_login_page()  {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}
	
    @Then("^Verify Home page displayed with message \"([^\"]*)\"$")
    public void i_verify_if_homepage_is_displayed_as_expected(String messageName) {
        Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"" +   messageName + "\"]")).isDisplayed());
    }

	@Given("^I open New Customer page$")
	public void i_open_new_customer_page()  {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
	}

	@When("^Input to New Customer form with data$")
	public void input_to_new_customer_form_with_data(DataTable CustomerInfo) throws Exception  {
		List<Map<String, String>> customer = CustomerInfo.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(customer.get(0).get("Name"));
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(customer.get(0).get("DateOfBirth"));
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(customer.get(0).get("Address"));
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(customer.get(0).get("City"));
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(customer.get(0).get("State"));
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(customer.get(0).get("Pin"));
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(customer.get(0).get("Phone"));
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(customer.get(0).get("Email"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(customer.get(0).get("Password"));
		Thread.sleep(2000);
	}
	
	@And("^I click Submit button in New Customer page$")
	public void i_click_submit_button_in_new_customer_page()  {
		driver.findElement(By.xpath("//input[@name='sub']")).click();
	}
	
	@Then("^I verify whether new customer is created successfully$")
	public void verify_customer_created_successfully()  {
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).isDisplayed());
	}
	
	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(999999);
		return number;
	}
}