Feature: User wants to buy an item
	This feature describes scenarios that should be possible
	if a User wants to buy something.  


Scenario: Add item to shopping cart
	Given i want to buy an item
	When i see an item
	Then i should be able to add it to my shopping cart
	When i add the item to my shopping cart
	Then i should get a confirmation
	And i should be able to continue shopping
	
	
Scenario: Add more than one item to shopping cart
	Given i have some items in my shopping cart
	When i want to buy another item
	Then i should be able to add the item to my shopping cart
	
	
Scenario: Check Out
	Given i have some items in my shopping cart
	When i proceed to checkout
	Then i should see a summary of my order
	

Scenario: Buy somthing
	Given i am logged in
	And i have some items in my shopping cart
	When i proceed to checkout
	Then i should be able to verify my delivery and my billing address
	And i should be able to select a delivery
	And i should be asked to accept the terms of service
	And i should be able to choose my payment    
	
	
	