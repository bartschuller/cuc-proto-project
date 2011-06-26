Feature: Example feature
  In order to test their software
  Developers should write scenarios
  Using step definitions in Scala

  Scenario: A simple Scala test
    Given the two numbers 3 and 7
    When I multiply them
    Then the answer should be 21

  @web @firefox
  Scenario: Web stuff
    Given the website at http://www.smop.org/
    When I search for gimp
    Then the results should include Liquid Rescale
