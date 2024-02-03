package Lesson17;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ChuckNorrisEx {
    public static RequestSpecification request;
    public static Response response;
    final String baseURL = "https://api.chucknorris.io";
    String[][] data;
    JsonPath jp;

    @BeforeClass
    public void start() {
        RestAssured.baseURI = baseURL;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }

    @Test
    public void Test01_GetCategories() {
        response = request.get("/jokes/categories");
        response.prettyPrint();
        assertEquals(response.statusCode(), 200);
    }

    @Test
    public void Test02_WhatHaveMoreJokes() {
        response = request.get("/jokes/search?query=charlie sheen");
        //response.prettyPrint();
        assertEquals(response.statusCode(), 200);
        jp = response.jsonPath();
        String totalCharlie = jp.getString("total");
        //System.out.println(totalCharlie);
        response = request.get("/jokes/search?query=barack Obama");
        response.prettyPrint();
        jp = response.jsonPath();
        assertEquals(response.statusCode(), 200);
        String totalBarack = jp.getString("total");
        System.out.println(totalBarack);

        if (Integer.parseInt(totalCharlie) > Integer.parseInt(totalBarack)) {
            System.out.println("Charlie have more jokes than Barak");
        } else {
            System.out.println("Barak have more jokes than Charlie");
        }
    }

    @Test
    public void Test03_SaveJokes() {

        response = request.get("/jokes/random");
        assertEquals(response.statusCode(), 200);
        response.prettyPrint();
        jp = response.jsonPath();
        String urls = jp.getString("result.url");
        String values = jp.getString("result.value");

    }
}
