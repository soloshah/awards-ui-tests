@Spouse'sName
Feature: Spouse or civil partner's Name

Scenario: Valid Spouse Name details
Given I am on the spouse name page
When I enter valid spouse name details
Then the spouse name submission will be successful
And the spouse date of birth page will be displayed

Scenario Outline: Spouse First and Last name field validations 
Given I am on the spouse name page
When I enter spouse name details using the firstName '<firstName>' and lastName '<lastName>'
Then the spouse name submission will be unsuccessful
And the spouse name error message '<errorMessage>' will be displayed
Examples:
| firstName | lastName | errorMessage                                                        |
|           |          | You must enter your spouse's or civil partner's first and last name |
|Invalid    |          | You must enter your spouse's or civil partner's first and last name |
|           |Invalid   | You must enter your spouse's or civil partner's first and last name |
|In%$ £"^&*!|In%$ £"^&*!|Enter names using only letters a to z, spaces and hyphens|
|hgn-yuiom jkhe'tryu90hi.23|hgn-yuiom jkhe'tryu90hi235|Enter names using only letters a to z, spaces and hyphens|

