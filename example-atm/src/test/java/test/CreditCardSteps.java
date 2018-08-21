package test;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CreditCardSteps {
	private World world;
	
	public CreditCardSteps(World world) {
		this.world = world;
	}
	
	
	@Given("^i insert a valid credit card$")
	public void i_insert_a_valid_credit_card() {
		world.atm.creditCardInserted(568471468);
	}
	
	@Given("^i insert a credit card with card number (\\w+)$")
	public void i_insert_a_credit_card_with_card_number(double cardNumber) {
		world.atm.creditCardInserted(cardNumber);
	}

	@Then("^an error should be shown$")
	public void an_error_should_be_shown() {
	    assertEquals("Error!\n\nYour credit card number is invalid!", world.atm.getLastErrorMessage());
	}

	@Given("^i insert a credit card who is disabled$")
	public void i_insert_a_credit_card_who_is_disabled() {
		world.atm.creditCardInserted(985647258);
	}
}
