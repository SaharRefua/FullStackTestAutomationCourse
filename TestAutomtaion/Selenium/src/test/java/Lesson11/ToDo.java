package Lesson11;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
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

public class ToDo {


    WebDriver driver;
    SoftAssert soft;
    Actions actions;
    @BeforeClass
    public void startSession() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://todomvc.com/examples/react");
        soft = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        actions = new Actions(driver);

    }

    @AfterClass
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test(priority = 1)
    public void createNewToDo() {

        WebElement newToDO = driver.findElement(By.className("new-todo"));
        newToDO.sendKeys("Complete Appium course");
        newToDO.sendKeys(Keys.RETURN);
        List<WebElement> todos = driver.findElements(By.xpath("//div/label"));
        assertEquals(todos.get(0).getText(), "Complete Appium course");
    }
    @Test(priority = 2)
    public void deleteNewToDo() {
//        WebElement newToDO = driver.findElement(By.className("new-todo"));
//        newToDO.sendKeys("Complete Java course");
//        newToDO.sendKeys(Keys.RETURN);
        WebElement select = driver.findElement(By.xpath("//input[@class='toggle']"));
        actions.moveToElement(select).click().perform();
        WebElement delete = driver.findElement(By.xpath("//button[@class='destroy']"));
        delete.click();
        List <WebElement> todos = driver.findElements(By.xpath("//ul/li/div/label"));
        assertEquals(todos.size(), 0);
    }
    @Test(priority = 3)
    public void completeNewToDo() {
        WebElement newToDO = driver.findElement(By.className("new-todo"));
        newToDO.sendKeys("Complete selenium course");
        newToDO.sendKeys(Keys.RETURN);
        WebElement select = driver.findElement(By.xpath("//input[@class='toggle']"));
        select.click();
        List <WebElement> todos = driver.findElements(By.xpath("//section/ul/li"));
        assertEquals(todos.get(0).getAttribute("class"), "completed");
    }

    @Test(priority = 4)
    public void editNewToDo() {
        WebElement newToDO = driver.findElement(By.className("new-todo"));
        newToDO.sendKeys("Buy New Books");
        newToDO.sendKeys(Keys.RETURN);

        List <WebElement> select = driver.findElements(By.xpath("//li/div/label"));
        actions.doubleClick(select.get(1)).build().perform();
//        select.get(1).clear();
        select.get(1).sendKeys("Buy cookies");
        select.get(1).sendKeys(Keys.RETURN);
        List <WebElement> todos = driver.findElements(By.xpath("//li/div/label"));
        assertEquals(todos.size(), 2);
    }
}
//footer/ul/li/a

