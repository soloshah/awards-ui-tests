@NationalInsurance
Feature: National Insurance Number


Scenario: Valid NINO 
#Given I am on the national insurance page
Given I am on the start page
When I go to nino page
And I enter valid national insurance number 
Then the tbi page will be displayed
#Then the national insurance number submission will be successful
#And Check your answers page is displayed

Scenario Outline: NINO Field validations 
Given I am on the start page
When I go to nino page
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