@DynamicValues
Feature: Verify Dynamic Values

@BP490-98
Scenario: Dynamic value of partner's first name to be displayed on Partner's DOB page
Given I am on the start page
When I go to the partner name page
And I submit valid partner first and last name details
Then the dynamic partners date of birth page will be displayed
And the dynamic value of partner first name is displayed on the partners DOB page

@BP490-100 
Scenario: Dynamic value validation for Partner's Nino
Given I am on the start page
When I go to the partner name page
And I submit valid partner first and last name details
And I go to dynamic partner nino page
Then the dynamic value of partners name will be displayed on partner's nino page

@BP490-100 @Bug @BP490-246
Scenario: Validation for same NINO of partner and person 
Given I am on the start page
When I go to nino page
And I enter valid national insurance number
And I go to the partner name page
And I submit valid partner first and last name details
And I go to dynamic partner nino page
And I enter same nino as of main applicant
Then the dynamic national insurance number submission will be unsuccessful
And the partner nino error message 'Spouse or Civil Partner National Insurance number must not be the same as your own' will be displayed

@BP490-109
Scenario: Enter 6 dependant children
Given I am on the start page
When I go to dependant children page
And I will select Yes
Then I go to the child name page
And I enter valid child first and last name details
Then the dynamic child date of birth page will be displayed
And I enter valid child date of birth details
And I am on other dependant children page
And the dynamic value of child first and last name will be displayed
And I select Yes button
Then I go to the child name page
And I enter valid child first and last name details
Then the dynamic child date of birth page will be displayed
And I enter valid child date of birth details
And I am on other dependant children page
And the dynamic value of child first and last name will be displayed
And I select Yes button
Then I go to the child name page
And I enter valid child first and last name details
Then the dynamic child date of birth page will be displayed
And I enter valid child date of birth details
And I am on other dependant children page
And the dynamic value of child first and last name will be displayed
And I select Yes button
Then I go to the child name page
And I enter valid child first and last name details
Then the dynamic child date of birth page will be displayed
And I enter valid child date of birth details
And I am on other dependant children page
And the dynamic value of child first and last name will be displayed
And I select Yes button
Then I go to the child name page
And I enter valid child first and last name details
Then the dynamic child date of birth page will be displayed
And I enter valid child date of birth details
And I am on other dependant children page
And the dynamic value of child first and last name will be displayed
And I select Yes button
Then I go to the child name page
And I enter valid child first and last name details
Then the dynamic child date of birth page will be displayed
And I enter valid child date of birth details
And I am on other dependant children page
And the dynamic value of child first and last name will be displayed
Then I try to enter more than 6 dependant children details
And the other dependant children page error message 'You can add details for up to 6 dependant children. If you want to add any more dependant children, send us their details by post' will be displayed


