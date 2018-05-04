@PartnerDateOfBirth @BP490-98
Feature: Partner Date of Birth

Background:
Given I am on the start page
When I go to the partner name page
And I submit valid partner first and last name details
When I go to partner DOB page
Then the partners date of birth page will be displayed


Scenario: Valid partner date of Birth
And I enter valid partner DOB
Then the partner date of birth submission will be successful
And the partner gender page will be displayed


Scenario Outline: Partner date of birth field validations 
And I enter partner DOB details using the day '<day>', month '<month>' and year '<year>'
Then the partner date of birth submission will be unsuccessful
And the partner date of birth error message '<errorMessage>' will be displayed
Examples:
           |day | month  |year| errorMessage               |
           |    |        |    | Enter a valid date of birth|   
           |    |  12    |1982| Enter a valid date of birth|
           |10  |        |1965| Enter a valid date of birth|
           |12  | 10     |    | Enter a valid date of birth|
           |45  | 13     |1234| Enter a valid date of birth|
           |RR  | WW     |GGGG| Enter a valid date of birth|
           |32  | 13     |1900| Enter a valid date of birth|
           |29  | 02     |2001| Enter a valid date of birth|
           |31  | 02     |2000| Enter a valid date of birth|
           |31  | 11     |1980| Enter a valid date of birth|
           |01  | 01     |1889| The date you enter must be greater than 01 01 1900|


Scenario: Partner date of birth less than 16 years from today's date
And I enter partner's dob  less than 16 years from today's date
Then the partner date of birth submission will be unsuccessful
And the partner date of birth for 16 years error message 'Your spouse or civil partner must be at least 16 years old' will be displayed


   