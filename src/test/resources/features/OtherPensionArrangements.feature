@OtherPensionArrangements @BP490-151
Feature: Do you have any other pension arrangements

Background:
Given I am on the start page
When I go to other pension arrangements page


Scenario: Do you have any other pension arrangements
When I select Yes
Then the pension over 30k page will be displayed


Scenario: Do you have any other pension arrangements
When I select No
Then the lifetime allowance page will be displayed

@Bug @BP490-274
Scenario: Do you have any other pension arrangements
When I dont select anything
Then the radio button not selected error message 'Select 'Yes' if you have any additional pension arrangements' will be displayed 


#@TestEnv @StageEnv
#Scenario: Do you have any other pension arrangements
#When I select Yes
#Then the manually submit claim page will be displayed