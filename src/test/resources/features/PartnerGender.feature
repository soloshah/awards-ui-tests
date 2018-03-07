@PartnerGender @BP490-99 
Feature: What is your partner gender Page

Background:
#Given I am on partner gender page
Given I am on the start page
When I go to partner gender page


Scenario: What is your partner gender page
When I select Female
#Then the tbi page will be displayed
Then what is dynamic partner nino page will be displayed


Scenario: What is your partner gender page
When I select Male
Then what is dynamic partner nino page will be displayed


Scenario: What is your partner gender page
When I dont choose anything and click next
Then the are you working for NHS Page error message 'Select 'yes' if you work for the NHS' will be displayed 


Scenario: Default value for working for NHS
Then the default value for working for NHS will be blank