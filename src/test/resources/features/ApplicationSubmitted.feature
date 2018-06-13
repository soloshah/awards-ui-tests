@ApplicationSubmitted @BP490-255 @BP490-133
Feature: ApplicationSubmitted Page

Background:
Given I fill in the application


Scenario: Form complete header
Then the form complete header will be displayed


Scenario: witness link information
And I click on the link who a witness can be
Then the witness information will be displayed
