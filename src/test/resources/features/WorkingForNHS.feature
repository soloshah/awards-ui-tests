@WorkingForNHS @BP490-118
Feature: Working for NHS Page

Background:
Given I am on the start page
When I go to working for NHS page


Scenario: Are you working for NHS
When I select Yes
Then What is the name of your current employer page will be displayed


Scenario: Are you working for NHS
When I select No
Then What was the name of your last employer page will be displayed


Scenario: Are you working for NHS
When I dont select anything
Then the radio button not selected error message 'Select 'yes' if you work for the NHS' will be displayed 
