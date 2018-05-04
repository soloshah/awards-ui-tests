@DependantChildren @BP490-104
Feature: Do you have any dependant children Page

Background:

Given I am on the start page
When I go to dependant children page

Scenario: Do you have any dependant children
When I select Yes
Then the child name page will be displayed


Scenario: Do you have any dependant children
When I select No
Then are you working for NHS page will be displayed


Scenario: Do you have any dependant children
When I dont select anything
Then the radio button not selected error message 'Select 'yes' if you have any dependant children' will be displayed 


Scenario: Default value for dependant children page
Then the default value for dependant children page will be blank


Scenario: Verify the Dependant child link
When I click on the link Who's classed as a dependant child
Then the dependant child information will be displayed
