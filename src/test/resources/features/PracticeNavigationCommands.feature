Feature: This features is to practice browser navigation commands

  @Navigation_Commands
  Scenario: Testing Navigation commands
    Given Launch a new Chrome browser.
    When Open ToolsQA Practice Automation Page
    Then Click on Registration link
    Then Come back to Home page
    Then Go back to Registration page
    Then Come back to Home Page using URL
    And Refresh the browser
    And Close the Browser.