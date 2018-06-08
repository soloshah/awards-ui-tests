@PartnerNationalInsurance @BP490-100
Feature: Partner National Insurance Number

Background:
Given I am on the start page

Scenario: Valid NINO 
When I go to partner nino page
And I enter valid partner national insurance number 
Then the partner national insurance number submission will be successful
And Do you have any dependant children page will be displayed

 @bug @BP490-246
Scenario Outline: NINO Field validations 
When I go to partner nino page
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
   
       
          
@Bug @BP490-246
Scenario: Validation for same NINO of partner and person 
When I go to nino page
And I enter valid national insurance number
And I enter valid partner details
And I enter same nino as of main applicant
Then the partner national insurance number submission will be unsuccessful
And the partner nino error message 'Spouse or Civil Partner National Insurance number must not be the same as your own' will be displayed