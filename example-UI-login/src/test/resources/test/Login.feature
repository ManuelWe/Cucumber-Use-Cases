Feature: Login on Website
	This Feature checks if the Login with correct credentials is possible
	and if a Login with wrong credentials is not possible.
	 

Background: 
	Given User is on website login page 
	
Scenario: Login with correct credentials 
	When He enters username as "admin" 
	And He enters password as "12345" 
	Then Login should be succesful 
	
Scenario Outline: Login with wrong credentials 
	When He enters username as "<username>" 
	And He enters password as "<password>" 
	Then Login should fail 
	
	
	Examples: 
		| username  | password  | 
		| admin1	| wrongPassword	| 
		| Hans 		| jk3421	|
		
		
