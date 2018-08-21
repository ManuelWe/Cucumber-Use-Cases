Feature: Basic ATM Features
			If the ATM accepted my inserted Credit or Bank Card,
			I should be able to use all the basic ATM features.
	
	
Background:  
	Given the atm accepted my card
	
	
Scenario: My balance is too low 
	Given my Balance is $100 
	When i withdraw $200 
	Then no money should be dispensed
	And my balance should be $100 
	
	
Scenario Outline: I withdraw money from the ATM 
	Given I enter the correct PIN 
	And my Balance is $<balance>
	When i withdraw $<withdrawAmmount>
	Then the atm should give me $<withdrawAmmount>  
	And my balance should be $<remainingBalance>
	
	Examples: 
		|balance	|withdrawAmmount	|remainingBalance	|
		|100		|100				|0					|
		|100		|20					|80					|
		|9990		|1000				|8990				|