package Lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverObjectMethodsPart2 {
    private WebDriver driver;
    private final String expectedTitleName = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
    private final String expectedUrlAddress = "https://www.imdb.com/";

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
    }

    @Test
    public void test01_goToBing() {
        driver.get("https://www.bing.com");
        driver.navigate().back();
        String title = driver.getTitle();

        System.out.println("Title is: " + title);
        String pageSource = driver.getPageSource();
        if (pageSource.contains("buble")){
            System.out.println("Exists");
        } else {
            System.out.println("Not Exist");
        }
    }
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
