@CheckYourAnswers @BP490-218  @bug @Bp490-392
Feature: Check Your Answers for HM Revenue and Customs details

Background:
Given I have filled in the hmrc details
And Check your answers page for hmrc details will be displayed


Scenario: Valid hmrc details displayed
When the correct hmrc details will be displayed
And I submit the hmrc details
Then the summary page will be displayed


Scenario: Change Pension over 30k details
When I click change otherPensionBenefits
Then the pension over 30k page will be displayed
And the pensionOver30k details are sustained
When I select different pensionOver30K using different valid option
And I navigate from pensionOver30k page to check your answers page
Then the correct hmrc details will be displayed
Then the updated value for pensionover30k  will be displayed


Scenario: Change combined LTA details
When I click change combinedLTA
Then the separate pension benefits page will be displayed
And the combinedLTA details are sustained
When I enter combinedLTA with different valid value
And I navigate from separateBenefits page to check your answers page
And the correct hmrc details will be displayed
And the updated value for combinedLTA  will be displayed


Scenario: Change Benefit Crystallistion date details
When I click change benefitCrysallisationDate
Then the separate pension benefits page will be displayed
And the benefitCrysallisationDate details are sustained
When I enter benefitCrysallisationDate with different valid value
And I navigate from separateBenefits page to check your answers page
And the correct hmrc details will be displayed
And the updated value for benefitCrysallisationDate will be displayed


Scenario: Change gross annual rate details
When I click change grossAnnualrate
Then the separate pension benefits page will be displayed
And the grossAnnualRate details are sustained
When I enter grossAnnualRate with different valid value
And I navigate from separateBenefits page to check your answers page
And the correct hmrc details will be displayed
And the updated value for grossAnnualRate will be displayed

@bug @Bp490-392
Scenario: Change separate benefit details
When I click change separateBenefit
Then the separate pension benefits page will be displayed
And the separateBenefit details are sustained
When I select separateBenefit with different valid option
And I navigate from lifetimeAllowance page to check your answers page
And the correct hmrc details with updated separateBenefits will be displayed
And the updated value for separateNoBenefit will be displayed


Scenario: Change excess benefits details
When I click change excessBenefit
Then the treat benefits page will be displayed
And the excessBenefit details are sustained
When I select excessBenefit with different valid option
Then the submit claim later page will be displayed



