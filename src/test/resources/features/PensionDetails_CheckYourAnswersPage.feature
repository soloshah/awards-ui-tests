@CheckYourAnswers @BP490-217
Feature: Check Your Answers for pension scheme details


Scenario: 1995 Pension details
Given I have filled in 1995 pension scheme details
And Check your answers page for pension scheme details will be displayed
When the correct 1995 pension scheme details will be displayed
And I submit the pension scheme details
Then the summary page will be displayed


Scenario: 2008 Pension details
Given I have filled in 2008 pension scheme details
And Check your answers page for pension scheme details will be displayed
When the correct 2008 pension scheme details will be displayed
And I submit the pension scheme details
Then the summary page will be displayed


Scenario: 2015 Pension details
Given I have filled in 2015 pension scheme details
And Check your answers page for pension scheme details will be displayed
When the correct 2015 pension scheme details will be displayed
And I submit the pension scheme details
Then the summary page will be displayed


Scenario: 1995 2008 and 2015 Pension details
Given I have filled in all pension scheme details
And Check your answers page for pension scheme details will be displayed
When the correct pension scheme details will be displayed
And I submit the pension scheme details
Then the summary page will be displayed


Scenario: Change which scheme 
Given I have filled in 1995 pension scheme details
When I click change for whichScheme 
Then which scheme page will be displayed
And the which scheme details are sustained
When I select one more scheme using different valid option
And I navigate from whichScheme page to 2008 interstitial page
And I fill in 2008 pension scheme details
Then the correct 1995 and 2008 pension details will be displayed
And the updated pension details for whichScheme will be displayed


Scenario: Change reason for retirement
Given I have filled in 1995 pension scheme details
When I click change for reasonForRetirement
Then the 1995 reason for retirement page will be displayed
And the reasonForRetirement details are sustained
When I select reasonForRetirement with different valid details
And I navigate from reasonForRetirement page to check your answers page
Then the correct 1995 pension scheme details will be displayed
And the updated pension details for reasonForRetirement will be displayed

@Bug @BP490-356
Scenario: Change early payment date details
Given I have filled in 1995 pension scheme details
When I click change for earlyPaymentDate
Then the early payment date page will be displayed
And the earlyPaymentDate details are sustained
When I enter earlyPaymentDate using different valid date
And I navigate from earlyPaymentDate page to check your answers page
Then the correct 1995 pension scheme details will be displayed
And the updated pension details for earlyPaymentDate will be displayed


Scenario: Change lumpSum choice
Given I have filled in 1995 pension scheme details
When I click change for lumpSumChoice
Then the 1995 lumpsum choice page will be displayed
And the lumpsum choice details are sustained
When I select lumpsum choice using different details
And Check your answers page for pension scheme details will be displayed
Then the 1995 pension scheme details with different option will be displayed
And the updated pension details for lumpsumChoice will be displayed


Scenario: Change LumpSum Preference
Given I have filled in 1995 pension scheme details
When I click change for lumpSumPreference
Then the 1995 lumpsum preference page will be displayed
And the lumpSum preference details are sustained
When I select lumpSum preference using different valid option
And Check your answers page for pension scheme details will be displayed
Then the 1995 pension scheme details will be displayed
And the updated pension details for lumpSumPreference will be displayed
