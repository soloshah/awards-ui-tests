@NameDetails @BP490-87 @BP490-250
Feature: Name Page


Scenario: Valid Name details
Given I am on the name page
When I enter valid name details
Then the name submission will be successful
Then the date of birth page will be displayed


Scenario Outline:  Valid titles
Given I am on the name page
When I enter valid title using the title '<title>'
And I enter valid first and last name 
Then the name submission will be successful
And the date of birth page will be displayed
Examples:
|title|
|DR   |
|M/S  |
|MISS |
|MR   |
|MRS  |
|MS   |
|PROF |
|REV  |
|SIR  |
|dr   |
|m/s  |
|miss |
|mr   |
|Mrs  |
|ms   |
|prof |
|rev  |
|sir  |



Scenario Outline: First name field  validations 
Given I am on the name page
When I enter an invalid details using the firstName '<firstName>'
Then the name submission will be unsuccessful
And the invalid firstName error message '<errorMessage>' will be displayed
Examples:
| firstName                | errorMessage                                                         |
|                          | You must enter your first name                                       |
|In%$ £"^&*"               |Enter names using only letters a to z, spaces, apostrophes and hyphens|
|hgn-yuiom jkhe'tryu90hi237|Enter names using only letters a to z, spaces, apostrophes and hyphens|


Scenario Outline: last name field  validations 
Given I am on the name page
When I enter an invalid details using the lastName '<lastName>'
Then the name submission will be unsuccessful
And the invalid lastName error message '<errorMessage>' will be displayed
Examples:
| lastName                 | errorMessage                                                         |
|                          | You must enter your last name                                        |
|In%$ £"^&*"               |Enter names using only letters a to z, spaces, apostrophes and hyphens|
|hgn-yuiom jkhe'tryu90hi   |Enter names using only letters a to z, spaces, apostrophes and hyphens|


Scenario Outline: First and last name field length validations 
Given I am on the name page
When I enter valid name details using the title '<title>', firstName '<firstName>' and lastName '<lastName>'
Then The length of title,first and last name is verified
And the name submission will be unsuccessful
Examples:
|title |firstName                    |lastName                             |
|AA@AS |InvalidIn@validInvalidInvalid|InvalidIn@validInvalidInvalidInvalid |


Scenario Outline: Title Field Validations
Given I am on the name page
When I enter an invalid details using the title '<title>'
Then the name submission will be unsuccessful
And the invalid title error message '<errorMessage>' will be displayed
Examples:
| title   | errorMessage              |
|         |You must enter your title  | 
| £$%"    |Enter a valid title        |
|M45      |Enter a valid title        |
|Mr.      |Enter a valid title        |
|Mr-s     |Enter a valid title        |
|abc      |Enter a valid title        |
|XYZ      |Enter a valid title        |
|123      |Enter a valid title        |
