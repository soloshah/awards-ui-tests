@LastEmployerName @BP490-122
Feature: What was the name of your last NHS employer

Background:
#Given I am on the name of the last NHS employer page
Given I am on the start page
When I go to the name of your last NHS employer page

@Bug @BP490-239
Scenario: Valid name of your last NHS employer details
When I enter valid name of last NHS employer details
Then the name of your last NHS employer page submission will be successful
And the job title page will be displayed


@Bug @BP490-237
Scenario Outline: Name of your last NHS employer field validations 
When I enter name of last NHS employer details using the name '<name>'
Then the name of your last NHS employer page submission will be unsuccessful
And the name of your last NHS employer error message '<errorMessage>' will be displayed
Examples:
| name      | errorMessage                                            |
|           |Enter the name of your last NHS employer                 | 
|In%$ £"^&*"|Enter name using only letters a to z, spaces and hyphens |
|1234567890P|Enter name using only letters a to z, spaces and hyphens |


