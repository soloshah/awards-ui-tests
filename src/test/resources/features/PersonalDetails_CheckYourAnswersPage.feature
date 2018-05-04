@CheckYourAnswers @BP490-129 @BP490-279
Feature: Check Your Answers for personal details

Background:
Given I have filled in a personal details
And Check your answers page will be displayed


Scenario: Valid Personal details displayed
When the correct personal details will be displayed
And I submit all details
Then the summary page will be displayed


Scenario: Change Name details
When I click on change name
Then the name page will be displayed
And the name details are sustained
When I enter name details using different valid details
And I navigate from name page to check your answers page
Then the correct personal details will be displayed
And the update name details will be displayed

@bug @BP490-303
Scenario: Change DOB details
When I click on change dob
Then the date of birth page will be displayed
And the dob details are sustained
When I enter dob details using different valid details
And I navigate from dob page to check your answers page
Then the correct personal details will be displayed
And the update dob details will be displayed


Scenario: Change gender details
When I click on change gender
Then your gender page will be displayed
And the gender details are sustained
When I select gender details using different valid option
And I navigate from gender page to check your answers page
Then the correct personal details will be displayed
And the update gender details will be displayed


Scenario: Change Address details
When I click on change address
Then your address page will be displayed
And the address details are sustained
When I enter address details using different valid details
And I navigate from address page to check your answers page
Then the correct personal details will be displayed
And the update address details will be displayed


Scenario: Change Nino details
When I click on change nino
Then the national insurance page will be displayed
And the nino details are sustained
When I enter nino details using different valid details
Then Check your answers page will be displayed
Then the correct personal details will be displayed
And the update nino details will be displayed
