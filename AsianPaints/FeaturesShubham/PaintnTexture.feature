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
  This is a template for Paint and Texture into a paint app.

  @tag1
  Scenario: Hover Successful
    Given I am on Asian Paints Homepage
    When I move cursor on Paints and Texture tab
    Then Paints and Texture tab is hovered
    
  @tag2
  Scenario: PaintnTexture Click Successful
    Given I am on Asian Paints Homepage
    When I click on Paints and Texture tab
    Then Paints and Texture tab is opened

  