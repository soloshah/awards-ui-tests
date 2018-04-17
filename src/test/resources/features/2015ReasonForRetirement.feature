@2015ReasonForRetirement @BP490-140
Feature: 2015 Reason for retirement

Background:
Given I am on the start page
When I go to the 2015 reason for retirement page

Scenario: Valid Reason for retirement
And I select valid 2015 retirement reason using retirementAge
Then the 2015 valid retirement reason text for age will be displayed
And the 2015 reason for retirement submission will be successful
And the 2015 lumpsum choice page will be displayed

Scenario: Valid Reason for retirement
And I select valid 2015 retirement reason using deferredBenefit
Then the 2015 valid retirement reason text for deferredBenefit will be displayed
And the 2015 reason for retirement submission will be successful
And the early payment date page will be displayed


Scenario: Valid Reason for retirement
And I select valid 2015 retirement reason using deferredBenefitHealth
Then the 2015 valid retirement reason text for deferredBenefitHealth will be displayed
And the 2015 reason for retirement submission will be successful
And the 2015 lumpsum choice page will be displayed

@Bug @BP490-355 @BP490-317
Scenario: Valid Reason for retirement
And I select valid 2015 retirement reason using earlyPaymentHealth
Then the 2015 valid retirement reason text for earlyPaymentHealth will be displayed
And the 2015 reason for retirement submission will be successful
And the manually submit claim page will be displayed

Scenario: 2015 Reason for retirement validation 
And I dont select any 2015 reason for retirement
Then the 2015 reason for retirement submission will be unsuccessful
And the error message 'Select the reason you are claiming your deferred benefits' for 2015 reason for retirement will be displayed

Scenario: Default value of 2015 reason for retirement
Then the default value of 2015 reason for retirement will be blank
         
