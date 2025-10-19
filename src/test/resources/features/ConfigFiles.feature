Feature: Testing using Config files

  @config
  Scenario Outline: Testing Config files
    Given testing to be done using config files
    Then print config file contents "<Subject>" and "<Marks>"
    Examples:
    |Subject|Marks|
    |sub1   |mark1|
    |sub2   |mark2|
    |sub3   |mark3|