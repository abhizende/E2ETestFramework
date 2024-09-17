package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;
import resources.TestContextSetup;

public class Hooks {
	
	public TestContextSetup testContextSetup;

	@Before("@DeletePlaceAPI")
	public void beforeScenario() throws IOException {
		// write a code that will give you place_id
		PlaceStepDefinations sd = new PlaceStepDefinations(testContextSetup);
		if (sd.place_id == null) {
			sd.add_place_pay_load_with_for_the("Zende", "Hindi", "Charkop","MapsAPI");
			sd.user_calls_with_http_request("AddPlaceAPI", "POST");
			sd.verify_created_maps_to_using("place_id", "Zende", "GetPlaceAPI","");
		}
	}

}
