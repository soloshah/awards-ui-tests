@NameDetails @BP490-87
Feature: Name Page


Scenario: Valid Name details
Given I am on the name page
When I enter valid name details
Then the name submission will be successful
Then the date of birth page will be displayed

@Bug @BP490-281
Scenario Outline: First name field  validations 
Given I am on the name page
When I enter an invalid name using the firstName '<firstName>'
Then the name submission will be unsuccessful
And the first name error message '<errorMessage>' will be displayed
Examples:
| firstName                | errorMessage                                            |
|                          | You must enter your first name                          |
|In%$ £"^&*"               |Enter names using only letters a to z, spaces and hyphens|
|hgn-yuiom jkhe'tryu90hi237|Enter names using only letters a to z, spaces and hyphens|

@Bug @BP490-281
Scenario Outline: last name field  validations 
Given I am on the name page
When I enter an invalid name using the lastName '<lastName>'
Then the name submission will be unsuccessful
And the last name error message '<errorMessage>' will be displayed
Examples:
| lastName                 | errorMessage                                            |
|                          | You must enter your last name                           |
|In%$ £"^&*"               |Enter names using only letters a to z, spaces and hyphens|
|hgn-yuiom jkhe'tryu90hi   |Enter names using only letters a to z, spaces and hyphens|


Scenario Outline: First and last name field length validations 
Given I am on the name page
When I enter valid name details using the firstName '<firstName>' and lastName '<lastName>'
Then The length of first and last name is verified
And the name submission will be unsuccessful
Examples:
|firstName                    |lastName                             |
|InvalidIn@validInvalidInvalid|InvalidIn@validInvalidInvalidInvalid |

