@CheckYourAnswers @BP490-214
Feature: Check Your Answers for dependant details

Background:
Given I have filled in a depandant details
And Check your answers page for dependant details will be displayed


Scenario: Valid dependant details displayed
When the correct dependant details will be displayed
And I submit the dependant details
Then the summary page will be displayed

@bug @BP490-377
Scenario: Change marital status details
When I select on change maritalStatus details
Then What is your marital status page will be displayed
And the maritalStatus details are sustained
When I select marital status using different valid option
And I navigate from marital status page to check your answers page
Then the correct dependant details with updated children details will be displayed
And the dependant details for updated maritalStatus will be displayed

@bug @BP490-377
Scenario: Change marital status details
When I select on change maritalStatus details
Then What is your marital status page will be displayed
And the maritalStatus details are sustained
When I select marital status as single
And I navigate from marital status page with updated status to check your answers page
Then the correct dependant details with updated maritalStatus will be displayed
And the dependant details for updated maritalStatus will be displayed

@bug @BP490-377
Scenario: Change marital status details
When I select on change maritalStatus details
Then What is your marital status page will be displayed
And the maritalStatus details are sustained
When I select marital status as divorced
And I navigate from marital status page with updated status to check your answers page
Then the correct dependant details with updated maritalStatus will be displayed
And the dependant details for updated maritalStatus will be displayed


@bug @BP490-375
Scenario: Change partner name details
When I select on change partnerName details
Then the partner name page will be displayed
And the partnerName details are sustained
When I enter partner name using different valid details
And I navigate from partner name page to check your answers page
Then the correct dependant details with updated children details will be displayed
And the dependant details for updated partnerName will be displayed

@bug @BP490-356
Scenario: Change partner dob details
When I select on change partnerDob details
Then the dynamic partners date of birth page will be displayed
And the parnerDob details are sustained
When I enter partner dob using different valid details
And I navigate from partner dob page to check your answers page
Then the correct dependant details with updated children details will be displayed
And the dependant details for updated partnerDob details will be displayed


Scenario: Change partner gender details
When I select on change partnerGender details
Then the dynamic value of partner first name is displayed on the partners gender page
And the partnerGender details are sustained
When I select gender using different valid option
And I navigate from partner gender page to check your answers page
Then the correct dependant details with updated children details will be displayed
And the dependant details for updated partnerGender details will be displayed


Scenario: Change partner nino details
When I select on change partnerNino details
Then the dynamic value of partners name will be displayed on partner's nino page
And the partnerNino details are sustained
When I enter partnerNino using different valid details
And I navigate from partnerNino page to check your answers page
Then the correct dependant details with updated children details will be displayed
And the dependant details for updated partnerNino details will be displayed

@bug @BP490-376
Scenario: Change dependant children details
When I select on change dependantChildren details
Then Do you have any dependant children page will be displayed
And the dependantChildren details are sustained
When I enter dependantChildren using different valid details
And I navigate from dependantChildren page to check your answers page
Then the correct dependant details with different child details will be displayed
And the dependant details for updated dependantChildren details will be displayed


Scenario: Change allocationPension details
When I select on change allocationPension details
Then do you want to allocate pension page will be displayed
And the allocatePension details are sustained
When I select allocatePension using different valid option
And Check your answers page for dependant details will be displayed
Then the correct dependant details with updated allocationPension details will be displayed
And the dependant details for updated allocatePension details will be displayed

@bug @BP490-375
Scenario: Change allocationPensionName details
When I select on change allocationPensionName details
Then the allocation name page will be displayed
And the allocatePensionName details are sustained
When I enter allocatePensionName using different valid details
And I navigate from allocatePensionName page to check your answers page
Then the correct dependant details will be displayed
And the dependant details for updated allocatePensionName details will be displayed

@bug @BP490-356
Scenario: Change allocationDOB details
When I select on change allocationDob details
Then the dynamic allocation date of birth page will be displayed
And the allocationDOB details are sustained
When I enter allocationDOB using different valid details
And I navigate from allocationDOB page to check your answers page
Then the correct dependant details will be displayed
And the dependant details for updated allocationDOB details will be displayed


Scenario: Change allocationRelationship details
When I select on change allocationRelationship details
Then the dynamic allocation relationship page will be displayed
And the allocationRelationship details are sustained
When I enter allocationRelationship using different valid details
And Check your answers page for dependant details will be displayed
Then the correct dependant details will be displayed
And the dependant details for updated allocationRelationship details will be displayed
