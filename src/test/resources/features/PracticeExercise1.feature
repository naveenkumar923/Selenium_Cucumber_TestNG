Feature: This feature is created to practice webdriver commands from toolsqa website

  @practiceexercise1
  Scenario: Practicing Webdriver commands
    Given Launch a new Chrome browser.
    When Open Shop.DemoQA.com
    Then Get Page Title name and Title length
    And Print Page Title and Title length on the Eclipse Console.
    And Get Page URL and verify if it is a correct page opened
    And Get Page Source and Page Source length
    And Print Page Length on Eclipse Console.
    And Close the Browser.

  @practiceexercise1
  Scenario: practicing clicking a web element
    Given Launch a new Chrome browser.
    When Open ToolsQA Practice Automation Page
    Then click on a New Browser Window button
    And Close the Browser.
