@CheckYourAnswers @BP490-298
Feature: Check Your Answers for HM Revenue and Customs details

Background:
Given I have filled in the hmrc2 details
And Check your answers page for hmrc2 details will be displayed


Scenario: Valid hmrc2 details displayed
When the correct hmrc2 details will be displayed
And I submit the hmrc2 details
Then the summary page will be displayed


Scenario: Change additonal pension arrangements details
When I click change on additionalPensionArrangement
Then do you have any other pension arrangements page will be displayed
And the otherPensionArrangement details are sustained
When I select different pensionArrangement using different valid option
Then the pension over 30k page will be displayed


Scenario: Change life time allowance details
When I click change on lifeTimeAllowance
Then the lifetime allowance page will be displayed
And the lifetime allowance details are sustained
When I select lifetimeAllowance with different valid option
Then Check your answers page for hmrc2 details will be displayed
And the correct hmrc2 details with lifetimeAllowance will be displayed
And the updated lifetimeAllowance value will be displayed


Scenario: Change Certificate number details
When I click change on certificateNumber
Then the lifetime allowance page will be displayed
And the certificateNumber details are sustained
When I enter certificateNumber with different valid value
Then Check your answers page for hmrc2 details will be displayed
And the correct hmrc2 details will be displayed
And the updated certificateNumber value will be displayed

