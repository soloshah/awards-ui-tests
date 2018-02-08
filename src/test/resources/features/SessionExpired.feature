@SessionExpired 
Feature: Session Expired 

 
Scenario: DOB in expired session
	Given I am on DOB page
	When I expire my session
  And  I enter valid DOB details in the expired session
 Then the session expired page will be displayed 

