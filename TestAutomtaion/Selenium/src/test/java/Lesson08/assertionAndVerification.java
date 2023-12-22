package Lesson08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class assertionAndVerification {
    WebDriver driver;


    @Test
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");

    }

    @Test
    public void test01_CalBMI() {
        try {
            WebElement weight = driver.findElement(By.id("weight"));
            weight.sendKeys("70");
            WebElement hight = driver.findElement(By.id("hight"));
            hight.sendKeys("175");
            WebElement calBMI = driver.findElement(By.id("calculate_data"));
            calBMI.click();
            WebElement bmi = driver.findElement(By.id("bmi_result"));
            assertEquals(bmi.getAttribute("value"), "23");
        } catch (Exception e) {
            System.out.println("Test Failed");
            fail("Test Failed");
        }
    }

    @Test
    public void test02_CalBMIButton() {
        try {
            WebElement calBMI = driver.findElement(By.id("calculate_data"));
            System.out.println("Button - Height:"+calBMI.getSize().getHeight());
            System.out.println("Button - Width:"+calBMI.getSize().getWidth());
            System.out.println("Button - X Coordinate:"+calBMI.getLocation().getX());
            System.out.println("Button - Y Coordinate:"+calBMI.getLocation().getY());
            assertTrue(calBMI.isDisplayed());
            assertTrue(calBMI.isEnabled());
            assertFalse(calBMI.isSelected());
            assertEquals(calBMI.getTagName(), "input");
            assertEquals(calBMI.getAttribute("value"), "Calculate BMI");
            WebElement warning = driver.findElement(By.id("new_input"));
            assertFalse(warning.isDisplayed());
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
