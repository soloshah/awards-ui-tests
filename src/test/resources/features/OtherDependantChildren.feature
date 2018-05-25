@OtherDependantChildren @BP490-109
Feature: Do you have any other dependant children Page

Background:
Given I am on the start page

@Bug @BP490-296
Scenario: Do you have any other dependant children
When I enter dependant children details
Then do you have any other depandant children page will be displayed
And I select Yes
Then the child name page will be displayed

Scenario: Do you have any other dependant children
When I go to other dependant children page
When I select No
Then do you want to allocate pension page will be displayed


Scenario: Do you have any other dependant children
When I go to other dependant children page
When I dont select anything
Then the radio button not selected error message 'Select 'yes' if you have any dependant children' will be displayed 


@BP490-109
Scenario: Enter 6 dependant children
When I go to dependant children page
And I select Yes
Then I enter 6 dependant children details
Then I try to enter more than 6 dependant children details
And the other dependant children page error message 'You can add details for up to 6 dependant children. If you want to add any more dependant children, send us their details by post' will be displayed



