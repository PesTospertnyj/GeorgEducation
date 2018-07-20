Feature: Open google
  Open google

  Scenario Outline: Finding some cheese
    Given I am on the Google search page
    When I search for "<term>"
    Then the page title should start with "<titleStartWith>"

    Examples:
      | term        | titleStartWith |
      | Cheese!     | cheese         |
      | Some bread! | some bread     |


