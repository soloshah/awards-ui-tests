@YourAddress @BP490-90
Feature: What is your Address

Background:
Given I am on the start page
When I go to your address page


Scenario: Valid Address Details
And I enter valid address details
Then the address details submission will be successful
And the national insurance page will be displayed


Scenario Outline: Building and street line 1 field validations 
And I enter invalid address details using the streetLineOne '<streetLineOne>'
Then the address details submission will be unsuccessful
And the building and street line one error message '<errorMessage>' will be displayed
Examples:
           |streetLineOne | errorMessage                                                        |
           |              | You must enter your building and street name                        |   
           | "£$%^&*@     | Enter address using only numbers, letters a to z, spaces and hyphens|
           | ()12AYTO     | Enter address using only numbers, letters a to z, spaces and hyphens|
          

Scenario Outline: Building and street Line 2 field validations 
And I enter invalid address details using the streetLineTwo '<streetLineTwo>'
Then the address details submission will be unsuccessful
And the building and street line two error message '<errorMessage>' will be displayed
Examples:
           |streetLineTwo       | errorMessage                                                        |
           | "£$%^&*@?/()       | Enter address using only numbers, letters a to z, spaces and hyphens|
           | hgn-yuiom jkhe'tr  | Enter address using only numbers, letters a to z, spaces and hyphens|
          
          
@Bug @ErrorMessage         
Scenario Outline: Town or city field validations 
And I enter invalid address details using the town '<town>'
Then the address details submission will be unsuccessful
And the town or city error message '<errorMessage>' will be displayed
Examples:
           | town            | errorMessage                         |
           |                 | You must enter your town or city     | 
           | "£$%^&*@?/()    | Enter address using only letters a to z, spaces and hyphens |
           |  12345095       | Enter address using only letters a to z, spaces and hyphens |
          
                  
Scenario Outline: Postcode field validations 
And I enter invalid address details using the postCode '<postCode>'
Then the address details submission will be unsuccessful
And the postcode error message '<errorMessage>' will be displayed
Examples:
           |postCode            | errorMessage                   |
           |                    | You must enter your postcode   |   
           |!"£$%^&*()=¬@~}     | You must enter a valid postcode|
           | 123 4567           | You must enter a valid postcode|
           | 12A/ YTO           | You must enter a valid postcode|
           | 12AYTO             | You must enter a valid postcode|
           | A12 YTO            | You must enter a valid postcode|
           | P12 3T0            | You must enter a valid postcode|
           | NA234TY            | You must enter a valid postcode|
 
@Bug @ErrorMessage           
Scenario Outline: Country field validations 
And I enter invalid address details using the country '<country>'
Then the address details submission will be unsuccessful
And the country error message '<errorMessage>' will be displayed
Examples:
           |country             | errorMessage                                             |
           |!"£$%^&*()=¬@~}     | Enter names using only letters a to z, spaces and hyphens|
           | 1234567            | Enter names using only letters a to z, spaces and hyphens|
           | 12A/ YTO           | Enter names using only letters a to z, spaces and hyphens|           
           
         
          