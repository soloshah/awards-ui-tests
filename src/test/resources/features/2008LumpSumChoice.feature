@2008LumpSumChoice @BP490-142
Feature: Do you want to allocate part of your pension

Background:
Given I am on the start page
When I go to 2008 lump sum choice page


Scenario: Do you want to increase your lump sum
When I select Yes
Then the lumpsum preference page will be displayed


Scenario: Do you want to increase your lump sum
When I select No
Then Check your answers page will be displayed

@Bug @BP490-274
Scenario: Do you want to increase your lump sum
When I dont select anything
Then the radio button not selected error message 'Select 'yes' if you want an increased lump sum' will be displayed 


Scenario: Verify the lump sum benefits information
When I click on the link increase in lump sum affects benefits
Then the lump sum benefits information text will be displayed