Feature: This feature tests interactions with a dropdown

  @dropdown
  Scenario: Interactions with dropdown
    Given Launch a new Chrome browser.
    When Opens menu page
    And Selects old style select menu
    Then Prints all options
    And Selects Purple using index
    And Selects Magenta using visible text
    And Selects an option using value
    And Close the Browser.