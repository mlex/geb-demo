Feature: Search movie database
  I want to search the movie database for a specific movie

  Scenario: Search movie database
    Given I am on the moviedatabase homepage
    When I search for "Star Wars"
    Then I should see the search result for "Star Wars"
    And The result should contain "Star Wars"
