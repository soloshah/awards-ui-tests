@ChildDateOfBirth @BP490-107
Feature: Child Date of Birth

Background:

Given I am on the start page
When I go to child DOB page


Scenario: Valid child date of Birth
And I enter valid child DOB details
Then the child date of birth submission will be successful
And the child gender page will be displayed


Scenario Outline: Child date of birth field validations 
And I enter child DOB details using the day '<day>', month '<month>' and year '<year>'
Then the child date of birth submission will be unsuccessful
And the child date of birth error message '<errorMessage>' will be displayed
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
           |01  | 01     |1889| The date you enter must be equal to or greater than 01 01 1900|



Scenario: Child date of birth is greater than today's date
And I enter child DOB greater than today's date
Then the child date of birth submission will be unsuccessful
And  the child date of birth error message 'Enter a date in the past' will be displayed      
    
   