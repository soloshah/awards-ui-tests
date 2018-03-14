@PartnerNationalInsurance @BP490-100
Feature: Partner National Insurance Number

Background:
Given I am on the start page
When I go to partner nino page

Scenario: Valid NINO 
#Given I am on the partner national insurance page
And I enter valid partner national insurance number 
Then the tbi page will be displayed
#Then the partner national insurance number submission will be successful
#And Check your answers page is displayed

Scenario Outline: NINO Field validations 
When I enter partner national insurance number using the nino '<nino>'
Then the partner national insurance number submission will be unsuccessful
And the partner nino error message '<errorMessage>' will be displayed
Examples:
           |nino               | errorMessage                                           |
           |invalid            | You must enter a valid National Insurance number format|
           |123AA76948         | You must enter a valid National Insurance number format|
           |A£$%&()(*&^        | You must enter a valid National Insurance number format|
           |45AA568412AAB89    | You must enter a valid National Insurance number format|
           |AA 34 44 BB 4C     | You must enter a valid National Insurance number format|