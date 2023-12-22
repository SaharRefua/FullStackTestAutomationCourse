package Lesson08;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class    BmiEx {
    final String myWeight="90";
    final String myHeight="190";
    final String expectedBmi="25";
    WebDriver driver;
    SoftAssert soft;
    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");
        soft=new SoftAssert();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }
    @AfterClass
    public void closeSession(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test
    public void test01VerifyBmiResult(){
        driver.findElement(By.id("weight")).sendKeys(myWeight);
        driver.findElement(By.id("hight")).sendKeys(myHeight);
        driver.findElement(By.id("calculate_data")).click();
        String actualBmi=driver.findElement(By.id("bmi_result")).getAttribute("value");
        Assert.assertEquals(actualBmi,expectedBmi);
    }

    @Test
    public void test02VerifyCalculateButton(){
        driver.navigate().refresh();
        WebElement calculateButton=driver.findElement(By.id("calculate_data"));
        System.out.println("Button - Height:"+calculateButton.getSize().getHeight());
        System.out.println("Button - Width:"+calculateButton.getSize().getWidth());
        System.out.println("Button - X Coordinate:"+calculateButton.getLocation().getX());
        System.out.println("Button - Y Coordinate:"+calculateButton.getLocation().getY());
        soft.assertTrue(calculateButton.isEnabled());
        soft.assertTrue(calculateButton.isDisplayed());
        soft.assertFalse(calculateButton.isSelected());
        soft.assertEquals(calculateButton.getTagName(),"input");
        soft.assertEquals(calculateButton.getAttribute("value"),"Calculate BMI");
        soft.assertFalse(driver.findElement(By.id("new_input")).isDisplayed());
        soft.assertAll();
    }



}
