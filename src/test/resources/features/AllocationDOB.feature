@AllocationDateOfBirth @BP490-112
Feature: Allocation Date of Birth

Background:
Given I am on the start page
When I go to allocation DOB page

Scenario: Valid allocation date of Birth
And I enter valid allocation DOB details
#Then the date of birth submission will be successful
#And the gender page will be displayed
Then the tbi page will be displayed


Scenario Outline: Allocation date of birth field validations 
And I enter allocation DOB details using the day '<day>', month '<month>' and year '<year>'
Then the allocation date of birth submission will be unsuccessful
And the allocation date of birth error message '<errorMessage>' will be displayed
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


Scenario: Allocation date of birth is greater than today's date
And I enter allocation DOB greater than today's date
Then the allocation date of birth submission will be unsuccessful
And  the allocation date of birth for greater than today's date error message 'Enter a date in the past' will be displayed      
    