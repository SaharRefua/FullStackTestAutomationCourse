package Lesson07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLocatorsAdvance_part1 {
    WebDriver driver;


    @Test
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_locators.html");

    }
    @Test
    public void test01_findElements() {
        WebElement locator1 = driver.findElement(By.id("locator_id"));
        WebElement locator2 = driver.findElement(By.name("locator_name"));
        WebElement locator3 = driver.findElement(By.xpath("//*[@id=\"contact_info_left\"]/p"));
        WebElement locator4 = driver.findElement(By.className("locator_class"));
        WebElement locator5 = driver.findElement(By.linkText("myLocator(5)"));
        WebElement locator6 = driver.findElement(By.partialLinkText("locator (6)"));
        WebElement locator7 = driver.findElement(By.cssSelector("input[value='Find my locator (7)']"));
        WebElement locator8 = driver.findElement(By.tagName("button"));

        System.out.println(locator1.getText());
        System.out.println(locator2.getText());
        System.out.println(locator3.getText());
        System.out.println(locator4.getText());
        System.out.println(locator5.getText());
        System.out.println(locator6.getText());
        System.out.println(locator7.getText());
        System.out.println(locator8.getText());
    }
    @Test
    @AfterClass
    public void afterClass() {

        driver.quit();

    }

}
