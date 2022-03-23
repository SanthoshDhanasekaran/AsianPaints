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
Feature: Asian Paints
  This is a template for top menu into a paint app.

  @tag1
  Scenario: Top Menu
    Given I am on Asian Paints Homepage for top menu on site
    When user should see top menu
    Then user redirect to homepage top menu

  @tag2
  Scenario: Hover Successful for Paint n texture
    Given I am on Asian Paints Homepage for top menu on site
    When I move cursor on Paints n Texture tab
    Then Paints n Texture tab is hovered
    
    
  @tag3
   Scenario: Hover Successful for Wallpapers
    Given I am on Asian Paints Homepage for top menu on site
    When I move cursor on Wallpapers tab
    Then Wallpapers tab is hovered
    
  @tag4
  Scenario: Hover Successful for Health and Hygiene
    Given I am on Asian Paints Homepage for top menu on site
    When I move cursor on Health and Hygiene tab
    Then Health and Hygiene tab is hovered
    
  @tag5
  Scenario: Hover Successful for Services
    Given I am on Asian Paints Homepage for top menu on site
    When I move cursor on Services tab
    Then Services tab is hovered
    
   @tag6
  Scenario: Hover Successful for Ideas
    Given I am on Asian Paints Homepage for top menu on site
    When I move cursor on Ideas tab in top menu
    Then Ideas tab is hovered
    
    @tag7
  Scenario: Hover Successful for Shop
    Given I am on Asian Paints Homepage for top menu on site
    When I move cursor on Shop tab
    Then Shop tab is hovered