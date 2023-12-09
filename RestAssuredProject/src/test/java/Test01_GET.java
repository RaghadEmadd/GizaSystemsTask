
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.hamcrest.core.Is;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.Scanner;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Test01_GET {

	@Test
	public static void test_01() throws IOException {
		given().
		get("https://petstore.swagger.io/v2/pet/10").
		then().
		statusCode(200).
		log().all();
		Response response= given().when().get("https://petstore.swagger.io/v2/pet/10");
				//System.out.println(jsonResponse.);
		ResponseBody body= response.getBody();
		String bodyAsString= body.asPrettyString();
		
		Assert.assertEquals(bodyAsString.contains("doggie"),true);
		//only way i found to access the name doggie was to assert that it exists
		
				
		
		
	}
	@Test
	public static void test_02() {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter staus");
		String status= sc.nextLine();
		
	
		if(status.contentEquals("sold")) {
			String result1 = given().when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=sold").then().log().all().toString();
			System.out.println(result1);
		}else if(status.contentEquals("available")) {
			String result2 = given().when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available").then().log().all().toString();
			System.out.println(result2);
		}
		else {
			String result3 = given().when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=pending").then().log().all().toString();
			System.out.println(result3);
		}
	}
	@Test
	public static void test_03() throws UnsupportedEncodingException {


//		Map<String, Object> map= new HashMap<String ,Object >();
//		map.put("id","2556");
//		map.put("name","lucy");
//		System.out.println(map);
		
		JSONObject request= new JSONObject();
		request.put("id", "3444");
		request.put("id", "1");
		request.put("name", "dog");

		request.put("name", "sharky");
		request.put("photoUrls", "sharky");
		
		request.put("id", "13");
		request.put("name", "string");
		request.put("status", "pending");
		
		System.out.println(request);
		given().body(request.toJSONString()).
		when().post("https://petstore.swagger.io/v2/pet").then().statusCode(200).log().all();
		
	}
	
}
