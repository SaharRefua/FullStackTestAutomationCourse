package Lesson17;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.o;
import static org.testng.AssertJUnit.assertEquals;

public class ChuckNorrisEx {
    public static RequestSpecification request;
    public static Response response;
    final String baseURL = "https://api.chucknorris.io";
    protected WebDriver driver;
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
    public void Test03_SaveJokes() throws IOException {
        for (int i=0;i<10;i++){
            response = request.get("/jokes/random");
            assertEquals(response.statusCode(), 200);
            response.prettyPrint();
            jp = response.jsonPath();
            String url = jp.getString("url");
            String value = jp.getString("value");
            writeCSV(url,value);

            System.out.println(url);
            System.out.println(value);
        }

    }
    public void writeCSV(String url, String value) throws IOException {
        FileWriter pw = new FileWriter("./results.csv",true);
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append(',');
        sb.append(value.replace(",", ""));
        sb.append('\n');
        pw.write(sb.toString());
        pw.close();
    }

    @Test
    public void Test04_SaveJokes() throws IOException {
            response = request.get("/jokes/random?category=movie");
            assertEquals(response.statusCode(), 200);
            response.prettyPrint();
            jp = response.jsonPath();
            String url = jp.getString("url");
            String value = jp.getString("value");
            System.out.println(url);
            System.out.println(value);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String joke = driver.findElement(By.xpath("//p[@id='joke_value']")).getText();
            System.out.println(joke);
            assertEquals(joke,value);
            driver.quit();

    }
}
