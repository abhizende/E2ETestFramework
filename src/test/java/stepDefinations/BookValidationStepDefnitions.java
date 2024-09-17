package stepDefinations;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import pojo.AddBook;
import resources.TestContextSetup;
import resources.TestDataBuild;
import resources.Utils;

public class BookValidationStepDefnitions extends Utils{
	
	public RequestSpecification res;
	public TestDataBuild data = new TestDataBuild();
	public TestContextSetup testContextSetup;
	
	public BookValidationStepDefnitions(TestContextSetup testContextSetup) 
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Given("Add the Book with Pay Load for the {string}")
	public void add_the_book_with_pay_load_for_the(String API) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		testContextSetup.res=given().spec(requestSpecification(API)).body("{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\"bcdxc\",\r\n"
				+ "\"aisle\":\"23\",\r\n"
				+ "\"author\":\"John foer\"\r\n"
				+ "}\r\n"
				+ "");
	}








}
