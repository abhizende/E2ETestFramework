package resources;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TestContextSetup {

	public RequestSpecification res;
	public Response response;
	public ResponseSpecification responseSpec;
	public TestDataBuild data;

	public TestContextSetup() throws IOException
	{
		data=new TestDataBuild();
	}

}
