package Lesson09;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Synchronization {
    WebDriver driver;


    @Test
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_synchronization.html");

    }
    @Test
    @AfterClass
    public void afterClass() {
        driver.quit();

    }
    @Test
    public void test01_startRenderedButton() {
        driver.findElement(By.id("rendered")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div[@id='finish2']/h4"), "My Rendered Element After Fact!"));

    }
    @Test
    public void test02_startHiddenButton() throws InterruptedException {
        driver.findElement(By.id("hidden")).click();
        Thread.sleep(5000);
        WebElement loading1Element = driver.findElement(By.id("loading1"));
        Assert.assertEquals(loading1Element.isEnabled(), true);
    }

    @Test
    public void test03_removeButton() {
        driver.findElement(By.id("btn")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement loading1Element = driver.findElement(By.id("message"));
        Assert.assertEquals(loading1Element.getText(), "It's gone!");
    }

    // Thread.sleep(1000);
    // driver.get("https://www.google.com/");
    // Sets the actual time to wait for a page to load completely before throwing an error. is set for the life of the WebDriver object instance.
    // driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    // Sets the amount of time to wait for an elements to be found when looking for an element. is set for the life of the WebDriver object instance.
    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    // Sets the amount of time to wait for a script to finish execution before throwing an error. is set for the life of the WebDriver object instance.
    // WebDriverWait wait = new WebDriverWait(driver, 10);
    // wait.until(ExpectedConditions.urlToBe("https://www.google.com/"));
    // wait.until(ExpectedConditions.urlContains("google"));
    // wait.until(ExpectedConditions.titleContains("Google"));
    // wait.until(driver.getCurrentUrl().equals("https://www.google.com/"));



}
