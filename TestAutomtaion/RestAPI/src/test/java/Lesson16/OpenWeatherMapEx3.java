package Lesson16;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenWeatherMapEx3 {

    //API Objects:
    RequestSpecification httpRequest;
    Response response;
    JsonPath jp;
    final String API_BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    final String CITY = "Jerusalem,IL";
    final String API_KEY = "ad48510a9aed1ff96b51557d94bc5964";
    final String UNITS = "metric";
    //WEB Objects:
    WebDriver driver;
    WebDriverWait wait;
    final String WEB_URL="https://openweathermap.org/";




    @BeforeClass
    public void startSession() {

        //Init API:
        RestAssured.baseURI = API_BASE_URL;
        httpRequest = RestAssured.given();
        //Init WEB:
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(WEB_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,5);
    }
    @AfterClass
    public void closeSession(){
        driver.quit();
    }

    @Test
    public void test01VerifyWeather() {
        //Rest API
        response = httpRequest.get("?q=" + CITY + "&units=" + UNITS + "&appid=" + API_KEY);
        response.prettyPrint();
        jp=response.jsonPath();
        String Temperature=jp.getString("main.temp");
        String country=jp.getString("sys.country");
        String humidityFromAPI= jp.getString("main.humidity");
        System.out.println("Temperature is: "+Temperature);
        System.out.println("Country is: "+country);
        System.out.println("Humidity - API:  "+humidityFromAPI);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='q'])[1]")));
        driver.findElement(By.xpath("(//input[@name='q'])[1]")).sendKeys(CITY);
        driver.findElement(By.xpath("(//input[@name='q'])[1]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(//a[contains(text(),'Jerusalem, IL')])[1]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Humidity:']/..")));
        String temp=driver.findElement(By.xpath("//span[text()='Humidity:']/..")).getText();
        String humidityFromWeb=temp.split("\n")[1].replace("%","");
        System.out.println("Humidity - Web:  "+humidityFromWeb);
        //Test may fail because Weather might change
        Assert.assertEquals(humidityFromWeb,humidityFromAPI);


    }


}

