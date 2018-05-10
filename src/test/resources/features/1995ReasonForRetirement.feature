@1995ReasonForRetirement @BP490-138
Feature: 1995 Reason for retirement

Background:
Given I am on the start page
When I go to the 1995 reason for retirement page


Scenario: Valid Reason for retirement
And I select valid retirement reason using retirementAge
Then the valid 1995 retirement reason text for age will be displayed
And the reason for retirement submission will be successful
And the 1995 lumpsum choice page will be displayed

Scenario: Valid Reason for retirement
And I select valid retirement reason using deferredBenefit
Then the valid 1995 retirement reason text for deferredBenefit will be displayed
And the reason for retirement submission will be successful
And the early payment date page will be displayed


Scenario: Valid Reason for retirement
And I select valid retirement reason using deferredBenefitHealth
Then the valid 1995 retirement reason text for deferredBenefitHealth will be displayed
And the reason for retirement submission will be successful
And the 1995 lumpsum choice page will be displayed


@Bug @BP490-355 @BP490-317
Scenario: Valid Reason for retirement
And I select valid retirement reason using earlyPaymentHealth
Then the valid 1995 retirement reason text for earlyPaymentHealth will be displayed
And the reason for retirement submission will be successful
And the manually submit claim page will be displayed

Scenario: 1995 Reason for retirement validation 
And I dont select any reason for retirement
Then the reason for retirement submission will be unsuccessful
And the error message 'Select the reason you are claiming your deferred benefits' for reason for retirement will be displayed

         
