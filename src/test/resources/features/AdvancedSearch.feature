@functional
Feature: Advanced Search - Repository

  Scenario: Verify that advanced search filters are working as expected
    Given the user goes to GitHub home page
    When the user searches "react"
    And the user enters to Advanced Search page
    And the user sets the following Advanced Search parameters
      | Written in this language | JavaScript                 |
      | In the state             | closed                     |
      | With this many stars     | >45                        |
      | With this many followers | >50                        |
      | With this license        | Boost Software License 1.0 |
    And the user clicks on Search button
    Then verifies that there is only "1" repository results
    And verifies that the result list contains the "mvoloskov/decider" repository
    And the user goes to "mvoloskov/decider" repository page
    And retrieves the 300 characters of the "README.md" file in "mvoloskov/decider" repository
