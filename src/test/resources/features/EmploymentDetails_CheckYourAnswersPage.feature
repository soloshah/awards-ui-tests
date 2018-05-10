@EmploymentDetailsCheckYourAnswers @BP490-215
Feature: Check Your Answers for employment details

@Bug @BP490-352
Scenario: Working for NHS
Given I have filled in current employment details
And Check your answers page will be displayed
And the correct current employment details will be displayed
And I submit all details
Then the summary page will be displayed


Scenario: Change current Employer Name
Given I have filled in current employment details
When I click on change currentEmployerName
Then What is the name of your current employer page will be displayed
And the currentEmploymentName details are sustained
When I enter currentEmployerName using different valid details
And I navigate from current employer name page to check your answers page
Then Check your answers page will be displayed
And the correct current employment details will be displayed
And the updated current employerName will be displayed


Scenario: Change current Employer Address
Given I have filled in current employment details
When I click on change currentEmployerAddress
Then the employers address page will be displayed
And the currentEmploymentAddress details are sustained
When I enter currentEmployerAddress using different valid details
And I navigate from current employer address page to check your answers page
Then Check your answers page will be displayed
And the correct current employment details will be displayed
And the updated current employerAddress will be displayed

@bug @BP490-303
Scenario: Change last day of work
Given I have filled in current employment details
When I click on change currentLastDay
Then the last day of work page will be displayed
And the lastDayOfWork details are sustained
When I enter lastDayOfWork using different valid details
And I navigate from last day of work page to check your answers page
Then Check your answers page will be displayed
And the correct current employment details will be displayed
And the updated current lastDay will be displayed

@bug @BP490-303
Scenario: Change date you return
Given I have filled in current employment details
When I click on change currentReturnDate
And the intend to work for NHS page will be displayed
And the intend to work details are sustained
When I enter return date using different valid details
Then Check your answers page will be displayed
And the correct current employment details will be displayed
And the updated current returnDate will be displayed

@bug @BP490-303
Scenario: Change Intend to work
Given I have filled in current employment details
When I click on change currentIntendToWork
And the intend to work for NHS page will be displayed
And the intend to work details are sustained
When I choose No
Then Check your answers page will be displayed
And the new current employment details will be displayed
And the updated current intendToWork will be displayed


Scenario: Change Working for NHS
Given I have filled in current employment details
When I click on change workingForNHS
Then are you working for NHS page will be displayed
And the working for nhs details are sustained
When I select No
Then I fill in the last employment details
Then Check your answers page will be displayed
And the new last employment details will be displayed
And the updated last workingForNHS will be displayed


Scenario: Change last employer name
Given I have filled in last employment details
When I click on change lastEmployerName
Then What was the name of your last employer page will be displayed
And the last employer name details are sustained
When I enter last employer name using different valid details
And I navigate from last employer name page to check your answers page
Then Check your answers page will be displayed
And the correct last employment details will be displayed
And the updated last employmentName will be displayed


Scenario: Change job title
Given I have filled in last employment details
When I click on change lastJobTitle
Then the job title page will be displayed
And the job title details are sustained
When I enter job title using different valid details
And I navigate from job title page to check your answers page
Then Check your answers page will be displayed
And the correct last employment details will be displayed
And the updated last jobTitle will be displayed

@bug @BP490-303
Scenario: Change date you leave
Given I have filled in last employment details
When I click on change lastLeavingDate
Then the date you leave page will be displayed
And the date you leave details are sustained
When I enter date you leave using different valid details
And I navigate from date you leave page to check your answers page
Then Check your answers page will be displayed
And the correct last employment details will be displayed
And the updated last leavingDate will be displayed

