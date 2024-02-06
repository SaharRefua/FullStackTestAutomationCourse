package Lesson18;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class AngularJS {
    WebDriver driver;
    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rupp.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
        driver.quit();
    }
    @Test
    public void test01(){
        String title = driver.findElement(By.xpath("//h1")).getAttribute("value");
        assertEquals("It Finally Happened!", title);
        System.out.println(title);
        // ngWebDriver no update fast as AngularJS framework, so we will not use it !!!!!!!!!!!!
    }

}
