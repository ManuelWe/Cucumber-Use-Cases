Feature: Insert credit card
			A credit card is inserted into the ATM and
			should only be accepted if she is not disabled
			and if the card number is valid
			

Scenario: Valid card
	 Given i insert a valid credit card
	 Then no error should be shown
	 And the atm should not return my card
	 
	 
Scenario Outline: Invalid card number
	Given i insert a credit card with card number <number>
	Then an error should be shown   
	And the atm should return the card

	Examples:
	|number		|
	|34234213	|
	|3454367987	|
	|34D98H78K	|
	
	
Scenario: Disabled card
	Given i insert a credit card who is disabled
	Then the following error should be shown:
	"""
	Error! Card Disabled. Please contact your bank.
	"""
	And the atm should return the card
	


	