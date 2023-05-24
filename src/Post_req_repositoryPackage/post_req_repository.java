package Post_req_repositoryPackage;

import java.io.IOException;
import java.util.ArrayList;

import commonFunctionPackage.Utility_Common_Functions;

public class post_req_repository {
	public static String baseURI()
	{
		String baseURI="https://reqres.in/";
		return baseURI;
	}
	public static String post_resource() {
		String resource="/api/ussers/";
		return resource;
	}
	public static String post_TC_1() throws IOException
	{
		ArrayList<String>data=Utility_Common_Functions.readdataexcel("Post_Test_Data",
				"Post_TC_2");
		String req_name=data.get(1);
		String req_job=data.get(2);
		String requestbody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\",\r\n"
				+ "}";
		return requestbody;
	}
}			
				
	
