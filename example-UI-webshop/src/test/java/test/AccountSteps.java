package test;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class AccountSteps {
	private WebDriver driver;

	public AccountSteps(GlobalWebDriver webdriver) {
		driver = webdriver.getDriver();
	}
	
	@Given("^i am not registered$")
	public void i_am_not_registered() {
	    
	}

	@When("^i want to create an account$")
	public void i_want_to_create_an_account() {
		driver.navigate().to("http://automationpractice.com/index.php");
	    driver.findElement(By.className("login")).click();
	}

	@Then("^i should be able to enter my email address$")
	public void i_should_be_able_to_enter_my_email_address() {
		assertTrue(driver.findElement(By.id("email_create")).isDisplayed());
	}

	@When("^my address is a correct email address$")
	public void my_address_is_a_correct_email_address() {
		driver.findElement(By.id("email_create")).sendKeys("FrankPaulsen@FP.com");
		driver.findElement(By.id("SubmitCreate")).click();
	}

	@Then("^i should be able to enter my personal information$")
	public void i_should_be_able_to_enter_my_personal_information() {
	    assertTrue(driver.findElement(By.id("customer_firstname")).isDisplayed());
	    assertTrue(driver.findElement(By.id("customer_lastname")).isDisplayed());
	    assertTrue(driver.findElement(By.id("passwd")).isDisplayed());
	}

	@Then("^my address$")
	public void my_address() {
		assertTrue(driver.findElement(By.id("firstname")).isDisplayed());
		assertTrue(driver.findElement(By.id("lastname")).isDisplayed());
		assertTrue(driver.findElement(By.id("address1")).isDisplayed());
		assertTrue(driver.findElement(By.id("city")).isDisplayed());
		assertTrue(driver.findElement(By.id("postcode")).isDisplayed());
	}

	@Given("^i am a registered User$")
	public void i_am_a_registered_User() {

	}

	@When("^i press Sign In$")
	public void i_press_Sign_In() {
	    driver.findElement(By.className("login")).click();
	}

	@Then("^i should be able to login with my email address and password$")
	public void i_should_be_able_to_login_with_my_email_address_and_password() {
		assertTrue(driver.findElement(By.id("email")).isDisplayed());
		assertTrue(driver.findElement(By.id("passwd")).isDisplayed());
	}

	@Then("^i should see a welcome message$")
	public void i_should_see_a_welcome_message() {
		assertTrue(driver.findElement(By.className("info-account")).isDisplayed());
	}
	
	@Given("^i am not logged in$")
	public void i_am_not_logged_in() {
	    if(driver.findElement(By.className("logout")).isDisplayed()) {
	    	driver.findElement(By.className("logout")).click();
	    }
	}

	@When("^i forgot my password$")
	public void i_forgot_my_password() {
		
	}

	@Then("^i should be able request a new password with my email address$")
	public void i_should_be_able_request_a_new_password_with_my_email_address() {
		driver.findElement(By.className("login")).click();
		driver.findElement(By.linkText("Forgot your password?")).click();
		assertTrue(driver.findElement(By.id("email")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());
	}
}
