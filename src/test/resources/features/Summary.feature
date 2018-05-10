@ApplicationSummary @BP490-96 @bug @BP490-382
Feature: Summary Page


Scenario: Personal details Section completed
Given I have completed personal details section
And the completed field will be displayed against personal details section
When I click on personal details link
Then Check your answers page will be displayed


Scenario: Dependant details Section completed
Given I have completed dependant details section
And the completed field will be displayed against dependant details section
When I click on dependant details link
Then Check your answers page will be displayed


Scenario: Employment details Section completed
Given I have completed employment details section
And the completed field will be displayed against employment details section
When I click on employment details link
Then Check your answers page will be displayed


Scenario: Contact details Section completed
Given I have completed contact details section
And the completed field will be displayed against contact details section
When I click on contact details link
Then Check your answers page will be displayed



Scenario: Pension details Section completed
Given I have completed pension details section
And the completed field will be displayed against pension details section
When I click on pension details link
Then Check your answers page will be displayed


Scenario: HMRC details Section completed
Given I have completed hmrc details section
And the completed field will be displayed against hmrc details section
When I click on hmrc details link
Then Check your answers page will be displayed


Scenario: Payment details Section completed
Given I have completed payment details section
And the completed field will be displayed against payment details section
When I click on payment details link
Then Check your answers page for payment details will be displayed


Scenario: Personal Details section not completed
Given I am on the start page
When I go to the summary page
And the personalDetail section is not completed
When I click on personal details link
Then the name page will be displayed

Scenario: Dependant Details section not comp-leted
Given I am on the start page
When I go to the summary page
And the dependantDetail section is not completed
When I click on dependant details link
Then What is your marital status page will be displayed


Scenario: Employment Details section not completed
Given I am on the start page
When I go to the summary page
And the employmentDetails section is not completed
When I click on employment details link
Then are you working for NHS page will be displayed


Scenario: Contact Details section not completed
Given I am on the start page
When I go to the summary page
And the contactDetails section is not completed
When I click on contact details link
Then Would you like to be contacted page will be displayed


Scenario: Pension Details section not completed
Given I am on the start page
When I go to the summary page
And the pensionDetails section is not completed
When I click on pension details link
Then which scheme page will be displayed


Scenario: HMRC Details section not completed
Given I am on the start page
When I go to the summary page
And the hmrcDetails section is not completed
When I click on hmrc details link
Then do you have any other pension arrangements page will be displayed


Scenario: Payment Details section not completed
Given I am on the start page
When I go to the summary page
And the paymentDetails section is not completed
When I click on payment details link
Then the bank account type page will be displayed


Scenario: Submit button disabled
Given I am on the start page
When I go to the summary page
And any section is not completed
Then the submit button will be disabled


Scenario: All Sections completed
Given I have completed all sections
When I click on submit button
Then the application submitted page will be displayed
