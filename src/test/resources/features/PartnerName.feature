@Partner'sName @BP490-97
Feature: Spouse or civil partner's Name

Background:
#Given I am on the partner name page
Given I am on the start page
When I go to the partner name page


Scenario: Valid partner Name details
When I enter valid partner name details
Then the partner name submission will be successful
And the dynamic partners date of birth page will be displayed


@Bug @BP490-243
Scenario Outline: Partner first name field  validations 
When I enter an invalid partner details using the firstName '<firstName>'
Then the partner name submission will be unsuccessful
And the partner first name error message '<errorMessage>' will be displayed
Examples:
| firstName            | errorMessage                                                       |
|                      | You must enter your spouse's or civil partner's first and last name|
|In%$ £"^&*"           |Enter names using only letters a to z, spaces and hyphens           |
|hgn-yuiom jkhe'tryu90h|Enter names using only letters a to z, spaces and hyphens           |

@Bug @BP490-243
Scenario Outline: Partner last name field  validations 
When I enter an invalid partner details using the lastName '<lastName>'
Then the partner name submission will be unsuccessful
And the partner last name error message '<errorMessage>' will be displayed
Examples:
| lastName                | errorMessage                                                       |
|                         | You must enter your spouse's or civil partner's first and last name|
|In%$ £"^&*"              |Enter names using only letters a to z, spaces and hyphens           |
|hgn-yuiom jkhe'tryu90hi23|Enter names using only letters a to z, spaces and hyphens           |


Scenario: Partner first and last name field length validations 
When I enter an invalid partner name using the firstName 'InvalidIn@validInvalidInv' and lastName 'InvalidIn@validInvalidInv '
Then The length of partner first and last name is verified
And the partner name submission will be unsuccessful


