package Lesson17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class StudentEx {
    public static RequestSpecification request;
    public static Response response;
    final String baseURL = "http://localhost:9000";
    public List<String> list = Arrays.asList("Java Course", "CSharp Course", "Python Course");
    @BeforeClass
    public void start(){
        RestAssured.baseURI= baseURL;
        request = RestAssured.given();
        request.header("Content-Type","application/json");
    }
    @Test
    public void Test01_GetStudents(){
        response = request.get("/student/list");
        response.prettyPrint();
        assertEquals(response.statusCode(), 200);
    }

    @Test
    public void Test02_createNewStudent(){
        JSONObject params = new JSONObject();
        params.put("firstName","yoni");
        params.put("lastName","Flenner");
        params.put("email","toni.flenner@gmail.com");
        params.put("programme","QA Engineering");//        List [3] courses = "Java Course", "CSharp Course", "Python Course";
        params.put("courses", list);
        request.body(params.toJSONString());
        response = request.post("/student");
        response.prettyPrint();
        assertEquals(response.statusCode(), 201);
    }


    @Test
    public void Test03_UpdateStudent(){
        JSONObject params = new JSONObject();
        params.put("firstName","yoni");
        params.put("lastName","Flenner");
        params.put("email","toni.flenner@gmail.com");
        params.put("programme","Automation Engineering");
        request.body(params.toJSONString());
        response = request.put("/student/101");
        response.prettyPrint();
        assertEquals(response.statusCode(), 200);
    }

    @Test
    public void Test04_DeleteStudent(){
        response = request.delete("/student/100");
        response.prettyPrint();
        assertEquals(response.statusCode(), 204);
    }

}
