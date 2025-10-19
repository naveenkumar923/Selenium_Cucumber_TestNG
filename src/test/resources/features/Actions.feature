Feature: This is to test Actions class in Selenium

  @Actions
  Scenario: Drag and Drop
    Given User access herokudraganddrop page
    Then Perform the Drag and drop action



  @Actions@Rightclick
    Scenario: Right click
    Given user access rightclick page
    When user clicks on the box
    Then user switches to the alert and prints the text
    And closes the browser


  @Actions@Slider
    Scenario: Horizontal Slider
    Given user is on slider page
    When user slides the bar
    Then print the slider value