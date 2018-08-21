package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

import java.util.List;

public class MainPageSteps {
	private WebDriver driver;
	
	public MainPageSteps(GlobalWebDriver webdriver) {
		driver = webdriver.getDriver();
	}
	
	@Given("^i am on the main page$")
	public void i_am_on_the_main_page() {
		driver.navigate().to("http://automationpractice.com/index.php");
	}

	@Then("^i should be able to follow the Webpage on$")
	public void i_should_be_able_to_follow_the_Webpage_on(DataTable table) {
		List<List<String>> data = table.raw();									//Convert DataTable into List
		for(int i = 0; i<data.size(); i++) {
			WebElement listItem = driver.findElement(By.className(data.get(i).get(0).toLowerCase()));
			assertTrue(listItem.isDisplayed());
		}
	}

	@Given("^i can see the contact form$")
	public void i_can_see_the_contact_form() {
		driver.navigate().to("http://automationpractice.com/index.php?controller=contact");
	}

	@Then("^i should be able to choose a subject heading$")
	public void i_should_be_able_to_choose_a_subject_heading() {
	    Select dropdown = new Select(driver.findElement(By.id("id_contact")));
	    dropdown.selectByIndex(2);
	}

	@When("^i fill in all required fields$")
	public void i_fill_in_all_required_fields() {
		try{
			driver.findElement(By.className("logout")).isDisplayed();				//Check if User is logged in
		} catch(Exception e) {														//if not, the email address has to be inserted
			driver.findElement(By.id("email")).sendKeys("k-ditmar@web.de");
		}
		driver.findElement(By.id("message")).sendKeys("Test Message");
	}

	@Then("^i should be able to click send$")
	public void i_should_be_able_to_click_send() {
		WebElement button = driver.findElement(By.id("submitMessage"));
		assertTrue(button.isDisplayed());
	    button.click();
	}

	@Then("^i should get a confirmation message$")
	public void i_should_get_a_confirmation_message() {
		assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
	}
	
	@When("^i navigate to the sitemap$")
	public void i_navigate_to_the_sitemap() {
	    driver.findElement(By.xpath("//a[@title='Sitemap']")).click();
	}

	@Then("^i should see an overview of the categories$")
	public void i_should_see_an_overview_of_the_categories() {
		assertTrue(driver.findElement(By.className("categTree")).isDisplayed());
	}

	@Then("^i should see an overview of the pages$")
	public void i_should_see_an_overview_of_the_pages() {
		assertTrue(driver.findElement(By.xpath("//h3[contains(text(), 'Pages')]")).isDisplayed());
	}
	
	@When("^i navigate to the information page$")
	public void i_navigate_to_the_information_page() {
		driver.findElement(By.xpath("//a[@title='About us']")).click();
	}

	@Then("^i should see something about the company$")
	public void i_should_see_something_about_the_company() {
		assertTrue(driver.findElement(By.xpath("//h3[contains(text(), 'Our company')]")).isDisplayed());
	}

	@Then("^about the team$")
	public void about_the_team() {
		assertTrue(driver.findElement(By.xpath("//h3[contains(text(), 'Our team')]")).isDisplayed());
	}


}