Feature: Insert bank card
			A bank card is inserted into the ATM and 
			should only be accepted if bank name and expiry date are correct.
	
	
	
Scenario: Valid card
	Given i insert a bank card from a valid bank
	Then no error should be shown
	And the atm should not return my card	
		
	
Scenario: Card from an invalid bank
	Given i insert a bank card from a invalid bank
	Then the following error should be shown:
	"""
	Error!
	
	Invalid bank or card expired!
	"""
	And the atm should return the card
	
	
Scenario Outline: Expired card
	Given i insert a card with expiry date <date>
	Then the card should get "<result>"
	
	Examples: Expiry Dates
	|date		|result			|
	|03.05.1994	|not accepted	|
	|04.03.2018	|not accepted	|
	|11.22.2020	|accepted		|
	
	

	

	
	

		
		
		
		
