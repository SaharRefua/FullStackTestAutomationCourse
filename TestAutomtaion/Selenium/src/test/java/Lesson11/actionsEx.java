package Lesson11;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class actionsEx {

    WebDriver driver;
    SoftAssert soft;

    @BeforeClass
    public void startSession() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_actions.html");
        soft = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test(description = "Drag and drop test")
    @Description("Drag and drop test")
    public void dragAndDrop() {
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggable, droppable).build().perform();
        String actual = driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]")).getText();
        assertEquals(actual, "Dropped!");
    }

    @Test(description = "Select Multiple Options test")
    @Description("Select Multiple Options")
    public void selectMultipleOptions() {
        Actions actions = new Actions(driver);
        List<WebElement> items = driver.findElements(By.className("ui-selectee"));
        actions.clickAndHold(items.get(1)).clickAndHold(items.get(2)).click().build().perform();
        soft.assertTrue(items.get(1).getAttribute("class").contains("ui-selected"));
        soft.assertTrue(items.get(2).getAttribute("class").contains("ui-selected"));
        soft.assertAll();

    }
    @Test(description = "Double Click test")
    @Description("Double Click")
    public void doubleClick() {
        Actions actions = new Actions(driver);
        WebElement dClick = driver.findElement(By.id("dbl_click"));
        actions.doubleClick(dClick).build().perform();
        String helloWorld = driver.findElement(By.id("demo")).getText();
        assertEquals(helloWorld, "Hello World");
    }
    @Test(description = "Mouse Hover test")
    @Description("Mouse Hover")
    public void mouseHover() {
        Actions actions = new Actions(driver);
        WebElement mousePointer = driver.findElement(By.id("mouse_hover"));
        actions.moveToElement(mousePointer).click().perform();
        String style = mousePointer.getAttribute("style");
        assertEquals(style, "background-color: rgb(255, 255, 0);");
    }
    @Test(description = "Scroll down test")
    @Description("Scroll down")
    public void scrollDown() {
        Actions actions = new Actions(driver);
        WebElement scrolledElement = driver.findElement(By.id("scrolled_element"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scrolledElement);
        assertTrue(scrolledElement.isDisplayed());

    }
}
