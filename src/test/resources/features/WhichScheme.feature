@WhichScheme @BP490-127
Feature: Which Scheme 

Background:
Given I am on the start page
When I go to which scheme page


Scenario: Select 1995 Section Scheme
And I select 1995 Section scheme
Then the 1995 reason for retirement page will be displayed


Scenario:  Select 2008 Section Scheme
And I select 2008 Section scheme
Then the 2008 reason for retirement page will be displayed


Scenario:  Select 2015 Section Scheme
And I select 2015 Section scheme
Then the 2015 reason for retirement page will be displayed

@BP490-183 @ticketTested
Scenario:  Select 1995 and 2008 Section Scheme
And I select schemes under 1995 and 2008 Section
Then the 1995 reason for retirement page will be displayed
And I select the options for 1995 on next navigating pages
Then the 2008 interstitial page will be displayed
And the 2008 reason for retirement page will be displayed

@BP490-249 @ticketTested
Scenario:  Select 1995 and 2015 Section Scheme
And I select schemes under 1995 and 2015 Section 
Then the 1995 reason for retirement page will be displayed
And I select the options for 1995 on next navigating pages
Then the 2015 interstitial page will be displayed
And the 2015 reason for retirement page will be displayed


Scenario:  Select 2008 and 2015 Section Scheme
And I select schemes under 2008 and 2015 Section
Then the 2008 reason for retirement page will be displayed
And I select the options for 2008 on next navigating pages
Then the 2015 interstitial page will be displayed
And the 2015 reason for retirement page will be displayed

 
Scenario:  Select 1995,2008 and 2015 Section Scheme
And I select all the schemes
Then the 1995 reason for retirement page will be displayed
And I select the options for 1995 on next navigating pages
Then the 2008 interstitial page will be displayed
Then the 2008 reason for retirement page will be displayed
And I select the options for 2008 on next navigating pages
Then the 2015 interstitial page will be displayed
And the 2015 reason for retirement page will be displayed


Scenario: Which scheme selection validation 
And I dont select any scheme
Then the scheme selection submission will be unsuccessful
And the error message 'Select all pension schemes or sections that you are claiming benefits from' for scheme selection will be displayed


Scenario: Select the scheme information link
And I click on scheme information link
Then the new scheme information page will be displayed

