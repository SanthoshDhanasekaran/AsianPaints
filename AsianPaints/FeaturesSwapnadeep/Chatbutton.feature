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
  This is a template for Chat Box in the paint app.

  @tag2
  Scenario: chatbox.
    Given I am on asian paints homepage
    When user clicks chat button
    And user selects option
    And user clicks minimize
    And user clicks chat button again
    And user clicks close
    Then chat box closes
  	
  
