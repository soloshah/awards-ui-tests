@1995EarlyPaymentDate @BP490-135
Feature: Early payment date for deferred benefit after 1995

Background:
Given I am on the start page
When I go to the 1995 early payment date page


Scenario: Valid early payment date
And I enter valid early payment date details
#Then the early payment date submission will be successful
Then the tbi page will be displayed


Scenario Outline: 1995 Early Payment Date Field validations 
And I enter early payment date details using the day '<day>', month '<month>' and year '<year>'
Then the early payment date submission will be unsuccessful
And the early payment dates error message '<errorMessage>' will be displayed
Examples:
           |day | month  |year| errorMessage       |
           |    |        |    | Enter a valid date |
           |    |  12    |1982| Enter a valid date |
           |10  |        |1965| Enter a valid date |
           |12  | 10     |    | Enter a valid date |
           |45  | 13     |1234| Enter a valid date |
           |RR  | WW     |GGGG| Enter a valid date |
           |32  | 13     |1900| Enter a valid date |
           |29  | 02     |2001| Enter a valid date |
           |31  | 02     |2000| Enter a valid date |
           |31  | 11     |1980| Enter a valid date |
            

Scenario Outline: Date between 01/04/2000 and current date plus 6 months
And I enter early payment date details using the day '<day>', month '<month>' and year '<year>'
Then the early payment date submission will be unsuccessful
And I verify 1995 early payment date error message with date before 6 months from now
Examples:
           |day | month  |year| 
           | 01 |  01    |1889| 
           | 31 |  03    |2000|
           | 31 |  03    |1995|
           | 29 |  02    |2000|
           | 31 |  12    |2019|
          
