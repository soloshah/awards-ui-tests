@DepositAccount @BP490-134
Feature: Deposit Account Details

Background:
Given I am on the start page
When I go to deposit account details page


Scenario: Valid Deposit Account Details
And I enter valid deposit account details
#Then the deposit account details submission will be successful
#And enter bank details page will be displayed
Then the tbi page will be displayed

Scenario Outline: Account number field validations 
And I enter invalid deposit account details using the accountNumber '<accountNumber>'
Then the deposit account details submission will be unsuccessful
And the account number error message '<errorMessage>' will be displayed
Examples:
           |accountNumber | errorMessage                |
           |              | Enter an account number     |   
           | 123456       | Enter a valid account number|
           |"£$%^&*@      | Enter a valid account number|
           | ()12AYTO     | Enter a valid account number|
           | 5678-AGU     | Enter a valid account number|
           | 3456U78/.    | Enter a valid account number|

Scenario Outline: Roll Number field validations 
And I enter invalid deposit account details using the rollNumber '<rollNumber>'
Then the deposit account details submission will be unsuccessful
And the roll number error message '<errorMessage>' will be displayed
Examples:
           |rollNumber         | errorMessage             |
           |                   | Enter a roll number      |   
           | 123456U           | Enter a valid roll number|
           |!"£$%^&*()@~}¬{+   | Enter a valid roll number|
           | ()12A-/YTO        | Enter a valid roll number|
           | 5678_AGU.U76      | Enter a valid roll number|
           |AR/90 345678/.-893 | Enter a valid roll number|
          
       
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
                      
                  
Scenario Outline: Account Holder Name field validations 
And I enter invalid deposit account details using the accountHolderName '<accountHolderName>'
Then the deposit account details submission will be unsuccessful
And the account holder name error message '<errorMessage>' will be displayed
Examples:
           |accountHolderName   | errorMessage                                             |
           |                    | Enter the account holder's name                          |   
           |!"£$%^&*()=¬@~}     | Enter names using only letters a to z, spaces and hyphens|
           | 1234567            | Enter names using only letters a to z, spaces and hyphens|
           | 12A/ YTO           | Enter names using only letters a to z, spaces and hyphens|
           
           
Scenario: Account Holders name field length validations 
When I enter invalid account holder name using the name 'InvalidIn@ validInvalidIn'
Then The length of account holder name is verified
And the deposit account details submission will be unsuccessful
          