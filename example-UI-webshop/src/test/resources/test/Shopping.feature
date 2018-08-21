Feature: User is shopping on the website
	This feature describes some basic actions that should be possible to do for the User.
	For example open detailed product view, add something to a wishlist or compare items.


Scenario: Shopping on the main page
	Given i am on the main page
	Then i should be able to see the popular items and the best sellers
	

Scenario: View items in a category
	Given i am shopping in a category
	Then i should be able to open a quick overview and a detailed view
	
	
Scenario: Add item to wishlist
	Given i am logged in
	And i am shopping in a category
	Then i should be able to add something to my wishlist
	
	
Scenario: Remove item from wishlist
	Given my wishlist isn't empty
	When i see my wishlist
	Then i should be able to delete items
	
	
Scenario: Compare items
	Given i am shopping in a category
	When i add items to my compare list
	Then i should be able to see a side by side comparison
	And i should be able to delete items from my compare list
	


	