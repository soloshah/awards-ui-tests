@DateYouLeave @BP490-124 @WIP
Feature: Date you left last employment

Background:
Given I am on the start page
When I go to date you leave page


Scenario: Valid date you left last employment
And I enter valid date details
Then the date you leave submission will be successful
Then the intend to work for NHS page will be displayed


Scenario Outline: Date field validations 
And I enter invalid date using the day '<day>', month '<month>' and year '<year>'
Then the date you leave submission will be unsuccessful
And the date you leave error message '<errorMessage>' will be displayed
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
           |01  | 01     |1889| The date you enter must be greater than 01 01 1900|


Scenario: Date you left last employment is greater than today's date
And I enter the date greater than today's date
Then the date you leave submission will be unsuccessful
And the date you leave error message 'You must enter a date in the past' will be displayed      
    