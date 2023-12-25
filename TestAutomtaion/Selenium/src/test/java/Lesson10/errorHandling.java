package Lesson10;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
@Listeners(AutomationListeners.class)
public class errorHandling {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_synchronization.html");
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test
    public void test01VerifyCheckBoxIsGoneWithTryCatch() {
        try {
            driver.findElement(By.id("btn")).click();
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
            driver.findElement(By.id("checkbox"));
            System.out.println("Test Failed! - Checkbox is still here!");
        } catch (Exception e) {
            //System.out.println(e);
            System.out.println("Test Passed! - Checkbox is gone!");
        }
    }

    @Test
    public void test02VerifyCheckBoxIsGoneNoTryCatch() {
        driver.navigate().refresh();
        driver.findElement(By.id("btn")).click();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElements(By.id("checkbox")).isEmpty());
    }

    @Test
    public void test03NoTryCatchNoListeners() {
        driver.navigate().refresh();
        driver.findElement(By.id("btn")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
    }


}
