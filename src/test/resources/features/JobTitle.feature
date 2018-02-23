@JobTitle @BP490-123
Feature: What was your job title

Background:
#Given I am on the job title page
Given I am on the start page
When I go to the job title page


Scenario: Valid job title details
When I enter valid job title details
#Then the job title submission will be successful
And the tbi page will be displayed
#And the date you leave page will be displayed


Scenario Outline: Job title field validations 
When I enter job title details using the title '<title>'
Then the job title submission will be unsuccessful
And the job title error message '<errorMessage>' will be displayed
Examples:
| title     | errorMessage                                                     |
|           |Enter your job title                                              | 
|In%$ £"^&*"|Enter name using only numbers, letters a to z, spaces and hyphens |


Scenario: Job title field length validations 
When I enter valid job title using the jobTitle 'InvalidInvalidInvalid@Inv' 
Then the length of job title is verified
And the job title submission will be unsuccessful
