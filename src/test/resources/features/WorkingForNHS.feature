@WorkingForNHS @BP490-118
Feature: Working for NHS Page

Background:
#Given I am on working for NHS page
Given I am on the start page
When I go to working for NHS page


Scenario: Are you working for NHS
When I select Yes
Then the tbi page will be displayed
#Then Where are you employed page is displayed


Scenario: Are you working for NHS
When I select No
Then the tbi page will be displayed
#Then What was the name of your last employer page will be displayed


Scenario: Are you working for NHS
When I dont select anything
Then Are you working for NHS Page error message 'Select 'yes' if you work for the NHS' will be displayed 


Scenario: Default value for working for NHS
Then the default value for working for NHS will be blank