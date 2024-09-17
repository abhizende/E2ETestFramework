Feature: Validation of Libray Book API

  @AddBook
  Scenario: Verify if the add is successfully added using the Add Book API
    Given Add the Book with Pay Load for the "BookAPI"
    When User calls "AddBookAPI" with "POST" Http request
    Then the API call is success with status code 200
    And "Msg" in the response body is "successfully added"
    
