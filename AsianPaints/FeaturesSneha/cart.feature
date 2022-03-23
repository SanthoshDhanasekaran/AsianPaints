#Author: your.email@your.domain.com SNEHA TIDKE
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Asian Paints
   This is a template to store item in cart into a paint app.

  Scenario: Empty Cart
   	Given I am on asianpaints cart page
    When user click on cart 
    And user gets empty cart
    Then user gets start shopping
