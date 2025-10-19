Feature: This feature deals with switching between multiple windows

  @switchwindows
  Scenario: handling multiple windows
    Given testing a scenario
    When Open ToolsQA Practice Automation Page
    And current window handle is stored
    Then New Window button is clicked
    And new window handle is stored
    And Switched to newly opened window
    And title of new window is validated
    And newly opened window is closed
    And switched back to initial window
    And browser is closed