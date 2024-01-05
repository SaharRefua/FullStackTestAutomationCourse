package Lesson12;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class wooloversEx {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void StartSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wooloverslondon.com/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(8, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test
    public void shopping() throws InterruptedException {
        WebElement acceptAndProceed = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptAndProceed.click();
        WebElement continueShopping = driver.findElement(By.xpath("//div[@class='glPopupContent']/div/div[@class='glControls']/input"));
        continueShopping.click();
        List<WebElement> sections = driver.findElements(By.cssSelector("a.font-weight-bold"));
        sections.get(0).click();
        WebElement flag = driver.findElement(By.xpath("//li[@class='nav-dropdown-container country-selection country-selection--rest-of-world']/span/img"));
        flag.click();
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        WebElement popup = driver.findElement(By.cssSelector("div#globale_csc_popup"));
        Assert.assertTrue(popup.isDisplayed());
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        WebElement Currency = driver.findElement(By.id("gle_selectedCurrency"));
        Select selectCurrency = new Select(Currency);
        selectCurrency.selectByVisibleText("US Dollar");
        WebElement save = driver.findElement(By.xpath("//input[@class='glDefaultBtn glCancelBtn']"));
        save.click();
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        WebElement gender = driver.findElement(By.id("dd-Gender"));
        gender.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Male']")));
        driver.findElement(By.xpath("//span[text()='Male']")).click();
        driver.findElement(By.xpath("//span[text()='Female']")).click();
        driver.findElements(By.className("js-toggle-close-all")).get(0).click();
        WebElement sortBy = driver.findElement(By.xpath("//div/button[@id='dd-Sort By']"));
        sortBy.click();
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//span[text()='Most Relevant']")).click();
        driver.findElement(By.xpath("//span[text()='Price Low to High']")).click();
        driver.findElement(By.xpath("//div[text()='Done']")).click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        WebElement products = driver.findElement(By.id("listing-container"));
        List<WebElement> items = products.findElements(By.tagName("p"));
        for (WebElement item : items) {
            if (item.getText().contains("$")) {
                double actualPrice = Double.parseDouble(item.getText().substring(2));
                System.out.println(actualPrice);
                Assert.assertTrue(actualPrice < 150,
                        "Price of One or More of the Items is More than Expected!");
            }
        }


    }
}
