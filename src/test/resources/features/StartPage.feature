@StartPage @BP490-86 @BP490-224 @BP490-186 @BP490-321
Feature: Start Page

Scenario: Start page links
Given I go to the start page
When I click on start now button
Then the name page will be displayed
	

Scenario: Start page warning
Given I go to the start page
And the time constraint message will be dsiplayed


Scenario: guidance notes link
Given I go to the start page
When I click on guidance notes link
Then the guidance notes information will be displayed


Scenario: fair processing notice
Given I go to the start page
When I click on fair processing notice link
Then the fair processing notice information will be displayed

@BP490-321
Scenario: NHSBSA Website link
Given I am on the start page
When I go to the submit claim later page
And I click on NHS website link
Then the NHS pensions page will be displayed