@Allocation'sName @BP490-111
Feature: Allocation Name

Background:
#Given I am on the allocation name page
Given I am on the start page
When I go to the allocation name page


Scenario: Valid Allocation Name details
When I enter valid allocation name details
Then the allocation name submission will be successful
And the dynamic allocation date of birth page will be displayed


Scenario Outline: Allocation first name field  validations 
When I enter an invalid allocation details using the firstName '<firstName>'
Then the allocation name submission will be unsuccessful
And the allocation first name error message '<errorMessage>' will be displayed
Examples:
| firstName                 | errorMessage                                                          |
|                           | You must enter their first name                                       |
|In%$ £"^&*"                |Enter names using only letters a to z, spaces, apostrophes and hyphens |
|hgn-yuiom jkhe'tryu90hi237 |Enter names using only letters a to z, spaces, apostrophes and hyphens |


Scenario Outline: Allocation last name field  validations 
When I enter an invalid allocation details using the lastName '<lastName>'
Then the allocation name submission will be unsuccessful
And the allocation last name error message '<errorMessage>' will be displayed
Examples:
| lastName                  | errorMessage                                                          |
|                           | You must enter their last name                                        |
|In%$ £"^&*"                |Enter names using only letters a to z, spaces, apostrophes and hyphens |
|hgn-yuiom jkhe'tryu90hi23  |Enter names using only letters a to z, spaces, apostrophes and hyphens |

@Bug @BP490-228
Scenario: Allocation first and last name field length validations 
When I enter an invalid allocation name using the firstName 'InvalidIn@validInvalidInv' and lastName 'InvalidIn@validInvalidInv'
Then The length of allocation first and last name is verified
And the allocation name submission will be unsuccessful


