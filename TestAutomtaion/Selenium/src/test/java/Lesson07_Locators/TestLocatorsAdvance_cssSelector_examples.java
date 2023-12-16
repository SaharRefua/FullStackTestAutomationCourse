package Lesson07_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLocatorsAdvance_cssSelector_examples {
    WebDriver driver;


    @Test
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://best.aliexpress.com/");
    }

    @Test
    public void test01_findElements() {
        // Select by Tag Name:
        WebElement element1 = driver.findElement(By.cssSelector("div"));

        // Select by ID:
        WebElement element2 = driver.findElement(By.cssSelector("#example-id"));

        //Select by Class Name:
        WebElement element = driver.findElement(By.cssSelector(".example-class"));
        //Select by Attribute:
        //Select an input element with a specific attribute and value
        WebElement element4 = driver.findElement(By.cssSelector("input[name='username']"));

        //Select by Attribute Presence:
        //Select an element with a specific attribute regardless of its value
        WebElement element5 = driver.findElement(By.cssSelector("[data-example]"));
        //Select by Attribute Starts With:
        //Select an element with an attribute that starts with a specific value
        WebElement element6 = driver.findElement(By.cssSelector("[class^='prefix']"));
        //Select by Attribute Ends With:
        //Select an element with an attribute that ends with a specific value
        WebElement element7 = driver.findElement(By.cssSelector("[class$='suffix']"));

        //Select by Attribute Contains:
        //Select an element with an attribute that contains a specific value
        WebElement element8 = driver.findElement(By.cssSelector("[class*='substring']"));


        //Select by Child Combinator:
        // Select direct children of an element
        WebElement element9 = driver.findElement(By.cssSelector("ul > li"));

        //Select by Descendant Combinator:
        // Select descendants of an element (children, grandchildren, etc.)
        WebElement element10 = driver.findElement(By.cssSelector("div span"));
    }

    @Test
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
