package Lesson07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestLocatorsBasic_part2 {
    WebDriver driver;


    @Test
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");

    }

    @Test
    public void test01_findElements() {
        List<WebElement> elements=new ArrayList<>();
        WebElement icon = driver.findElement(By.className("central-featured-logo"));
        elements.add(icon);
        WebElement searchField = driver.findElement(By.name("search"));
        elements.add(searchField);
        WebElement SearchLang = driver.findElement(By.id("searchLanguage"));
        elements.add(SearchLang);
        WebElement dontation = driver.findElement(By.className("footer-sidebar-text"));
        elements.add(dontation);
        for (int i = elements.size() - 1; i >= 0; i--) {
            System.out.println(elements.get(i));
        }
    }


    @Test
    @AfterClass
    public void afterClass() {

        driver.quit();

    }


}
