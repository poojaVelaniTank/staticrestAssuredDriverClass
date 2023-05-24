package restAssuredRef2;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import java.time.LocalDateTime;

import org.testng.Assert;
public class postref {

	public static void main(String[] args) {
		//Step 1 : Configure API and requestbody
		String baseURI="https://reqres.in/";
		String requestbody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		//Step 2 : Configure API
		RestAssured.baseURI=baseURI;
		
		//Step 3 : COnfigure
		int statuscode=given().header("COntent-Type","application/json").body(requestbody).when().post("/api/users/")
				.then().extract().statusCode();
		System.out.println(statuscode);
		String responsebody=given().header("COntent-Type","application/json").body(requestbody).when().post("/api/users/")
				.then().extract().response().asString();
		System.out.println(responsebody);
		//Generate the required date in format
		LocalDateTime Date=LocalDateTime.now();
		String expdate=Date.toString().substring(0,10);
		
		//Configure requestbody
		JsonPath jsprequest = new JsonPath(requestbody);
		String req_name= jsprequest.get("name");
		String req_job = jsprequest.get("job");
		
		//Parse the responsebody
		JsonPath jsp = new JsonPath(responsebody);
		String res_name= jsp.getString("name");
		String res_job=jsp.getString("job");
		String res_id=jsp.getString("id");
		String res_createdAt=jsp.getString("createdAt");
		String res_date=res_createdAt.substring(0,10);
		
		//Validate the responsebody
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertNotNull("id");
		Assert.assertEquals(res_date, expdate);
	}
}
		
		
		
		
		
		
		
		
		
		
	


