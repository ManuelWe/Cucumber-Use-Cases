package test;

import static org.junit.Assert.assertEquals;

import atm.ATM;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BasicActionsSteps {
	
private World world;
	
	public BasicActionsSteps(World world) {
		this.world = world;
	}
	
	@Before
	public void setup() {
		world.atm = new ATM();
		world.atm.newAccount();
	}

	@Given("^the atm accepted my card$")
	public void the_atm_accepted_my_card() {
		world.atm.creditCardInserted(568471468);
		assertEquals(true, world.atm.getCardInAtm());
	}
	
	@Given("^my Balance is \\$(\\d+)$")
	public void my_Balance_is_$(int balance) {
		world.atm.setBalance(balance);
	}

	@When("^i withdraw \\$(\\d+)$")
	public void i_withdraw_$(int amount) {
	    world.atm.withdraw(amount);
	}


	@Then("^no money should be dispensed$")
	public void no_money_should_be_dispensed() {
		assertEquals(0, world.atm.getDepositSlot());
	}

	@Then("^my balance should be \\$(\\d+)$")
	public void my_balance_should_be_$(int balance) {
		assertEquals(balance, world.atm.getBalance());
	}

	@Given("^I enter the correct PIN$")
	public void i_enter_the_correct_PIN() {
	    world.atm.checkPIN(3452);
	}

	@Then("^the atm should give me \\$(\\d+)$")
	public void the_atm_should_give_me_$(int amount) {
	    assertEquals(amount, world.atm.getDepositSlot());
	}
}
