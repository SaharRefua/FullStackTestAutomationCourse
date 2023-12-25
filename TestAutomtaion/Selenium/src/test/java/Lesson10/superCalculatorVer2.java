package Lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class superCalculatorVer2 {

    WebDriver driver;
    int sum = 0;
    private WebDriverWait wait;

    @Test
    @BeforeClass
    public void beforeClass() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.random.org/");
        driver.manage().window().maximize();


    }

    @Test
    public void test01_createSuperCal() {
        try {
            int randomNumber=8;
//            WebElement iFrame = driver.findElement(By.tagName("iframe"));
//            driver.switchTo().frame(iFrame);
//            WebElement maxNumber = iFrame.findElement(By.id("#apon-max"));
//            maxNumber.clear();
//            maxNumber.sendKeys("10");
//
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value=\"Generate\"]")));
//            driver.findElement(By.xpath("//input[@value=\"Generate\"]")).click();
//            int randomNumber = Integer.parseInt(driver.findElement(By.xpath("//center/span[@style=\"font-size:100%;font-weight:bold;\"]")).getText());
            driver.get("https://juliemr.github.io/protractor-demo/");

            WebElement operator = driver.findElement(By.xpath("//select[@ng-model='operator']"));
            Select select = new Select(operator);
            select.selectByVisibleText("*");
            WebElement goButton = driver.findElement(By.id("gobutton"));
            WebElement firstNumber = driver.findElement(By.xpath("//input[@ng-model='first']"));
            WebElement secondNumber = driver.findElement(By.xpath("//input[@ng-model='second']"));
            WebElement result = driver.findElement(By.xpath("//h2[@class='ng-binding']"));


                for (int j = randomNumber; j > 0; j--) {
                    firstNumber.sendKeys(Integer.toString(randomNumber));
                    secondNumber.sendKeys(Integer.toString(j));
                    goButton.click();
                    Thread.sleep(5000);
                    sum = sum + (randomNumber * j);

                    assertEquals(result.getText(), Integer.toString(randomNumber * j));
                }
            System.out.println("Results for " + sum);


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
