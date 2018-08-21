Feature: Scenarios on the main page
	This Feature describes Scenarios that should be available on the main page.
	For example the possibility to contact the owner or to connect via social media.


Scenario: I want to be able to follow the Webpage
	Given i am on the main page
	Then i should be able to follow the Webpage on
	|Facebook	|
	|Twitter	|
	|Youtube	|
	|Google-Plus| 


Scenario: I want to contact the website owners
	Given i can see the contact form
	Then i should be able to choose a subject heading
	When i fill in all required fields
	Then i should be able to click send
	And i should get a confirmation message
	
	
Scenario: I want to get a page overview
	Given i am on the main page
	When i navigate to the sitemap
	Then i should see an overview of the categories
	And i should see an overview of the pages
	

Scenario: I want to know something about the site owner
	Given i am on the main page
	When i navigate to the information page
	Then i should see something about the company
	And about the team 
	
  
	
