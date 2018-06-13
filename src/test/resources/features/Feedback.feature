@FeedbackLink @BP490-133
Feature: ApplicationSubmitted Page


Scenario: Feedback Link
Given I fill in the application
And I click on finished button
Then the feedback page will be displayed


Scenario: Feedback submitted
Given I go to feedback page
When I select the option for feedback
Then the thankyou page will be displayed