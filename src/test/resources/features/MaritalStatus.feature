@MaritalStatus @BP490-93
Feature: What is your marital status

Background:

Given I am on the start page
When I go to the marital status page


Scenario: Marital status as single
When I select single on marital status page
Then the marital status submission will be successful
And Do you have any dependant children page will be displayed


Scenario: Marital status as Married
When I select married on marital status page
Then the married date fields will be displayed
And I enter valid married date
And the marital status submission will be successful
Then Do you have any dependant children page will be displayed


Scenario: Marital status as Civil partnership
When I select civilPartnership on marital status page
Then the civilPartnership date fields will be displayed
And I enter valid civilPartnership date
And the marital status submission will be successful
Then Do you have any dependant children page will be displayed


Scenario: Marital status as Widow
When I select widowed on marital status page
Then the widowed date fields will be displayed
And I enter valid widowed date
And the marital status submission will be successful
Then Do you have any dependant children page will be displayed


Scenario: Marital status as Divorced
When I select divorced on marital status page
Then the divorced date fields will be displayed
And I enter valid divorced date
And the marital status submission will be successful
Then Do you have any dependant children page will be displayed


Scenario Outline: Married date field validation
When I select married on marital status page
Then the married date fields will be displayed
And I enter invalid married date details using the day '<day>', month '<month>' and year '<year>'
Then the marital status submission will be unsuccessful
And the married date error message '<errorMessage>' will be displayed
Examples:
           |day | month  |year| errorMessage                                                  |
           |    |        |    | You must enter the date you got married                       |   
           |    |  12    |1982| Enter a valid date                                            |
           |10  |        |1965| Enter a valid date                                            |
           |12  | 10     |    | Enter a valid date                                            |
           |45  | 13     |1234| Enter a valid date                                            |
           |RR  | WW     |GGGG| Enter a valid date                                            |
           |32  | 13     |1900| Enter a valid date                                            |
           |29  | 02     |2001| Enter a valid date                                            |
           |31  | 02     |2000| Enter a valid date                                            |
           |31  | 11     |1980| Enter a valid date                                            |
           |01  | 01     |1889| The date you enter must be equal to or greater than 01 01 1900|


Scenario Outline: Civil partnership date field validation
When I select civilPartnership on marital status page
Then the civilPartnership date fields will be displayed
And I enter invalid civilPartnership date details using the day '<day>', month '<month>' and year '<year>'
Then the marital status submission will be unsuccessful
And the civilPartnership date error message '<errorMessage>' will be displayed
Examples:
           |day | month  |year| errorMessage                                                  |
           |    |        |    | You must enter the date you entered your civil partnership    |   
           |    |  12    |1982| Enter a valid date                                            |
           |10  |        |1965| Enter a valid date                                            |
           |12  | 10     |    | Enter a valid date                                            |
           |45  | 13     |1234| Enter a valid date                                            |
           |RR  | WW     |GGGG| Enter a valid date                                            |
           |32  | 13     |1900| Enter a valid date                                            |
           |29  | 02     |2001| Enter a valid date                                            |
           |31  | 02     |2000| Enter a valid date                                            |
           |31  | 11     |1980| Enter a valid date                                            |
           |01  | 01     |1889| The date you enter must be equal to or greater than 01 01 1900|

Scenario Outline: Partner dies date field validation
When I select widowed on marital status page
Then the widowed date fields will be displayed
And I enter invalid widowed date details using the day '<day>', month '<month>' and year '<year>'
Then the marital status submission will be unsuccessful
And the widowed date error message '<errorMessage>' will be displayed
Examples:
           |day | month  |year| errorMessage                                                  |
           |    |        |    |	You must enter the date your partner died                     |   
           |    |  12    |1982| Enter a valid date                                            |
           |10  |        |1965| Enter a valid date                                            |
           |12  | 10     |    | Enter a valid date                                            |
           |45  | 13     |1234| Enter a valid date                                            |
           |RR  | WW     |GGGG| Enter a valid date                                            |
           |32  | 13     |1900| Enter a valid date                                            |
           |29  | 02     |2001| Enter a valid date                                            |
           |31  | 02     |2000| Enter a valid date                                            |
           |31  | 11     |1980| Enter a valid date                                            |
           |01  | 01     |1889| The date you enter must be equal to or greater than 01 01 1900|
           
           
Scenario Outline: Divorced date field validation
When I select divorced on marital status page
Then the divorced date fields will be displayed
And I enter invalid divorced date details using the day '<day>', month '<month>' and year '<year>'
Then the marital status submission will be unsuccessful
And the divorced date error message '<errorMessage>' will be displayed
Examples:
           |day | month  |year| errorMessage                                                                     |
           |    |        |    |	You must enter the date you got divorced or your civil partnership was dissolved |  
           |    |  12    |1982| Enter a valid date                                                               |
           |10  |        |1965| Enter a valid date                                                               |
           |12  | 10     |    | Enter a valid date                                                               |
           |45  | 13     |1234| Enter a valid date                                                               |
           |RR  | WW     |GGGG| Enter a valid date                                                               |
           |32  | 13     |1900| Enter a valid date                                                               |
           |29  | 02     |2001| Enter a valid date                                                               |
           |31  | 02     |2000| Enter a valid date                                                               |
           |31  | 11     |1980| Enter a valid date                                                               |
           |01  | 01     |1889| The date you enter must be equal to or greater than 01 01 1900                   |
    
                   
Scenario: What is your marital status
When I dont select anything on marital status page
Then marital status page error message 'You must select your marital status' will be displayed 


Scenario: Default value for marital status
Then the default value for marital status will be blank
