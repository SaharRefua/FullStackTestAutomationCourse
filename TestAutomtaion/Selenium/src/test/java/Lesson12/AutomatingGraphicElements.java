package Lesson12;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class AutomatingGraphicElements {
    private String path = "/Users/sahar.refua/saharR/FullStackTestAutomationCourse/TestAutomtaion/Selenium/src/test/java/Lesson12/images/";
    private WebDriver driver;
    private Screen screen;

    @BeforeClass
    public void StartSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/maps");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        screen = new Screen();
    }
    @AfterClass
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
        driver.quit();
    }
    @Test
    public void googleMaps() throws FindFailed {
        screen.click(path + "zoomOut.png");
        screen.click(path + "zoomOut.png");

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        screen.type(path + "searchField.png", "London, UK");
        screen.click(path + "searchButton.png");
        screen.wait(path + "zoomIn.png", 5);
        screen.click(path + "zoomIn.png");
        screen.click(path + "zoomIn.png");
        screen.click(path + "zoomIn.png");
        screen.click(path + "zoomIn.png");
        screen.wait(path + "hotelLondon.png", 5);
        screen.find(path + "hotelLondon.png");

    }



}
