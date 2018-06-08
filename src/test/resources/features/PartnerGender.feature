@PartnerGender @BP490-99
Feature: Partner Gender Page

Background:
Given I am on the start page
And I enter partner details
And I go to partner gender page


Scenario: What is your partner's gender
When I select Female
Then the partner nino page will be displayed


Scenario: What is your partner's gender
When I select Male
Then the partner nino page will be displayed


Scenario: What is your partner's gender
When I dont select anything on partner gender page
Then what is your partner gender page error message 'You must enter your spouse's or civil partner's legally recognised gender' will be displayed 


Scenario: Verify the gender information link
When I click on the link how legal gender is identified
Then the guidance for gender link will be displayed