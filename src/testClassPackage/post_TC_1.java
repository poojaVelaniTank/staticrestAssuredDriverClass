package testClassPackage;
import java.io.IOException;
import java.time.LocalDate;
import org.testng.Assert;

import Post_req_repositoryPackage.post_req_repository;
import commonFunctionPackage.APICommonFunctions;
import commonFunctionPackage.Utility_Common_Functions;
import requestRepositoryPackage.Post_Req_Repository;
import io.restassured.path.json.JsonPath;
import testClassPackage.post_TC_1;

public class post_TC_1 {
	public static void execute() throws IOException {
		
		for(int i=0 ; i<5; i++)
		{
			int res_statusCode=APICommonFunctions.res_statusCode(Post_Req_Repository.base_URI(),
					Post_Req_Repository.post_resource(),Post_Req_Repository.post_resource());
			if(res_statusCode==201)
			{
			String responsebody=APICommonFunctions.res_responseBody(Post_Req_Repository.base_URI(),
					Post_Req_Repository.post_resource(),Post_Req_Repository.post_resource());
			System.out.println(responsebody);
			post_TC_1.validator(responsebody, res_statusCode);
			Utility_Common_Functions.evidencecreator("post_TC_1",post_req_repository.post_TC_1(),responsebody);
			break; 
		}  else
		{
			System.out.println("correct status code is not found hence retrying the API");   }
		}
		} 
		public static void validator(String responsebody,int res_statusCode)  {
			JsonPath jspresponse=new JsonPath(responsebody);
			String res_name=jspresponse.getString("name");
			String res_job=jspresponse.getString("job");
			String res_id=jspresponse.getString("id");
			String res_createdAt=jspresponse.getString("createdAt");
			

			/* fetch request body
			JsonPath jspreq=new JsonPath(post_req_repository.post_TC1());
			String req_name=jspreq.getString("name");
			String req_job =jspreq.getString("job");
			*/
			
			// step 6 validation
			Assert.assertEquals(res_name,"pooja");
			Assert.assertEquals(res_job, "lead");
			Assert.assertNotNull(res_id);
			String currentdate=LocalDate.now().toString();
			Assert.assertEquals(res_createdAt.substring(0,10), currentdate);
		
		}	
	
	}
	

		
			
			
		
	
	