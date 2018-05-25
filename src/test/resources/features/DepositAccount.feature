@DepositAccount @BP490-134 @BP490-252
Feature: Deposit Account Details

Background:
Given I am on the start page
When I go to deposit account details page


Scenario: Valid Deposit Account Details
And I enter valid deposit account details
Then the deposit account details submission will be successful
And the otherEqPensions page will be displayed


@Bug @BP490-278   @Bug @BP490-394
Scenario Outline: Account number field validations 
And I enter invalid deposit account details using the accountNumber '<accountNumber>'
Then the deposit account details submission will be unsuccessful
And the account number error message '<errorMessage>' will be displayed
Examples:
           |accountNumber | errorMessage                |
           |              | Enter an account number     |   
           | 123456       | Enter a valid account number|
           |"£$%^&*@      | Enter a valid account number|
           | 5678-AGU/.   | Enter a valid account number|
         # | ABVCFRGK     | Enter a valid account number|

@Bug @BP490-278
Scenario Outline: Roll Number field validations 
And I enter invalid deposit account details using the rollNumber '<rollNumber>'
Then the deposit account details submission will be unsuccessful
And the roll number error message '<errorMessage>' will be displayed
Examples:
           |rollNumber         | errorMessage             |
           |                   | Enter a roll number      |   
           |!"£$%^&*()@~}¬{+   | Enter a valid roll number|
           | 5678_AGU.U76      | Enter a valid roll number|
           |AR/90 345678/.-893 | Enter a valid roll number|
          
@Bug @BP490-278       
Scenario Outline: SortCode field validations 
And I enter invalid sort code details using the sortCode1 '<sortCode1>', sortCode2 '<sortCode2>' and sortCode3 '<sortCode3>'
Then the deposit account details submission will be unsuccessful
And the sort code error message '<errorMessage>' will be displayed
Examples:
           | sortCode1 |sortCode2| sortCode3 | errorMessage           |
           |           |         |           | Enter a sort code      | 
           |           |  33     |  11       | Enter a valid sort code|
           | 11        |         |  11       | Enter a valid sort code|
           | 11        |  22     |           | Enter a valid sort code|
           | ss        |ww       | rr        | Enter a valid sort code|
           |  1        | 2       | 3         | Enter a valid sort code|
           |  *"       |  £$     | &%        | Enter a valid sort code|
           |  1Q       |  7U     |  0O       | Enter a valid sort code|
                      
@Bug @BP490-278 @Bp490-330             
Scenario Outline: Account Holder Name field validations 
And I enter invalid deposit account details using the accountHolderName '<accountHolderName>'
Then the deposit account details submission will be unsuccessful
And the account holder name error message '<errorMessage>' will be displayed
Examples:
           |accountHolderName   | errorMessage                                                          |
           |                    | Enter the account holder's name                                       |   
           |!"£$%^&*()=¬@~}     | Enter names using only letters a to z, spaces, apostrophes and hyphens|
           | 1234567            | Enter names using only letters a to z, spaces, apostrophes and hyphens|
           | 12A/ YTO           | Enter names using only letters a to z, spaces, apostrophes and hyphens|
           
        
Scenario: Account Holders Name field length validations 
When I enter invalid account holder name using the name 'InvalidIn@ validInvalidIn'
Then The length of account holder name is verified
And the deposit account details submission will be unsuccessful
          