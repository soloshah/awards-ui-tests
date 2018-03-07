@PartnerGender @BP490-99
Feature: Partner Gender Page

Background:
#Given I am on partner gender page
Given I am on the start page
When I go to the partner name page
And I submit valid partner first and last name details
And I go to partner gender page
And the dynamic value of partner first name is displayed on the partners gender page


Scenario: What is your partner's gender
When I select Female
Then the dynamic partners nino page will be displayed


Scenario: What is your partner's gender
When I select Male
Then the dynamic partners nino page will be displayed


Scenario: What is your partner's gender
When I dont select anything on partner gender page
Then what is your partner gender page error message 'You must enter your spouse's or civil partner's legally recognised gender' will be displayed 


Scenario: Default value for partner gender page
Then the default value for partner gender page will be blank


Scenario: Verify the gender information link
When I click on the link how legal gender is identified
Then the guidance for gender link will be displayed