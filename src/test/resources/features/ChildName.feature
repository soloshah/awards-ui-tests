@Child'sName
Feature: Childs Name

Scenario: Valid Child Name details
Given I am on the child name page
When I enter valid child name details
Then the child name submission will be successful
And the child date of birth page will be displayed

Scenario Outline: Child First and Last name field validations 
Given I am on the child name page
When I enter child name details using the firstName '<firstName>' and lastName '<lastName>'
Then the child name submission will be unsuccessful
And the child name error message '<errorMessage>' will be displayed
Examples:
| firstName | lastName | errorMessage                               |
|           |          | You must enter child's first and last name |
|Invalid    |          | You must enter child's first and last name |
|           |Invalid   | You must enter child's first and last name |
|In%$ £"^&*"|In%$ £"^&*"|Enter names using only letters a to z, spaces and hyphens|
|hgn-yuiom jkhe'tryu90hi23|hgn-yuiom jkhe'tryu90hi235htjopyu|Enter names using only letters a to z, spaces and hyphens|

