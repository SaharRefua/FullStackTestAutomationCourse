package Lesson07;

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
//    @Test
//    public void test01VerifyLogo(){
//        WebElement way1=driver.findElement(By.className("navbar-brand"));
//        WebElement way2=driver.findElement(By.className("navbar-logo"));
//        WebElement way3=driver.findElement(By.id("Layer_1"));
//        WebElement way4=driver.findElement(By.tagName("svg"));
//        System.out.println("Way1: "+way1);
//        System.out.println("Way2: "+way2);
//        System.out.println("Way3: "+way3);
//        System.out.println("Way4: "+way4);
//    }
//    @Test
//    public void test02VerifyTotalLinks(){
//        List<WebElement> links= driver.findElements(By.tagName("a"));
//        System.out.println("Total Links: "+links.size());
//    }
//    @Test
//    public void test03VerifyLinksWithSeleniumUpper(){
//        List<WebElement> linksWithSeleniumUpper=driver.findElements(By.partialLinkText("Selenium"));
//        System.out.println("Total Links with - [Selenium] : "+linksWithSeleniumUpper.size());
//    }
//
//    @Test
//    public void test04VerifyLinksWithSeleniumLower(){
//        List<WebElement> linksWithSeleniumLower=driver.findElements(By.partialLinkText("selenium"));
//        System.out.println("Total Links with - [selenium] : "+linksWithSeleniumLower.size());
//    }
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
