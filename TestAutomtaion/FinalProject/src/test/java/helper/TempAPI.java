package helper;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TempAPI {
    RequestSpecification httpRequest;
    Response response;
    String url = "http://localhost:3000/";
    @Test
    public void TestingAPI(){
        RestAssured.baseURI= url;
        httpRequest = RestAssured.given().auth().preemptive().basic("admin","admin");
        //Get Request
//        response = httpRequest.get("/api/teams/search?name=kuku");
//        System.out.println(response.getBody().asString());


        //POST Request
//        httpRequest.header("Content-Type","application/json");
//        JSONObject params = new JSONObject();
//        params.put("email","BTeam@gail.com");
//        params.put("name","BTeam");
//        httpRequest.body(params.toJSONString());
//        response = httpRequest.post("/api/teams");
//        response.prettyPrint();


        //Put Request
//        httpRequest.header("Content-Type","application/json");
//        JSONObject params = new JSONObject();
//        params.put("email","BTeam@walla.com");
//        params.put("name","BTeam");
//        httpRequest.body(params.toJSONString());
//        response = httpRequest.put("/api/teams/3");
//        response.prettyPrint();

        //Delete Request
        response = httpRequest.delete("/api/teams/2");
        response.prettyPrint();
    }




}
