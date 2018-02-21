@DynamicValues @BP490-98 
Feature: Verify Dynamic Values

Scenario: Dynamic value of partner's first name to be displayed on Partner's DOB page
Given I am on the start page
When I go to the partner name page
And I submit valid first and last name details
Then the dynamic partners date of birth page will be displayed
Then the dynamic value of partner first name is displayed on the partners DOB page