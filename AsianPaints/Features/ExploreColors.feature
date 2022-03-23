#Author: your.email@your.domain.com SANTHOSH DHANSEKARAN
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
Feature: Asian Paints Homepage ExploreColors Redirects

  @ExploreColors
  Scenario: Validation of Homepage ExploreColors redirects
    Given User is on the Homepage 
    When User Clicks on ExploreColors
    Then It Redirects to ExploreColors page
   
  @PaintBudgetCalC
  Scenario: Validation of Homepage PaintBudgetCalC redirects
    Given User is on the Homepage  
    When User Clicks on PaintBudgetCalC
    Then It Redirects to PaintBudgetCalC page
   