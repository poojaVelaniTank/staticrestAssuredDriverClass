package testClassPackage;
import java.io.IOException;
import java.time.LocalDate;
import org.testng.Assert;

import commonFunctionPackage.CommonAPIFunction;
import commonFunctionPackage.utilityCommonFunction;
import io.restassured.path.json.JsonPath;
import po_req_repo_Package.req_post_repository;
import testClassPackage.create_Tc_1;

public class create_Tc_1 {
	public static void execute() throws IOException {
		
		for(int i=0 ; i<5; i++)
		{
			int res_statusCode=CommonAPIFunction.res_statusCode(req_post_repository.baseURI(),
					req_post_repository.post_resource(),req_post_repository.post_resource());
			if(res_statusCode==201)
			{
			String responsebody=CommonAPIFunction.res_responseBody(req_post_repository.baseURI(),
					req_post_repository.post_resource(),req_post_repository.post_resource());
			System.out.println(responsebody);
			create_Tc_1.validator(responsebody, res_statusCode);
			utilityCommonFunction.evidencefilecreator("post_TC_1",req_post_repository.post_TC_1(),responsebody);
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
	

		
			
			
		
	
	