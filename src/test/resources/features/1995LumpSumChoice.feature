@1995LumpSumChoice @BP490-141
Feature: 1995 lump sum choice

Background:
Given I am on the start page
When I go to 1995 lump sum choice page


Scenario: Do you want to increase your lump sum
When I select Yes
Then the 1995 lumpsum preference page will be displayed


Scenario: Do you want to increase your lump sum
When I select No
Then the tbi page will be displayed

@Bug @BP490-274
Scenario: Do you want to increase your lump sum
When I dont select anything
Then the radio button not selected error message 'Select 'yes' if you want an increased lump sum' will be displayed 

Scenario: Default value for 1995 lump sum choice
Then the default value for 1995 lump sum choice will be blank


Scenario: Verify the lump sum benefits information
When I click on the link increase in lump sum affects benefits
Then the lump sum benefits information text will be displayed