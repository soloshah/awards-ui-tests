@TelephoneNumber @BP490-116
Feature: What is your telephone number

Background:
#Given I am on the telephone number page
Given I am on the start page
When I go to the telephone number page

Scenario Outline: Valid telephone number details
When I enter valid telephone number details using the number '<number>'
Then the tbi page will be displayed
#Then the telephone number submission will be successful
#And the check your answers page will be displayed
Examples:
| number           |
|+91 222 235 1526  |
|220 721 +662102   |
|0442512355889999  |
|123456789         |
|+44 455565        |


@to-be-discussed @MandatoryErrorMessage
Scenario Outline: telephone number field validations 
When I enter invalid telephone number details using the number '<number>'
Then the telephone number submission will be unsuccessful
And the telephone number error message '<errorMessage>' will be displayed
Examples:
| number            | errorMessage                   |
|                   |Enter a phone number            | 
|)(*&^%$£"!~@}{#?   |Enter a valid telephone number  |
|+66895-6930251     |Enter a valid telephone number  | 
|12345678           |Enter a valid telephone number  |
|+91 751/5698523    |Enter a valid telephone number  |   
|001(212)897.006712 |Enter a valid telephone number  |




