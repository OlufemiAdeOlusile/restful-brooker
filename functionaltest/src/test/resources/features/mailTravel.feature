@mail

Feature: mailtravel search


  Scenario Outline: search more info
    Given a user is on the homepage
    And verifies title "Home Page | Mail Travel"
    When the user searches for travel destination "<title>"
    And the user clicks more info on "<title>" "<text>" "<productDays>" "<productAmount>"
    Then the user should see the "<productDays>" "<productAmount>" "<phoneNumber>" on the More info page"

    Examples:
      | title | text                             | productDays | productAmount | phoneNumber   |
      | India | 11 Days - Classic Escorted Tours | 11          | £1,499        | 0808 239 6367 |


