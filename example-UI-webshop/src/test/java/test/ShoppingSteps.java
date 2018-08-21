package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingSteps {
	private WebDriver driver;
	
	
	public ShoppingSteps(GlobalWebDriver webdriver) {
		driver = webdriver.getDriver();
	}

	@Then("^i should be able to see the popular items and the best sellers$")
	public void i_should_be_able_to_see_the_popular_items_and_the_best_sellers() {
	    assertTrue(driver.findElement(By.className("blockbestsellers")).isDisplayed());
	    assertTrue(driver.findElement(By.className("homefeatured")).isDisplayed());
	}

	@Given("^i am shopping in a category$")
	public void i_am_shopping_in_a_category() {
	    driver.navigate().to("http://automationpractice.com/index.php?id_category=3&controller=category");
	}

	@Then("^i should be able to open a quick overview and a detailed view$")
	public void i_should_be_able_to_open_a_quick_overview_and_a_detailed_view() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		action.moveToElement(we).moveToElement(driver.findElement(By.className("quick-view"))).click().build().perform();
		driver.findElement(By.xpath("//a[@title='Close']")).click();
		action.moveToElement(we).moveToElement(driver.findElement(By.className("lnk_view"))).click().build().perform();
	}
	
	@Then("^i should be able to add something to my wishlist$")
	public void i_should_be_able_to_add_something_to_my_wishlist() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		action.moveToElement(we).moveToElement(driver.findElement(By.className("addToWishlist"))).click().build().perform();
		driver.findElement(By.xpath("//a[@title='Close']")).click();
	}

	@Given("^my wishlist isn't empty$")
	public void my_wishlist_isn_t_empty() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Manage my customer account']")));
	    driver.findElement(By.xpath("//a[@title='Manage my customer account']")).click();
	    driver.findElement(By.xpath("//a[@title='My wishlists']")).click();
	    assertThat(driver.findElement(By.className("bold")).getText(), not("0"));
	}

	@When("^i see my wishlist$")
	public void i_see_my_wishlist() {
	    driver.findElement(By.xpath("//a[contains(text(), 'My wishlist')]")).click();
	}

	@Then("^i should be able to delete items$")
	public void i_should_be_able_to_delete_items() {
	    driver.findElement(By.className("lnkdel")).click();
	}
	
	@When("^i add items to my compare list$")
	public void i_add_items_to_my_compare_list() {
		driver.navigate().to("http://automationpractice.com/index.php?id_category=3&controller=category");
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		action.moveToElement(we).moveToElement(driver.findElement(By.className("add_to_compare"))).click().build().perform();

	}

	@Then("^i should be able to see a side by side comparison$")
	public void i_should_be_able_to_see_a_side_by_side_comparison() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("bt_compare")));
	    driver.findElement(By.className("bt_compare")).click();
	    assertTrue(driver.findElement(By.className("product-1")).isDisplayed());
	}
	
	@Then("^i should be able to delete items from my compare list$")
	public void i_should_be_able_to_delete_items_from_my_compare_list() {
	    driver.findElement(By.xpath("//a[@title='Remove']")).click();
	    try{
	    	driver.findElement(By.className("product-1")).isDisplayed();
	    } catch(Exception e) {
	    	fail("Item was not deleted!");
	    }
	}
}
