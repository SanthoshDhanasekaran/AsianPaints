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
Feature: Asian Paints Homepage Social Media Redirects

  @Facebook_Redirect
  Scenario: Validation of Asian Paints Facebook redirect
    Given User is in the Homepage Footer 
    When User Clicks on the Facebook Icon
    Then Redirect to the Asian Paints Facebook page

  @Twitter_Redirect
  Scenario: Validation of Asian Paints Twitter redirect
    Given User is in the Homepage Footer 
    When User Clicks on the Twitter Icon
    Then Redirect to the Asian Paints Twitter page
  
  @Pinterest_Redirect
  Scenario: Validation of Asian Paints Pinterest redirect
    Given User is in the Homepage Footer 
    When User Clicks on the Pinterest Icon
    Then Redirect to the Asian Paints Pinterest page
    
  @Instagram_Redirect
  Scenario: Validation of Asian Paints Instagram redirect
    Given User is in the Homepage Footer 
    When User Clicks on the Instagram Icon
    Then Redirect to the Asian Paints Instagram page
    
	@Youtube_Redirect
  Scenario: Validation of Asian Paints YouTube redirect
    Given User is in the Homepage Footer 
    When User Clicks on the YouTube Icon
    Then Redirect to the Asian Paints YouTube page
  

