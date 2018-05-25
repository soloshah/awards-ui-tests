@LifetimeAllowance @BP490-152
Feature: Do you have lifetime allowance

Background:
Given I am on the start page
When I go to lifetime allowance page


Scenario Outline: do you have lifetime allowance
When I select Yes on lifetime allowance page
Then the certificate number field will be displayed
And I enter the valid certificate number using the certNumber '<certNumber>'
And the lifetime allowance submission will be successful
Then Check your answers page will be displayed
Examples:
        |certNumber      |
        |31234567        |
        |41234567        |
        |51237456        |
        |82563251        |
        |95621245        |
        |A5528888        |
        |FP1612345678912 |
        |FP1452596451222 |
        |IP1689564231545 |
        |IP1485212345678 |
        |fp1656897452132 |
        |ip1685695471256 |
        |fp1415526547891 |
        |ip1454545458454 |

Scenario Outline: Certificate Number field validation
When I select Yes on lifetime allowance page
Then the certificate number field will be displayed
And I enter invalid certificate number using the certNumber '<certNumber>'
Then the lifetime allowance submission will be unsuccessful
And the certificate number error message '<errorMessage>' will be displayed
Examples:
           |certNumber       | errorMessage                                              |
           |                 | You must enter a certificate number in the correct format |
           | 1234564A        | You must enter a certificate number in the correct format |  
           | !"£$%^&*()@:?>< | You must enter a certificate number in the correct format |  
           | 5865231252632   | You must enter a certificate number in the correct format |  
           | AB76yuhnhgn     | You must enter a certificate number in the correct format |  
           | fp16/576668899  | You must enter a certificate number in the correct format |
           | ip16/576668899  | You must enter a certificate number in the correct format |
           | ip14 576668899  | You must enter a certificate number in the correct format | 
           | fp14 57.6668899 | You must enter a certificate number in the correct format |    
          
          

Scenario: Do you have any lifetime allowance
When I select No on lifetime allowance page
Then Check your answers page will be displayed


Scenario: Lifetime Allowance
When I dont select anything on lifetime allowance page
Then the lifetime allowance error message 'Select 'yes' if you have HMRC Lifetime Allowance protection' will be displayed 
