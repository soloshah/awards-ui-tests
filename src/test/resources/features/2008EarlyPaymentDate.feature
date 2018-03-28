@2008EarlyPaymentDate @BP490-136
Feature: Early payment date for deferred benefit after 2008

Background:
Given I am on the start page
When I go to the 2008 early payment date page

Scenario: Valid early payment date
And I enter valid early payment date details
Then the early payment date submission will be successful
Then the 2008 lumpsum choice page will be displayed


Scenario Outline: Early Payment Date Field validations 
And I enter early payment date details using the day '<day>', month '<month>' and year '<year>'
Then the early payment date submission will be unsuccessful
And the error message '<errorMessage>' for early payment dates will be displayed
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
   
           

Scenario Outline: Date between 01/04/2008 and current date plus 6 months
And I enter early payment date details using the day '<day>', month '<month>' and year '<year>'
Then the early payment date submission will be unsuccessful
And I verify 2008 early payment date error message with date before 6 months from now
Examples:
           |day | month  |year| 
           | 01 |  01    |1889| 
           | 31 |  03    |2000|
           | 29 |  02    |2000|
           | 20 |  03    |2008|
           | 31 |  12    |2019|
          
