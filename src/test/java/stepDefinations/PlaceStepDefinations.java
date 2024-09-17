package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestContextSetup;
import resources.TestDataBuild;
import resources.Utils;

public class PlaceStepDefinations extends Utils {

	public RequestSpecification res;
	public Response response;
	public ResponseSpecification responseSpec;
	public TestDataBuild data = new TestDataBuild();
	static String place_id;
	public TestContextSetup testContextSetup;
	
	public PlaceStepDefinations(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
	}

	@Given("Add Place Pay Load with {string} {string} {string} for the {string}")
	public void add_place_pay_load_with_for_the(String name, String language, String address,String API) throws IOException {
		testContextSetup.res = given().spec(requestSpecification(API)).body(data.addPlacePayLoad(name, language, address));
		
	}
	
	

	@When("User calls {string} with {string} Http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {
		// Write code here that turns the phrase above into concrete actions

		APIResources resourceAPI = APIResources.valueOf(resource);

		testContextSetup.responseSpec = new ResponseSpecBuilder().build();
		switch (httpMethod) {
		case "POST":
			testContextSetup.response = testContextSetup.res.when().post(resourceAPI.getResource());
			System.out.println(testContextSetup.response.asString());
			break;
		case "GET":
			testContextSetup.response = testContextSetup.res.when().get(resourceAPI.getResource());
			System.out.println(testContextSetup.response.asString());
			break;
		}
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(testContextSetup.response.getStatusCode());
		assertEquals(200,testContextSetup.response.getStatusCode());
	}

	@Then("{string} in the response body is {string}")
	public void in_the_response_body_is(String keyValue, String expectedValue) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(getJsonPath(testContextSetup.response, keyValue), expectedValue);
	}

	@Then("verify {string} created maps to {string} using {string} for the {string}")
	public void verify_created_maps_to_using(String key, String expectdName, String resource,String API) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		place_id = getJsonPath(testContextSetup.response, key);

		testContextSetup.res = given().spec(requestSpecification(API)).queryParam(key, place_id);
		user_calls_with_http_request(resource, "GET");
		assertEquals(expectdName, getJsonPath(testContextSetup.response, "name"));

	}
	
	@Given("Delete Place Pay Load for the {string}")
	public void delete_place_pay_load_for_the(String API) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		testContextSetup.res = given().spec(requestSpecification(API))
				.body(testContextSetup.data.deletePlacePayload(place_id));
	}

}
