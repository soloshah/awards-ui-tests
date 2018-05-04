@2015lumpSumPreference @BP490-148
Feature: 2015 Lump sum preference

Background:
Given I am on the start page
When I go to the 2015 lumpsum preference page


Scenario: Select lumpsum preference
And I select valid lumpsum preference using MaxTaxFreeAmount
Then the valid lumpsum preference text for MaxTaxFreeAmount will be displayed
And the lumpsum preference submission will be successful
And Check your answers page will be displayed


Scenario: Select lumpsum preference
And I select valid lumpsum preference using LessTaxFreeAmount
Then the valid lumpsum preference text for LessTaxFreeAmount will be displayed
And the amount field for lumpsum preference will be displayed
And I enter valid amount dividable by 12 for lumpsum preference
Then Check your answers page will be displayed


Scenario: Select lumpsum preference
And I select valid lumpsum preference using MaxAdditionalLumpSum
Then the valid lumpsum preference text for MaxAdditionalLumpSum will be displayed
And the lumpsum preference submission will be successful
And Check your answers page will be displayed


Scenario: 2015 Select lumpsum preference
And I dont select any lumpsum preference
Then the lumpsum preference submission will be unsuccessful
And the error message 'Select how you would like your lump sum' for 2015 lumpsum preference will be displayed


@Bug @BP490-315 @Bug @BP490-384
Scenario Outline: Less than max tax free amount validation
And I select valid lumpsum preference using LessTaxFreeAmount
Then the valid lumpsum preference text for LessTaxFreeAmount will be displayed
And the amount field for lumpsum preference will be displayed
And I enter invalid amount using '<amount>' for lumpsum preference
And the amount error message '<errorMessage>' for lumpsum preference will be displayed
Examples:
|amount |errorMessage                                  |
|       |Enter your lump sum amount in multiples of 12 |
|152363 |Enter your lump sum amount in multiples of 12 |
|*&^%Ab |Enter your lump sum amount in multiples of 12 |
|12.00  |Enter your lump sum amount in multiples of 12 |
|00000  |Enter your lump sum amount in multiples of 12 |
|-1440  |Enter your lump sum amount in multiples of 12 |
|100000000000000000000000|Enter your lump sum amount in multiples of 12 |         
