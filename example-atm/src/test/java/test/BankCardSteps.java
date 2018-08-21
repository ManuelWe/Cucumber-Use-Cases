package test;

import transforms.DateMapper;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;

import org.junit.Assert;

public class BankCardSteps {
	private World world;
	
	public BankCardSteps(World world) {
		this.world = world;
	}

	@Given("^i insert a bank card from a invalid bank$")
	public void i_insert_a_bank_card_from_a_invalid_bank() {
		world.atm.bankCardInserted("Hauser bank", LocalDate.now().plusDays(1));
	}

	@Then("^the following error should be shown:$")
	public void the_following_error_should_be_shown(String errorMessage) {
	    assert(world.atm.getLastErrorMessage().equals(errorMessage));
	}

	@Then("^the atm should return the card$")
	public void the_atm_should_return_the_card() {
	    assertEquals(false, world.atm.getCardInAtm());
	}
	
	@Given("^i insert a bank card from a valid bank$")
	public void i_insert_a_bank_card_from_a_valid_bank() {
		world.atm.clearErrorMessages();
		world.atm.bankCardInserted("Deutsche Bank", LocalDate.now().plusDays(1));
	}

	@Then("^no error should be shown$")
	public void no_error_should_be_shown() {
	    assertEquals(null, world.atm.getLastErrorMessage());
	}

	@Then("^the atm should not return my card$")
	public void the_atm_should_not_return_my_card() {
	    assertEquals(true, world.atm.getCardInAtm());
	}
	
	@Given("^i insert a card with expiry date (.*?)$")
	public void i_insert_a_card_with_expiry_date(@Transform(DateMapper.class) LocalDate date) {
		world.atm.bankCardInserted("Deutsche Bank", date);
	}

	@Then("^the card should get \"(.*?)\"$")
	public void the_card_should_get_not_accepted(String result) {
	    if(result.equals("accepted")) {
	    	assertEquals(true, world.atm.getCardInAtm());
	    } else if (result.equals("not accepted")) {
	    	assertEquals(false, world.atm.getCardInAtm());
	    } else {
	    	Assert.fail("Step not expected");
	    }
	}

}