@EqPaymasterReference @BP490-200
Feature: Eq Paymaster Reference Number

Background:
Given I am on the start page
And I go to the eq paymaster name page
And I enter valid eq paymaster name details
When I go to eq paymaster reference page
Then the dynamic eq paymaster name will be displayed on eq paymaster reference page


Scenario: Valid paymaster reference number 
And I enter valid eq paymaster reference number
Then the tbi page will be displayed

Scenario Outline: Reference Number field validation
And I enter invalid eq paymaster reference number '<refNumber>'
Then the eq paymaster reference submission will be unsuccessful
And the eq paymaster reference error message '<errorMessage>' will be displayed
Examples:
         |refNumber | errorMessage                                                                                     |
         |          | You must enter the reference number                                                              |
         |OPLKJHN0  | Enter a valid reference number. This must be 8 characters, which includes 7 numbers and 1 letter |
         |A1234567  | Enter a valid reference number. This must be 8 characters, which includes 7 numbers and 1 letter |
         |£"$%^&*() | Enter a valid reference number. This must be 8 characters, which includes 7 numbers and 1 letter |
         |OBHUJ8    | Enter a valid reference number. This must be 8 characters, which includes 7 numbers and 1 letter |
         |123R      | Enter a valid reference number. This must be 8 characters, which includes 7 numbers and 1 letter |
         |12345U89  | Enter a valid reference number. This must be 8 characters, which includes 7 numbers and 1 letter |
         

#Scenario: Mandatory reference number validation
#And I dont enter eq paymaster reference number
#Then the eq paymaster reference submission will be unsuccessful
#And the eq paymaster reference error message 'You must enter the reference number' will be displayed

#@BP490-293 @TestOncethedevisdone
#Scenario Outline: Reference number Field validations 
#And I enter invalid eq paymaster reference number '<refNumber>'
#Then the eq paymaster reference submission will be unsuccessful
#And I verify eq paymaster reference error message with the dynamic value of eq paymaster name
#Examples:
          # |refNumber |
          # |OPLKJHN0  |
          # |A1234567  |
          # |£"$%^&*() |
          # |OBHUJ8    |
          # |123R      |
          # |12345U89  |

