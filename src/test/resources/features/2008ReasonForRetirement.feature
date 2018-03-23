@2008ReasonForRetirement @BP490-139
Feature: 2008 Reason for retirement

Background:
Given I am on the start page
When I go to the 2008 reason for retirement page

Scenario: Valid Reason for retirement
And I select valid 2008 retirement reason using retirementAge
Then the 2008 valid retirement reason text for age will be displayed
And the 2008 reason for retirement submission will be successful
And the tbi page will be displayed

Scenario: Valid Reason for retirement
And I select valid 2008 retirement reason using deferredBenefit
Then the 2008 valid retirement reason text for deferredBenefit will be displayed
And the 2008 reason for retirement submission will be successful
And the early payment date page will be displayed


Scenario: Valid Reason for retirement
And I select valid 2008 retirement reason using deferredBenefitHealth
Then the 2008 valid retirement reason text for deferredBenefitHealth will be displayed
And the 2008 reason for retirement submission will be successful
And the tbi page will be displayed


Scenario: Valid Reason for retirement
And I select valid 2008 retirement reason using earlyPaymentHealth
Then the 2008 valid retirement reason text for earlyPaymentHealth will be displayed
And the 2008 reason for retirement submission will be successful
And the tbi page will be displayed

Scenario: 2008 Reason for retirement validation 
And I dont select any 2008 reason for retirement
Then the 2008 reason for retirement submission will be unsuccessful
And the 2008 reason for retirement error message 'Select the reason you are claiming your deferred benefits' will be displayed

Scenario: Default value of 2008 reason for retirement
Then the default value of 2008 reason for retirement will be blank
         
