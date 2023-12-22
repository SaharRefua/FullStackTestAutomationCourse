package Lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class WebDriverObjectMethodsPart1 {
    private WebDriver driver;
    private final String expectedTitleName = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
    private final String expectedUrlAddress = "https://www.imdb.com/";

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://imdb.com");
    }

    @Test
    public void test01_imdb() {
        driver.navigate().refresh();
        driver.get("https://www.imdb.com");
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println("URL is: " + url);
        System.out.println("Title is: " + title);
        if(url.contains(expectedUrlAddress) ) {
            System.out.println("URL Test Passed");
        } else {
            System.out.println("URL Test Failed");
        }
        if(title.equals(expectedTitleName)) {
            System.out.println("Title Test Passed");
        } else {
            System.out.println("Title Test Failed");
        }
    }
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
