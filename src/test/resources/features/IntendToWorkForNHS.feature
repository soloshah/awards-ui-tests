@IntendToWorkForNHS @BP490-125
Feature: Intend To work for NHS after Retirement Page

Background:

Given I am on the start page

Scenario: Intend to Work for NHS after retirement
When I enter employment details
And I choose Yes
Then the date you return to work fields will be displayed
And I enter the valid date
And the intend to work for NHS submission will be successful
Then Check your answers page will be displayed


Scenario Outline: Return to Work date field validation
When I go to intend to work for NHS page
When I choose Yes
Then the date you return to work fields will be displayed
And I enter invalid date details using the day '<day>', month '<month>' and year '<year>'
Then the intend to work for NHS submission will be unsuccessful
And the date you return to work error message '<errorMessage>' will be displayed
Examples:
           |day | month  |year| errorMessage       |
           |    |        |    | Enter a valid date |   
           |    |  12    |1982| Enter a valid date |
           |10  |        |1965| Enter a valid date |
           |12  | 10     |    | Enter a valid date |
           |45  | 13     |1234| Enter a valid date |
           |RR  | WW     |GGGG| Enter a valid date |
           |29  | 02     |2001| Enter a valid date |
           |31  | 02     |2000| Enter a valid date |
           |31  | 11     |1980| Enter a valid date |
           |01  | 01     |1889| The date you enter must be equal to or greater than 01 01 1900|


Scenario: Intend to Work for NHS after retirement
When I enter employment details
And I choose No
Then Check your answers page will be displayed


Scenario: Intend to work for NHS
When I go to intend to work for NHS page
When I dont choose anything
Then intend to work for NHS Page error message 'Select 'yes' if you plan to work for the NHS after you get your pension' will be displayed 

