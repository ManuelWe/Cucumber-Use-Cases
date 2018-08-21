Feature: Login on Website
	This Feature checks if the Login with correct credentials is possible
	and if a Login with wrong credentials is not possible.
	
	
Background:
	Given i am on the login page
	
	
Scenario: Login with correct credentials 
	When i enters username as "admin" 
	And i enters password as "12345" 
	Then Login should be succesful 
	
	
Scenario Outline: Login with wrong credentials 
	When i enters username as "<username>" 
	And i enters password as "<password>" 
	Then Login should fail 
	
	
	Examples: 
		| username  | password  | 
		| admin1	| wrongPassword	| 
		| Hans 		| jk3421	|




	
	
	
	