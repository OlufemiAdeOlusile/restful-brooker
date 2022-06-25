@Api

Feature: dummy api

  Scenario: employee all search
    Given an endpoint with url "https://dummy.restapiexample.com/api/v1"
    When a get request with route "/employees"
    Then status code is "200"
    And body should contain strings
      | body                  | data        |
      | data[0].employee_name | Tiger Nixon |
      | data[2].employee_name | Ashton Cox  |

    And body should contain int
      | body                    | data   |
      | data[0].employee_salary | 320800 |
      | data[0].employee_age    | 61     |
      | data[2].employee_salary | 86000  |

  Scenario: employee search first record
    Given an endpoint with url "https://dummy.restapiexample.com/api/v1"
    When a get request with route "/employee/1"
    Then status code is "200"
    And body should contain strings
      | body               | data        |
      | data.employee_name | Tiger Nixon |
    And body should contain int
      | body                 | data   |
      | data.employee_salary | 320800 |
      | data.employee_age    | 61     |
      | data.id              | 1      |
