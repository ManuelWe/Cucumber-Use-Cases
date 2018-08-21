package test;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	WebDriver driver = null;

	@Given("^User is on website login page$")
	public void User_is_on_Facebook_login_page() throws MalformedURLException {
        String hubURL = "http://169.254.156.27:4444/wd/hub";
        ChromeOptions options = new ChromeOptions();
        try {
        	driver = new RemoteWebDriver(new URL(hubURL), options);
        } catch (MalformedURLException e) {
        	e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.navigate().to("http://testing-ground.scraping.pro/login");
	}

	@When("^He enters username as \"(.*)\"$")
	public void enterUsername(String arg1) {
		driver.findElement(By.id("usr")).sendKeys(arg1);
	}

	@When("^He enters password as \"(.*)\"$")
	public void enterPassword(String arg1) {
		driver.findElement(By.id("pwd")).sendKeys(arg1);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
	}

	@Then("^Login should fail$")
	public void checkFail() {
		assertTrue(driver.findElement(By.className("error")).isDisplayed());
	}

	@Then("^Login should be succesful$")
	public void Login_should_be_succesful() {
		assertTrue(driver.findElement(By.className("success")).isDisplayed());
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}