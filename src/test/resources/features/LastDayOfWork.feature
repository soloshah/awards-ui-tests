@LastDayOfWork @BP490-121
Feature: When will be your last day of work

Background:
Given I am on the start page
When I go to last day of work page


Scenario: Valid date for last day of work 
And I enter valid date for last day of work
Then the last day of work submission will be successful
Then the intend to work for NHS page will be displayed


Scenario Outline: Date field validations 
And I enter invalid date for last day of work using the day '<day>', month '<month>' and year '<year>'
Then the last day of work submission will be unsuccessful
And the last day of work error message '<errorMessage>' will be displayed
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
           |29  | 02     |2019| Enter a valid date |
           |01  | 01     |1889| You must enter a date in the future|
          

Scenario: Last day of work should be future date
And I enter the date less than or equal to today's date
Then the last day of work submission will be unsuccessful
And the last day of work error message 'You must enter a date in the future' will be displayed     
    