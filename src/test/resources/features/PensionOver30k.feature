@PensionOver30K @BP490-154 
Feature: Will your pension be over £30,000

Background:
Given I am on the start page
When I go to pension over 30k page


Scenario: Will your pension be over 30k
When I select Yes on pension over 30k page
Then the separate pension benefits page will be displayed


Scenario:  Will your pension be over 30k
When I select No on pension over 30k page
Then the lifetime allowance page will be displayed


Scenario:  Will your pension be over 30k
When I select notSure on pension over 30k page
Then the separate pension benefits page will be displayed

@bug @BP490-270
Scenario: Will your pension be over 30k
When I dont select anything on pension over 30k page
Then pension over 30k error message 'Select 'yes' if your NHS pension plus any other benefits will be more than £30,000 per year' will be displayed 


