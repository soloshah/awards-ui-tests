@BackButton @BP490-132
Feature: Navigate Back button


Scenario: CYA- personal details page
Given I have filled in a personal details
And Check your answers page will be displayed
Then the back button will not be displayed

Scenario: CYA- payment details page
Given I have filled in a payment details
And Check your answers page for payment details will be displayed
Then the back button will not be displayed


Scenario: CYA- pension details page
Given I have filled in 1995 pension scheme details
And Check your answers page will be displayed
Then the back button will not be displayed


Scenario: CYA- HMRC details page
Given I have filled in the hmrc details
And Check your answers page will be displayed
Then the back button will not be displayed


Scenario: CYA-HMRC2 details page
Given I have filled in the hmrc2 details
And Check your answers page will be displayed
Then the back button will not be displayed


Scenario: CYA-contact details page
Given I have filled in a contact details
And Check your answers page will be displayed
Then the back button will not be displayed


Scenario: CYA-Dependant details page
Given I have filled in a depandant details
And Check your answers page will be displayed
Then the back button will not be displayed


Scenario: CYA-Employment details page
Given I have filled in current employment details
And Check your answers page will be displayed
Then the back button will not be displayed


Scenario: Summary details page
Given I have completed all sections
And the summary page will be displayed
Then the back button will not be displayed


Scenario: Application submitted page
Given I am on the start page
When I go to application submitted page
And the back button will not be displayed


Scenario: Name page
Given I am on the name page
When I click on back button
Then the start page will be displayed


Scenario: Other EqPensions page
Given I am on the start page
When I go to other eq pension page
Then the back button will be displayed
And I click on back button
Then the name page will be displayed




