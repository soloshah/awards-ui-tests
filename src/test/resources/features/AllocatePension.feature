@AllocatPension @BP490-110
Feature: Do you want to allocate part of your pension

Background:
Given I am on the start page
When I go to do you want to allocate page


Scenario: Do you want to allocate
When I select Yes
Then the allocation name page will be displayed


Scenario: Do you want to allocate
When I select No
Then Check your answers page will be displayed

@Bug @BP490-274
Scenario: Do you want to allocate
When I dont select anything
Then the radio button not selected error message 'Select 'yes' if you want to allocate part of your pension' will be displayed 

Scenario: Verify the allocation information link
When I click on the link what is allocation
Then the allocation information text will be displayed