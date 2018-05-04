@CheckYourAnswers @BP490-219
Feature: Check Your Answers for payment details

Background:
Given I have filled in a payment details
And Check your answers page for payment details will be displayed


Scenario: Valid Payment details displayed
When the correct payment details will be displayed
And I submit all details
Then the summary page will be displayed


Scenario: Change Account type details
When I click on change accountType
Then the bank account type page will be displayed
And the account type details are sustained
When I select different account type using different valid option
And I navigate from accountType page to check your answers page
Then the correct payment with current account details will be displayed
And the updated accountType details will be displayed


Scenario: Change Account Holder name details
When I click on change accountHolderName
Then enter bank details for deposit account page will be displayed
And the account details are sustained
When I enter accountHolderName with different valid details
And I navigate from bank details page to check your answers page
Then the correct payment details will be displayed
And the updated depositAccount details will be displayed

Scenario: Change Account number details
When I click on change accountNumber
Then enter bank details for deposit account page will be displayed
And the account details are sustained
When I enter accountNumber with different valid details
And I navigate from bank details page to check your answers page
Then the correct payment details will be displayed
And the updated depositAccount details will be displayed

Scenario: Change Account Roll number details
When I click on change rollNumber
Then enter bank details for deposit account page will be displayed
And the account details are sustained
When I enter rollNumber with different valid details
And I navigate from bank details page to check your answers page
Then the correct payment details will be displayed
And the updated depositAccount details will be displayed


Scenario: Change Account Sort Code  details
When I click on change sortCode
Then enter bank details for deposit account page will be displayed
And the account details are sustained
When I enter the sort code using different details
And I navigate from bank details page to check your answers page
Then the correct payment details will be displayed
And the updated depositAccount details will be displayed


Scenario: Change Other eq pensions details
When I click on change otherEqPensions
Then the otherEqPensions page will be displayed
And the otherEqPensions details are sustained
When I select otherEqPensions details using different valid option
Then Check your answers page for payment details will be displayed
Then the correct payment details with deposit account details will be displayed
And the updated otherEqPensions details will be displayed


Scenario: Change Eq Paymaster Name details
When I click on change eqPaymasterName
Then the eqPaymasterName page will be displayed
And the eqPaymasterName details are sustained
When I enter eqPaymasterName details using different valid option
And I navigate from eqPaymasterName page to check your answers page
Then the correct payment details will be displayed
And the updated eqPaymasterName details will be displayed


Scenario: Change Eq paymaster reference details
When I click on change eqPaymasterReference
Then the eqPaymasterReference page will be displayed
And the eqPaymasterReference details are sustained
When I enter eqPaymasterReference details using different valid option
Then Check your answers page for payment details will be displayed
Then the correct payment details will be displayed
And the updated eqPaymasterReference details will be displayed
