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
Feature: Search feature
  I want to use this template for my feature file

  @tag1
  Scenario: Popular search
    Given User is on the hompage
    When user click on searchbar
    Then user will get popular result

  @tag2
  Scenario Outline: search successfull
    Given User is on the hompage
    When user writes on searchbar
    And user press search button
    Then user will get search result


    