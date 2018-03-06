@OtherEQPensions @BP490-198 
Feature: Other Pensions paid by Equiniti Paymaster Page

Background:
#Given I am on other eq pension page
Given I am on the start page
When I go to other eq pension page

Scenario: You have any other pensions paid by Equiniti Paymaster
When I pick Yes
Then the tbi page will be displayed

Scenario: You have any other pensions paid by Equiniti Paymaster
When I pick No
Then the tbi page will be displayed

@Bug @ErrorMessagemissingsinglequoteonyes
Scenario: You have any other pensions paid by Equiniti Paymaster
When I dont select anything and click next
Then other Pensions paid by Equiniti Paymaster Page error message 'Select 'yes' if you have any other pensions paid by Equiniti Paymaster' will be displayed 


Scenario: Default value for other pensions paid by Equiniti Paymaster
Then the default value for other pensions paid by Equiniti Paymaster will be blank