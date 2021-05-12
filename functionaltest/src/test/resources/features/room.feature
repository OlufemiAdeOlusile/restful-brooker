@room

Feature: validate room booking


  Scenario Outline: create and delete rooms
    Given a user has logged in
    When the user books a room "<roomNumber1>" "<roomPrice1>"
    And the user books a room "<roomNumber2>" "<roomPrice2>"
    Then the user should be able to delete this room "<roomNumber1>"
    And the user should be able to delete this room "<roomNumber2>"

    Examples:
      | roomNumber1 | roomPrice1  | roomNumber2 | roomPrice2  |
      | 200        |  300         |  201        |  400        |


