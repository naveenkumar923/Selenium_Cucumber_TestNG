Feature: To test window handles

  @Handles
  Scenario: Window Handles
    Given a page is open
    When User opens a new tab
    Then print new tab's Title and url
    And closes the new page
    Then print the available page's title and url