@JobTitle
Feature: What was your job title

Scenario: Valid job title details
Given I am on the job title page
When I enter valid job title details
Then the job title submission will be successful
And the date you leave page will be displayed

Scenario Outline: Job title field validations 
Given I am on the job title page
When I enter job title details using the title '<title>'
Then the job title submission will be unsuccessful
And the job title error message '<errorMessage>' will be displayed
Examples:
| title     | errorMessage                                                           |
|           |Enter your job title                                                    |
|In%$ £"^&*"|Enter names using only letters a to z, spaces and hyphens               |
|hgn-yu.iom jkhe'tryu90hi23|Enter names using only letters a to z, spaces and hyphens|
