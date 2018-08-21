Feature: Sign in
	This feature describes how a User should be able to register
	and how the login and the password reset should work. 


Scenario: Register User
	Given i am not registered
	When i want to create an account
	Then i should be able to enter my email address
	When my address is a correct email address
	Then i should be able to enter my personal information
	And my address
	
	
Scenario: Login
	Given i am a registered User
	When i press Sign In
	Then i should be able to login with my email address and password
	When i am logged in
	Then i should see a welcome message
	

Scenario: Password reset
	Given i am not logged in
	When i forgot my password
	Then i should be able request a new password with my email address


	
	
   
	
