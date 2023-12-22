package Lesson07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class TestLocatorsAdvance_Xpath_examples {

        public static void main(String[] args) {
            // Set the path to the GeckoDriver executable
            WebDriverManager.firefoxdriver().setup();

            // Create a new instance of the Firefox driver
            WebDriver driver = new FirefoxDriver();

            // Navigate to a web page
            driver.get("https://example.com");

            // Using CSS selector to locate an element by class name
            WebElement cssElement = driver.findElement(By.cssSelector(".example-class"));
            cssElement.click();

            // Using XPath to locate an element by absolute path
            WebElement xpathElement1 = driver.findElement(By.xpath("/html/body/div[1]/p[2]"));
            // Using XPath to locate an element by relative path with attributes
            WebElement xpathElement2 = driver.findElement(By.xpath("//div[@id='example']/p[@class='example-class']"));

            // Using XPath to locate an input element with a specific attribute and value
            WebElement xpathElement3 = driver.findElement(By.xpath("//input[@name='username']"));

            // Using XPath to locate a button with specific attribute and text content
            WebElement xpathElement4 = driver.findElement(By.xpath("//button[@id='submit' and text()='Submit']"));

            // Using XPath to locate an element with attribute containing a specific value
            WebElement xpathElement5 = driver.findElement(By.xpath("//div[contains(@class, 'example')]"));

            // Using XPath to locate an input element with attribute starting with a specific value
            WebElement xpathElement6 = driver.findElement(By.xpath("//input[starts-with(@id, 'username')]"));

            // Using XPath to locate an element with multiple conditions using OR
            WebElement xpathElement7 = driver.findElement(By.xpath("//input[@type='text' or @type='email']"));

            // Using XPath to locate a child element based on its parent
            WebElement xpathElement8 = driver.findElement(By.xpath("//ul[@id='menu']/li[3]/a"));

            // Using XPath to locate a sibling element that follows another element
            WebElement xpathElement9 = driver.findElement(By.xpath("//div[@class='example']/following-sibling::p"));

            // Using XPath to select all child elements of a parent element
            List<WebElement> xpathElements = driver.findElements(By.xpath("//div[@id='parent']/child::*"));

            // Perform some actions on the located elements if needed

            // Close the browser window
            driver.quit();
        }
    }


