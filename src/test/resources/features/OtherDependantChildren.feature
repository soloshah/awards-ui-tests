@OtherDependantChildren @BP490-109
Feature: Do you have any other dependant children Page

Background:
#Given I am on other dependant children page
Given I am on the start page
When I go to other dependant children page

@Bug @BP490-296
Scenario: Do you have any other dependant children
When I select Yes button
Then the child name page will be displayed


Scenario: Do you have any other dependant children
When I select No button
Then the tbi page will be displayed


Scenario: Do you have any other dependant children
When I dont click anything
Then the other dependant children page error message 'Select 'yes' if you have any dependant children' will be displayed 


Scenario: Default value for any other dependant children page
Then the default value for any other dependant children page will be blank


