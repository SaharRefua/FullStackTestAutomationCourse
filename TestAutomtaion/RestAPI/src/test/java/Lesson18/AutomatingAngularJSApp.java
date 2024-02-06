//package Lesson18;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import static org.testng.Assert.*;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.paulhammant.ngwebdriver.ByAngular;
//import com.paulhammant.ngwebdriver.NgWebDriver;
//
//public class AutomatingAngularJSApp {
//    private WebDriver driver;
//    private NgWebDriver ngWebDriver;
//
//    @BeforeClass
//    public void startSession() {
//        System.setProperty("webdriver.chrome.driver", "C://Projects/Selenium/Drivers/chromedriver.exe");
//        driver = new ChromeDriver();
//        ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
//        driver.manage().window().maximize();
//        driver.get("http://rupp.herokuapp.com/");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void BMI() throws InterruptedException {
//        ByAngular.model("asyncSelected").findElement(driver).sendKeys("john");
//        Thread.sleep(500);
//        ByAngular.repeater("match in matches").row(2).findElement(driver).click();
//        Thread.sleep(1000);
//        WebElement name = ByAngular.binding("professor.fullName").findElement(driver);
//        WebElement overall = ByAngular.binding("professor.rating.overall | number: 2").findElement(driver);
//        System.out.println(name.getText());
//        System.out.println(overall.getText());
//
//        List<WebElement> ratings = ByAngular.binding("ratingAverage").findElements(driver);
//        System.out.println(ratings.get(2).getText());
//
//        driver.findElement(By.linkText("Next")).click();
//        WebElement page2 = driver.findElement(By.cssSelector("li[class='ng-scope active']"));
//        assertEquals("2", page2.getText());
//    }
//
//    @AfterClass
//    public void endSession() {
//        driver.quit();
//    }
//}
