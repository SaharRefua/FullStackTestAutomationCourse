package Lesson13;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(AutomationListeners.class)
public class ScreenRecorderTest {
    private WebDriver driver;

    @BeforeClass
    public void open_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_controllers.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        try {
            MonteScreenRecorder.startRecord(method.getName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01() {
        driver.navigate().refresh();
        driver.findElement(By.name("firstname")).sendKeys("Yoni");
        driver.findElement(By.name("lastname")).sendKeys("Flenner");
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("exp-3")).click();
        // ------------------- Date picker -----------------
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click(); // go to next month
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
        for (WebElement cell: columns) {
            if (cell.getText().equals("13")) {
                cell.click();
                break;
            }
        }
        // ------------------------------------------------------

        driver.findElement(By.id("profession-1")).click();
        driver.findElement(By.id("tool-2")).click();
        Select mySelection = new Select(driver.findElement(By.id("continents")));
        mySelection.selectByVisibleText("Europe");
        Select mySelection2 = new Select(driver.findElement(By.id("selenium_commands")));
        mySelection2.selectByIndex(2);
        driver.findElement(By.id("photo")).sendKeys("C:/Windows/win.ini"); // upload file

        // Initially failing the test, id should be: submit
        driver.findElement(By.id("kuku")).click();
    }

//    No Need this Method while working with Event Listeners
//    @AfterMethod()
//    public void afterMethod() {
//        try {
//            MonteScreenRecorder.java.stopRecord();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

