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
Feature: Asian Paints Homepage Header Design and Color App

	
	Background: Validation of Design and Color App
		Given User is in the Homepage header
		When User Clicks on the Design and Color App
		Then Redirect to the Design and Color App
		
	Scenario: Validation of painting app PlayStore
		When User clicks on the PlayStore image
		Then Redirects to PlayStore App Download
	
	Scenario: Validation of painting app AppStore 
		When User clicks on the AppStore image
		Then Redirects to AppStore App Download
	
	Scenario: Validation of User Phone Number to receive Applink
		When User Enters PhoneNumber to Receive link
		Then User receives AppLink
	
	
		
	