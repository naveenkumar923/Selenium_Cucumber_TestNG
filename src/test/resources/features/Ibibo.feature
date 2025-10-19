Feature: This feature tests the input suggestion for From city dropdown

  @Ibibo
  Scenario: Print the from city suggestions
    Given user launches Ibibo page
    And user closes popup1
    And user closes popup2
    When user inputs text in from city input
    Then print all the suggestions