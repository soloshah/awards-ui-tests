@EmailAddress @BP490-117 
Feature: What is your email address

Background:
#Given I am on the email address page
Given I am on the start page
When I go to the email address page


@to-be-discussed  @BP490-241
Scenario Outline: Valid email address details
When I enter valid email address details using the email '<email>'
Then the tbi page will be displayed
#Then the email address submission will be successful
#And the check your answers page will be displayed
Examples:
| email                         |
|email@domain.com               |
|firstname.lastname@domain.com  |
|email@subdomain.domain.com     |
|firstname+lastname@domain.com  |
|1234567890@domain.com          |
|email@domain-one.com           |
|email@domain.name              |
|_______@domain.com             |
|email@123.123.123.123          | 
|email@domain.co.jp             |
|firstname-lastname@domain.com  |
|Aluś@domain.com                | 

@to-be-discussed  @BP490-241
Scenario Outline: email address field validations 
When I enter invalid email address details using the email '<email>'
Then the email address submission will be unsuccessful
And the email address error message '<errorMessage>' will be displayed
Examples:
| email                           | errorMessage                |
|                                 |Enter an email address       | 
|"email"@domain.com               |Enter a valid email address  |
|email..email@domain.com          |Enter a valid email address  | 
|plainaddress                     |Enter a valid email address  |
|#@%^%#$@#$@#.com                 |Enter a valid email address  |
|@domain.com                      |Enter a valid email address  |
|Joe Smith<email@domain.com>      |Enter a valid email address  |
|email.domain.com                 |Enter a valid email address  |
|email@domain@domain.com          |Enter a valid email address  |
|email.@domain.com                |Enter a valid email address  |
|.email@domain.com                |Enter a valid email address  | 
|あいうえお@domain.com                | Enter a valid email address |
|email@domain.com(Joe Smith)      |Enter a valid email address  |
|email@domain                     |Enter a valid email address  |
|email@-domain.com                |Enter a valid email address  |
|email@domain.web                 |Enter a valid email address  |
|email@111.222.333.44444          |Enter a valid email address  |
|email@domain..com                |Enter a valid email address  |



Scenario: Email field length validations 
When I enter valid email address using the email 'InvalidI@nvalidInvalid-Invalid.Invalid-InvalidInvalid1234567890Invalid1234567890@domain1234567890.com' 
Then the length of email is verified
Then the email address submission will be unsuccessful



