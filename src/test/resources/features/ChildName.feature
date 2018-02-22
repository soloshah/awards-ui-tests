@Child'sName @BP490-106 
Feature: Childs Name

Background:
#Given I am on the child name page
Given I am on the start page
When I go to the child name page

Scenario: Valid Child Name details
When I enter valid child name details
#Then the child name submission will be successful
And the tbi page will be displayed

#And the child date of birth page will be displayed

Scenario Outline: Child first name field  validations 
When I enter an invalid child details using the firstName '<firstName>'
Then the child name submission will be unsuccessful
And the child first name error message '<errorMessage>' will be displayed
Examples:
| firstName                | errorMessage                                            |
|                          | You must enter your child's first and last name         |
|In%$ £"^&*"               |Enter names using only letters a to z, spaces and hyphens|
|hgn-yuiom jkhe'tryu90hi237|Enter names using only letters a to z, spaces and hyphens|


Scenario Outline: Child last name field  validations 
When I enter an invalid child details using the lastName '<lastName>'
Then the child name submission will be unsuccessful
And the child last name error message '<errorMessage>' will be displayed
Examples:
| lastName                        | errorMessage                                            |
|                                 | You must enter your child's first and last name         |
|In%$ £"^&*"                      |Enter names using only letters a to z, spaces and hyphens|
|hgn-yuiom jkhe'tryu90hi23bhgfrtde|Enter names using only letters a to z, spaces and hyphens|


Scenario: Child first and last name field length validations 
When I enter an invalid child name using the firstName 'InvalidIn@validInvalidInv' and lastName 'InvalidIn@validInvalidInv '
Then The length of child first and last name is verified
And the child name submission will be unsuccessful


