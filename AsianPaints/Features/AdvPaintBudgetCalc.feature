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
Feature: Asian Paints Advanced Budget Calculator

	@AdvBudgetCalc
  Scenario: Validation of Advanced Budget Calculator
    Given User is in the Homepage  
    When User Clicks PaintBudgetCalC
    Then It Redirects to PaintBudgetCalC 
  	When User Clicks on the AdvBudgetCalc
  	Then It opens the AdvBudgetCalc
  	 
  	
	
	
