@WouldYouLikeToBeContacted @BP490-115
Feature: Would you like to be contacted Page

Background:
Given I am on the start page
When I go to would you like to be contacted page

Scenario: How would you like to be contacted
When I select by phone
Then What is your telephone number page will be displayed

Scenario: How would you like to be contacted
When I select by email
Then What is your email address page will be displayed

Scenario: How would you like to be contacted
When I select by phone and email
Then What is your telephone number page will be displayed

Scenario: How would you like to be contacted
When I dont pick anything
Then how would you like to be contacted page error message 'Choose whether you would like to be contacted' will be displayed 

