package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddBook;
import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayLoad(String name, String language, String address) 
	{
		AddPlace add = new AddPlace();
		Location loc = new Location();
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");

		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		add.setAccuracy(50);
		add.setAddress(address);
		add.setLanguage(language);
		add.setLocation(loc);
		add.setPhone_number("(+91) 983 893 3937");
		add.setTypes(types);
		add.setWebsite("http://google.com");
		add.setName(name);
		
		return add;
	}
	
	public String deletePlacePayload(String place_id) 
	{
		return "{\r\n"
				+ "\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}";
	}
	
	public AddBook addBookPayload() 
	{
		AddBook addbook=new AddBook();
		addbook.setName("Abhdi");
		addbook.setIsbn("Testidng");
		addbook.setAisle("asdadsadsd12");
		addbook.setAuthor("Abhishek");
			
		return addbook; 
		
	}

}
