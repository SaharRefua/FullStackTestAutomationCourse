package Lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class DifferentBrowsers {

    @Test
    public void test01_chrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.chrome.com");
        System.out.println("Chrome Title is: " + driver.getTitle());
        driver.quit();
    }
    @Test
    public void test02_fireFox() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.firefox.com");
        System.out.println("FireFox Title is: " + driver.getTitle());
        driver.quit();
    }

    @Test
    public void test03_Safari() {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();
        driver.get("https://www.safari.com");
        System.out.println("Safari Title is: " + driver.getTitle());
        driver.quit();
    }

    @Test
    public void test04_Edge() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.edge.com");
        System.out.println("Edge Title is: " + driver.getTitle());
        driver.quit();
    }
}
