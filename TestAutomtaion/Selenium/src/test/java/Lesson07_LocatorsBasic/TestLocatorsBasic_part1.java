package Lesson07_LocatorsBasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestLocatorsBasic_part1 {
    WebDriver driver;

    @Test
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev");

    }

    @Test
    public void test01_findElementByID() {

        WebElement id = driver.findElement(By.id("selenium_webdriver"));
        System.out.println("ID: " + id);

    }

    @Test
    public void test01_findElementByTagName() {

        List<WebElement> tagName = driver.findElements(By.tagName("svg"));
        System.out.println("tagName: " + tagName.get(0));

    }


    @Test
    public void test02_findEAllLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("The number of links in website: " + links.size());

    }

    @Test
    public void test03_findEAllLinksWithSelenium() {
        List<WebElement> links = driver.findElements(By.partialLinkText("Selenium"));
        System.out.println("The number of links With Selenium: " + links.size());

    }
    @Test
    public void test04_findEAllLinksWithselenium() {
        List<WebElement> links = driver.findElements(By.partialLinkText("selenium"));
        System.out.println("The number of links With selenium: " + links.size());

    }


    @Test
    @AfterClass
    public void afterClass() {
        driver.quit();

    }


}
