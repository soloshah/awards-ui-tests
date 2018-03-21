@CheckYourAnswers @BP490-129
Feature: Check Your Answers for personal details page

Background:
Given I have filled in a personal details
And Check your answers page is displayed

Scenario: Valid Personal details displayed
When the correct personal details will be displayed
And I submit the personal details
Then the tbi page will be displayed


Scenario: Change Name details
When I click on change for name details
Then the name page will be displayed
And the name details are sustained
When I enter name details using different valid details
And I navigate from name page to check your answers page
Then the correct personal details will be displayed
And the updated name details will be displayed

@bug @BP490-303
Scenario: Change DOB details
When I click on change for dob details
Then the date of birth page will be displayed
#And the dob details are sustained
When I enter dob details using different valid details
And I navigate from dob page to check your answers page
Then the correct personal details will be displayed
And the updated dob details will be displayed


Scenario: Change gender details
When I click on change for gender details
Then your gender page will be displayed
And the gender details are sustained
When I select gender details using different valid option
And I navigate from gender page to check your answers page
Then the correct personal details will be displayed
And the updated gender details will be displayed


Scenario: Change Address details
When I click on change for address details
Then your address page will be displayed
And the address details are sustained
When I enter address details using different valid details
And I navigate from address page to check your answers page
Then the correct personal details will be displayed
And the updated address details will be displayed


Scenario: Change Nino details
When I click on change for Nino details
Then the national insurance page will be displayed
And the nino details are sustained
When I enter nino details using different valid details
Then Check your answers page is displayed
Then the correct personal details will be displayed
And the updated nino details will be displayed
