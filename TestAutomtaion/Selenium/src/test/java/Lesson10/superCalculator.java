package Lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class superCalculator {

    WebDriver driver;

    @Test
    @BeforeClass
    public void beforeClass() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://juliemr.github.io/protractor-demo/");

    }

    @Test
    public void test01_createSuperCal() {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement operator = driver.findElement(By.xpath("//select[@ng-model='operator']"));
            Select select = new Select(operator);
            select.selectByVisibleText("*");
            WebElement goButton = driver.findElement(By.id("gobutton"));
            WebElement firstNumber = driver.findElement(By.xpath("//input[@ng-model='first']"));
            WebElement secondNumber = driver.findElement(By.xpath("//input[@ng-model='second']"));
            WebElement result = driver.findElement(By.xpath("//h2[@class='ng-binding']"));

            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    firstNumber.sendKeys(Integer.toString(i));
                    secondNumber.sendKeys(Integer.toString(j));
                    goButton.click();
                    Thread.sleep(5000);
                    System.out.println("Results for " + i + " * " + j + " = " + result.getText());
                    assertEquals(result.getText(), Integer.toString(i * j));
                }
            }


        } catch (Exception e) {
            System.out.println("Test Failed");
            fail("Test Failed");
        }
    }


    @Test
    @AfterClass
    public void afterClass() {

        driver.quit();

    }

}
