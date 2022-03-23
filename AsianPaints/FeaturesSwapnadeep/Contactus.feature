#Author: your.email@your.domain.com
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
  This is a template for Contacting in the paint app.

  @tag1
  Scenario: contact us in number.
    Given I am on asian paints home page
    When user clicks number
    Then user is redirected to call
    
  @tag2
  Scenario: contact us in email.
    Given I am on asian paints home page
    When user clicks email
    Then user is redirected to email
