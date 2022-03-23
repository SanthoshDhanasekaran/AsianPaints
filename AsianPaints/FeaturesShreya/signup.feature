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
  This is a template for signup  into a paint app.

  @tag1
  Scenario: SignupSuccessful.
    Given I am on asianpaints signup page
    When user enters mobile number for signup
    And user enters credentials 
    Then user should signup
    @tag2
  Scenario: SignupUnSuccessful.
    Given I am on asianpaints signup page
    When user enters wrong mobile number for signup
    Then user should not signup
     