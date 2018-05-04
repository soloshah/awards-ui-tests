@OtherEQPensions @BP490-198
Feature: Other Pensions paid by Equiniti Paymaster Page

Background:

Given I am on the start page
When I go to other eq pension page

Scenario: You have any other pensions paid by Equiniti Paymaster
When I select Yes
Then the eqPaymasterName page will be displayed

Scenario: You have any other pensions paid by Equiniti Paymaster
When I select No
Then Check your answers page for payment details will be displayed

@Bug @BP490-270
Scenario: You have any other pensions paid by Equiniti Paymaster
When I dont select anything
Then the radio button not selected error message 'Select 'yes' if you have any other pensions paid by Equiniti Paymaster' will be displayed 


Scenario: Default value for other pensions paid by Equiniti Paymaster
Then the default value for other pensions paid by Equiniti Paymaster will be blank