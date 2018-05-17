@SeparateBenefits @BP490-155
Feature: Separate Pension Benefits

Background:
Given I am on the start page
When I go to separate benefits page


Scenario: Select After 6 April 2006
And I select after April 6 2006 option
Then I enter the total combined percentage of lifetime allowance
And I enter the date of first benefit crystallisation
Then the lifetime allowance page will be displayed


Scenario:  Select Before 6 April 2006
And I select before April 6 2006 option
Then I enter the gross annual rate
And the lifetime allowance page will be displayed


Scenario:  Select I dont have information
And I select dont have information
Then the treat benefits page will be displayed


Scenario:  Select No
And I select dont have separate benefits
Then the lifetime allowance page will be displayed


Scenario:  Select before and after april 6
And I select after and before april 6 2006
And the lifetime allowance page will be displayed

@Bug @Bp490-387  
Scenario Outline: Combined % LTA field  validation
And I select after April 6 2006 option
Then I enter the invalid total percentage of LTA using '<LTA>'
And I enter the date of first benefit crystallisation
And the separate benefits submission will be unsuccessful
Then the error message '<errorMessage>' for annual LTA will be displayed
Examples:
          |LTA     |errorMessage                                                                 |
          |        |You must enter your total combined percentage of Lifetime Allowance          | 
          |123ABC  |You must enter your total combined Lifetime Allowance using numbers 0-9 only | 
          |1234567 |You must enter your total combined Lifetime Allowance using numbers 0-9 only |   
          |"£$%&*( |You must enter your total combined Lifetime Allowance using numbers 0-9 only |  
          | 123:09 |You must enter your total combined Lifetime Allowance using numbers 0-9 only |
          |@><:~;+=|You must enter your total combined Lifetime Allowance using numbers 0-9 only |

@Bug @Bp490-387       
Scenario Outline: Gross annual rate field  validation
And I select before April 6 2006 option
Then I enter the invalid gross annual rate using '<annualRate>'
And the separate benefits submission will be unsuccessful
Then the error message '<errorMessage>' for gross annual rate will be displayed
Examples:
          |annualRate |errorMessage                                                  |
          |           |You must enter your gross annual rate                         | 
          |123ABC     |	You must enter your gross annual rate using numbers 0-9 only |
          |1234567    |	You must enter your gross annual rate using numbers 0-9 only |  
          |"£$%&*(    |	You must enter your gross annual rate using numbers 0-9 only |  
          | 123:09    |	You must enter your gross annual rate using numbers 0-9 only |
          |@><:~;+=   |	You must enter your gross annual rate using numbers 0-9 only |
          

     
Scenario Outline: First benefit crystallisation date validation
And I select after April 6 2006 option
Then I enter the total combined percentage of lifetime allowance
And I enter the invalid date for benefit crystallisation using the day '<day>', month '<month>' and year '<year>'
And the separate benefits submission will be unsuccessful
Then the error message '<errorMessage>' for benefit crystallisation date will be displayed
Examples: 
           |day | month  |year| errorMessage                                                          |
           |    |        |    |	You must enter the date of first Benefit Crystallisation              |   
           |    |  12    |1982| Enter a valid date |
           |10  |        |1965| Enter a valid date |
           |12  | 10     |    | Enter a valid date |
           |45  | 13     |1234| Enter a valid date |
           |RR  | WW     |GGGG| Enter a valid date |
           |32  | 13     |1900| Enter a valid date |
           |29  | 02     |2001| Enter a valid date |
           |31  | 02     |2000| Enter a valid date |
           |31  | 11     |1980| Enter a valid date |
           |04  | 04     |2006|The date of first Benefit Crystallisation must be on or after 05/04/2006|
     
@Bug @Bp490-387  
Scenario: Benefit of crystallisation date equal to or greater than today's date
And I select after April 6 2006 option
Then I enter the total combined percentage of lifetime allowance
And I enter the benefit crystallisation date greater than today's date
Then the separate benefits submission will be unsuccessful
And the error message 'Enter a date before todays date' for benefit crystallisation date will be displayed    


Scenario: Separate Benefits validation 
And I dont select any option
Then the separate benefits submission will be unsuccessful
And the error message 'Select whether you have any separate benefits' for separate benefits page will be displayed


         
