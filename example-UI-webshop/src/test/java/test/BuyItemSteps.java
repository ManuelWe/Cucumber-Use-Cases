package test;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuyItemSteps {
	private WebDriver driver;
	
	public BuyItemSteps(GlobalWebDriver webdriver) {
		driver = webdriver.getDriver();
	}

	@Given("^i want to buy an item$")
	public void i_want_to_buy_an_item() {
		
	}

	@When("^i see an item$")
	public void i_see_an_item() {
		driver.navigate().to("http://automationpractice.com/index.php?id_category=3&controller=category");
		assertTrue(driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']")).isDisplayed());
	}

	@Then("^i should be able to add it to my shopping cart$")
	public void i_should_be_able_to_add_it_to_my_shopping_cart() {
		Actions action = new Actions(driver);												
		WebElement we = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		action.moveToElement(we).clickAndHold().build().perform();										//Action chain is used to hover over an element
		assertTrue(driver.findElement(By.xpath("//a[@title='Add to cart']")).isDisplayed());
		action.release();
	}
	
	@When("^i add the item to my shopping cart$")
	public void i_add_the_item_to_my_shopping_cart() {
	    Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//a[@title='Add to cart']"))).click().build().perform();
	}

	@Then("^i should get a confirmation$")
	public void i_should_get_a_confirmation() {
		assertTrue(driver.findElement(By.className("clearfix")).isDisplayed());
	}

	@Then("^i should be able to continue shopping$")
	public void i_should_be_able_to_continue_shopping() {
		try {
			Thread.sleep(1000);							//wait until element is fully displayed
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
	}

	@Given("^i have some items in my shopping cart$")										
	public void i_have_some_items_in_my_shopping_cart() {
		if(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed()) {				//Check if something has to be added to the shopping cart
			driver.navigate().to("http://automationpractice.com/index.php?id_category=3&controller=category");
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
			action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//a[@title='Add to cart']"))).click().build().perform();
		}
	}

	@When("^i want to buy another item$")
	public void i_want_to_buy_another_item() {

	}

	@Then("^i should be able to add the item to my shopping cart$")
	public void i_should_be_able_to_add_the_item_to_my_shopping_cart() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//a[@title='Add to cart']"))).click().build().perform();
	}
	

	@When("^i proceed to checkout$")
	public void i_proceed_to_checkout() {
	    driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
	}

	@Then("^i should see a summary of my order$")
	public void i_should_see_a_summary_of_my_order() {
		assertTrue(driver.findElement(By.id("cart_summary")).isDisplayed());
	}

	@Given("^i am logged in$")
	public void i_am_logged_in() {
	    try{
	    	driver.findElement(By.className("logout")).isDisplayed();			//Check if User is logged in
	    } catch(Exception e) {													//If not, log in
	    	driver.findElement(By.className("login")).click();					
	    	driver.findElement(By.id("email")).sendKeys("k-ditmar@web.de");
			driver.findElement(By.id("passwd")).sendKeys("password");
			driver.findElement(By.id("SubmitLogin")).click();
	    }
	}

	@Then("^i should be able to verify my delivery and my billing address$")
	public void i_should_be_able_to_verify_my_delivery_and_my_billing_address() {
		driver.findElement(By.className("standard-checkout")).click();
		assertTrue(driver.findElement(By.id("address_delivery")).isDisplayed());
		assertTrue(driver.findElement(By.id("address_invoice")).isDisplayed());
	}

	@Then("^i should be able to select a delivery$")
	public void i_should_be_able_to_select_a_delivery() {
	    driver.findElement(By.name("processAddress")).click();
	    assertTrue(driver.findElement(By.className("delivery_options")).isDisplayed());
	}

	@Then("^i should be asked to accept the terms of service$")
	public void i_should_be_asked_to_accept_the_terms_of_service() {
	    assertTrue(driver.findElement(By.className("checkbox")).isDisplayed());
	    driver.findElement(By.id("cgv")).click();
	}

	@Then("^i should be able to choose my payment$")
	public void i_should_be_able_to_choose_my_payment() {
		driver.findElement(By.name("processCarrier")).click();
		assertTrue(driver.findElement(By.className("cheque")).isDisplayed());
		assertTrue(driver.findElement(By.className("bankwire")).isDisplayed());
	}
}
