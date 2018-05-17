@EqPaymasterName @BP490-199
Feature: Name of the pension paid by equiniti paymaster

Background:
Given I am on the start page
When I go to the eq paymaster name page

Scenario: Valid eq paymaster name details
When I enter valid eq paymaster name details
Then the eq paymaster name submission will be successful
And the eqPaymasterReference page will be displayed


Scenario Outline: Eq paymaster name  field validations 
When I enter invalid eq paymaster name details using the name '<name>'
Then the eq paymaster name submission will be unsuccessful
And the eq paymaster name error message '<errorMessage>' will be displayed
Examples:
| name      | errorMessage                                                         |
|           |You must enter the name of the pension paid by Equiniti Paymaster     | 
|In%$ £"^&*"|Enter names using only letters a to z, spaces, apostrophes and hyphens|
|1234567890 |Enter names using only letters a to z, spaces, apostrophes and hyphens|


Scenario: Eq paymaster name field length validations 
When I enter valid eq paymaster name using the name 'InvalidInvalidInvalid@InvalidInva' 
Then the length of eq paymaster name is verified
And the eq paymaster name submission will be unsuccessful
