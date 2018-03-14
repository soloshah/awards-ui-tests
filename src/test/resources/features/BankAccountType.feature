@BankAccountType @BP490-130
Feature: Bank Account Type

Background:
#Given I am on bank account type page
Given I am on the start page
When I go to bank account type page


Scenario: Select the type of account
When I select Current Account
Then enter bank details for current account page will be displayed


Scenario: Select the type of account
When I select Deposit Account
Then enter bank details for deposit account page will be displayed


Scenario: Type of Bank Account 
When I dont select any account type
Then the bank account type submission will be unsuccessful
And the bank account page error message 'Select the account type you would like us to make the payment to' will be displayed 


Scenario: Default value for Bank Account Type
Then the default value for select bank account type will be blank