package Lesson16;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class RestAssuredEx {
    final String URL = "https://api.openweathermap.org/data/2.5/weather/";
    final String API_KEY = "cd9d83f7bbfb07a419cab476d907ebdd";
    final String CITY = "Kfar Saba";
    public static RequestSpecification httpRequest;
    public Response response;
    @BeforeClass
    public void startSession() {
        RestAssured.baseURI = URL;
        httpRequest = RestAssured.given();
    }
    @Test
    public void test01_printResponse(){
        response = httpRequest.get("?units=metric&q="+ CITY + "&appid="+ API_KEY);
        System.out.println(response.asString());
        response.prettyPrint();
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("Date"));
    }
    @Test
    public void test02_contentType(){
        response = httpRequest.get("?units=metric&q="+ CITY + "&appid="+ API_KEY);
        System.out.println(response.contentType());
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
    }
    @Test
    public void test03_getStatusCode(){
        response = httpRequest.get("?units=metric&q="+ CITY + "&appid="+ API_KEY);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
