Feature: Handle Users
	This feature checks if Users are handled correctly.
	Scenarios like saving or deleting users should exist.
		

Scenario: A new User is created
	When i create a new User
	Then the user should be saved
	
	
Scenario: Delete every User
	Given there are some Users
	When i delete all Users
	Then there should be no User
	
	
Scenario: Delete a User by name
	Given there is a User named Karl
	When i delete Karl
	Then there should be no User named Karl
	
	
Scenario: Edit User
	Given there is a User named Karl
	When i rename Karl to John
	Then there should be no User named Karl
	And a User named John should exist

	

	
	
