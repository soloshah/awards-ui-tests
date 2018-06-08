@RelationshipToYou @BP490-114
Feature: What is their relationship to you

Background:
Given I am on the start page


Scenario: Valid relationship field details
When I enter valid dependant details
Then the allocation relationship page will be displayed
And I enter valid relationship
Then the relationship submission will be successful
And Check your answers page will be displayed


Scenario Outline: relationship name field validations
When I go to the relationship page
When I enter relationship name details using the name '<name>'
Then the relationship submission will be unsuccessful
And the relationship name error message '<errorMessage>' will be displayed
Examples:
| name           | errorMessage                                                         |
|                |You must enter the person's relationship to you                       | 
|In56drf%$ £"^&*"|Enter names using only letters a to z, spaces, apostrophes and hyphens|
