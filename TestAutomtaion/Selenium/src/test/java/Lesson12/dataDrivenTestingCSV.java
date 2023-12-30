package Lesson12;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class dataDrivenTestingCSV {
    WebDriver driver;
    SoftAssert soft;
    @BeforeClass
    public void startSession() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
        soft = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
        driver.quit();
    }


    @Test(dataProvider ="data-provider-csv", dataProviderClass = Utils.class)
    public void searchForData( String searchWord, String expected) {

            try{
                WebElement searchBox = driver.findElement(By.id("searchInput"));
                searchBox.sendKeys(searchWord);
                searchBox.sendKeys(Keys.ENTER);
            }
            catch (Exception e){
                WebElement searchBox = driver.findElement(By.xpath("//form/div/div/div/input"));
                searchBox.sendKeys(searchWord);
                searchBox.sendKeys(Keys.ENTER);
            }
            String actual = driver.findElement(By.className("mw-page-title-main")).getText();
            assertEquals(actual, expected);
    }


}
