package Lesson11;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class allure {

    final String myWeight = "90";
    final String myHeight = "190";
    final String expectedBmi = "32+kuku";
    WebDriver driver;
    SoftAssert soft;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");
        soft = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test(description = "Verify BMI result")
    @Description("Verify BMI result")
    public void test01VerifyBmiResult() {
        try {
            enterWeightAndHeight(myWeight, myHeight);
            verifyCalBMI();
        } catch (AssertionError e) {
            System.out.println("Test Failed");
            takeScreenshot();
            fail("Test Failed");
        }
    }

    @Step("Enter weight and height")
    public void enterWeightAndHeight(String weight, String height) {
        driver.findElement(By.id("weight")).sendKeys(weight);
        driver.findElement(By.id("hight")).sendKeys(height);
        driver.findElement(By.id("calculate_data")).click();
    }

    @Step("Verify Calculated BMI")
    public void verifyCalBMI() {
        String actualBmi = driver.findElement(By.id("bmi_result")).getAttribute("value");
        Assert.assertEquals(actualBmi, expectedBmi);
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
}
