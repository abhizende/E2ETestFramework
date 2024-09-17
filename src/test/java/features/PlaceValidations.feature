Feature: Validating the Place API 

	@GetPlaceAPI
  Scenario Outline: Verify if the Place is being added successfully using AddPlace API
  
    Given Add Place Pay Load with "<name>" "<language>" "<address>" for the "MapsAPI"
    When User calls "AddPlaceAPI" with "POST" Http request
    Then the API call is success with status code 200
    And "status" in the response body is "OK"
    And "scope" in the response body is "APP"
    And verify "place_id" created maps to "<name>" using "GetPlaceAPI" for the "MapsAPI"
    
 Examples:
 		|name			|language	|address	|
 		|Abhishek	|English	|Mumbai		|
 #   |Zende		|Marathi	|Mumbai		|
 
 @DeletePlaceAPI
  Scenario: Verify if the Delete place working successfully using DeletePlaceAPI
  
    Given Delete Place Pay Load for the "MapsAPI"
    When User calls "DeletePlaceAPI" with "POST" Http request
    Then the API call is success with status code 200
    And "status" in the response body is "OK"
    
    
    
    