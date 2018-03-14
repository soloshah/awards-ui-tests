@YourGender @BP490-89
Feature: Your Gender Page

Background:
#Given I am on your gender page
Given I am on the start page
And I go to your gender page

Scenario: What is your gender
When I select Female on your gender page
Then your address page will be displayed


Scenario: What is your gender
When I select Male on your gender page
Then your address page will be displayed


Scenario: What is your gender
When I dont select anything on your gender page
Then what is your gender page error message 'You must enter your legally recognised gender' will be displayed 


Scenario: Default value for your gender page
Then the default value for your gender page will be blank


Scenario: Verify the gender information link
When I click on the link how legal gender is identified on your gender page
Then the guidance for gender link will be displayed on your gender page