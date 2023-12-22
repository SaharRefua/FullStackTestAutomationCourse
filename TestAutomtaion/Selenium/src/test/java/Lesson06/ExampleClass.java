package Lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ExampleClass {
    @Test
    @AfterClass
    public void afterClass() {
        System.out.println("After Class");

    }

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("UTL is: " + driver.getCurrentUrl());
        System.out.println("Title is: " + driver.getTitle());
        driver.quit();

    }
}
