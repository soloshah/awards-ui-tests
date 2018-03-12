@CurrentEmployerName @BP490-119
Feature: What is the name of your current NHS employer

Background:
#Given I am on the name of the current NHS employer page
Given I am on the start page
When I go to the name of your current NHS employer page


Scenario: Valid name of your current NHS employer details
When I enter valid name of current NHS employer details
And the name of your current NHS employer page submission will be successful
Then the employers address page will be displayed


Scenario Outline: Name of your current NHS employer field validations 
When I enter name of current NHS employer details using the name '<name>'
Then the name of your current NHS employer page submission will be unsuccessful
And the name of your current NHS employer error message '<errorMessage>' will be displayed
Examples:
| name      | errorMessage                                            |
|           | Enter the name of your current NHS employer             | 
|In%$ £"^&*"|Enter name using only letters a to z, spaces and hyphens |


