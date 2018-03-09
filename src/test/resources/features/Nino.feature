@NationalInsurance @BP490-91
Feature: National Insurance Number

Background:
Given I am on the start page
When I go to nino page


Scenario: Valid NINO 
#Given I am on the national insurance page
And I enter valid national insurance number 
Then the national insurance number submission will be successful
Then Check your answers page is displayed

Scenario Outline: NINO Field validations 
When I enter national insurance number using the nino '<nino>'
Then the national insurance number submission will be unsuccessful
And the nino error message '<errorMessage>' will be displayed
Examples:
           |nino               | errorMessage                                 |
           |                   | You must enter your National Insurance number|   
           |invalid            | You must enter a valid National Insurance number format|
           |123AA76948         | You must enter a valid National Insurance number format|
           |A£$%&()(*&^        | You must enter a valid National Insurance number format|
           |45AA568412AAB89    | You must enter a valid National Insurance number format|
           |AA 34 44 BB 4C     | You must enter a valid National Insurance number format|