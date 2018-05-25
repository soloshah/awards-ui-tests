@ChildGender @BP490-393
Feature: Child Gender Page

Background:
Given I fill in child details
Then the child gender page will be displayed

Scenario: What is your child's gender
When I select Female on child gender page
Then do you have any other depandant children page will be displayed


Scenario: What is your child's gender
When I select Male on child gender page
Then do you have any other depandant children page will be displayed


Scenario: What is your child's gender
When I dont select anything on child gender page
Then what is your child gender page error message 'Select the gender of your dependant child.' will be displayed 


Scenario: Verify the gender information link
When I click on the link how legal gender is identified
Then the guidance for gender link will be displayed