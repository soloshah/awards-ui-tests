@TreatBenefits @BP490-163
Feature: Do you want to treat benefit in excess of LTA

Background:

Given I am on the start page
When I go to treat benefits page

Scenario: Do you want to treat benefit in excess of LTA
When I select Yes
Then the lifetime allowance page will be displayed


Scenario: Do you want to treat benefit in excess of LTA
When I select No
Then the submit claim later page will be displayed

@Bug @BP490-270
Scenario: Do you want to treat benefit in excess of LTA
When I dont select anything
Then the radio button not selected error message 'Select 'Yes' if you would like us to treat your NHS Pension benefits in excess of the Lifetime Allowance' will be displayed 


Scenario: Default value for treat benefits
Then the default value for treat benefits page will be blank