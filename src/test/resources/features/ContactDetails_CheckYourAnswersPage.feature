@ContactDetailsCheckYourAnswers @BP490-216
Feature: Check Your Answers for contact details


Scenario: Would you like to be contacted
Given I am on the start page
When I go to would you like to be contacted page
And I select would not like to be contacted
Then Check your answers page for contact details will be displayed
And would you like to be contacted details will be displayed
And I submit the contact details
Then the summary page will be displayed


Scenario: Valid contact details using telephone
Given I am on the start page
When I go to would you like to be contacted page
And I select by phone
Then What is your telephone number page will be displayed
And I enter valid telephone number details
Then Check your answers page for contact details will be displayed
And Check your answers page with telephone contact details will be displayed
And I submit the contact details
Then the summary page will be displayed


Scenario: Valid contact details using email
Given I am on the start page
When I go to would you like to be contacted page
And I select by email
Then What is your email address page will be displayed
And I enter valid email address details
Then Check your answers page for contact details will be displayed
And Check your answers page with email contact details will be displayed
And I submit the contact details
Then the summary page will be displayed


Scenario: Valid contact details using email and telephone
Given I am on the start page
When I go to would you like to be contacted page
And I select by phone and email
Then What is your telephone number page will be displayed
And I fill in the telephone number and email address details
Then Check your answers page for contact details will be displayed
And Check your answers page with telephone and email contact details will be displayed
And I submit the contact details
Then the summary page will be displayed


Scenario: Change TelephoneNumber details
Given I have filled in a contact details
When I click on change telephoneNumber
Then What is your telephone number page will be displayed
And the telephoneNumber details are sustained
When I enter telephoneNumber using different valid details
And I navigate from telephone number page to check your answers page
Then Check your answers page for contact details will be displayed
And the changed telephoneNumber will be displayed


Scenario: Change Email details
Given I have filled in a contact details
When I click on change emailAddress
Then What is your email address page will be displayed
And the email details are sustained
When I enter emailAddress using different valid details
Then Check your answers page for contact details will be displayed
And the changed emailAddress will be displayed


Scenario: Change would you like to be contacted details
Given I have filled in a contact details
When I click on change WouldYouLikeToBeContacted
Then Would you like to be contacted page will be displayed
And the contact details are sustained
When I select contact details using different valid option
And Check your answers page for contact details will be displayed
And would you like to be contacted details will be displayed
