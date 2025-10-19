Feature: Thsi feature is to practice interactions with alerts


  @alerts
  Scenario: To test a simple alert
    Given Alert page is launched
    When simple alert is clicked
    Then print the alert text
    And accept the alert


  @alerts@timeralert
  Scenario: To test a timer alert
    Given Alert page is launched
    When timer alert is clicked
    Then print the alert text
    And accept the alert


  @alerts@confirmationalert
  Scenario: To test a timer alert
    Given Alert page is launched
    When confirmation alert is clicked
    Then print the alert text
    And accept the alert
    And print the selected option
    And Alert page is launched
    When confirmation alert is clicked
    Then print the alert text
    And dismiss the alert
    And print the selected option


  @alerts@promptalert
    Scenario: To test a prompt alert
    Given Alert page is launched
    When prompt alert is clicked
    Then print the alert text
    And enter some text
    And accept the alert
    Then Validate the result
    And Alert page is launched
    When prompt alert is clicked
    Then print the alert text
    And dismiss the alert