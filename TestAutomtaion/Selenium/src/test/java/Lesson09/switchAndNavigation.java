package Lesson09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class switchAndNavigation {
    WebDriver driver;


    @Test
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_switch_navigation.html");

    }


    @Test
    public void test01_showAlert() {
        WebElement alertButton = driver.findElement(By.id("btnAlert"));
        alertButton.click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();
        WebElement outputText = driver.findElement(By.id("output"));
        Assert.assertEquals(outputText.getText(), "Alert is gone.");
    }
    @Test
    public void test02_showPrompt() {
        String name = "Moshe";
        WebElement alertButton = driver.findElement(By.id("btnPrompt"));
        alertButton.click();
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();
        WebElement outputText = driver.findElement(By.id("output"));
        Assert.assertEquals(outputText.getText(), name);
    }

    @Test
    public void test03_iFrame() {
        WebElement iFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);
        WebElement input = driver.findElement(By.id("iframe_container"));
        System.out.println(input.getText());
        Assert.assertEquals(input.getText(), "This is an IFrame !");
    }
    @Test
    public void test04_openNewTab() {
        WebElement newTabButton = driver.findElement(By.id("btnNewTab"));
        newTabButton.click();
        String currentTab = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().equals("https://atidcollege.co.il/Xamples/ex_switch_newTab.html")) {
                WebElement outputText = driver.findElement(By.id("new_tab_container"));
                Assert.assertEquals(outputText.getText(), "This is a new tab");
                driver.close();
                driver.switchTo().window(currentTab);
                break;
            }
        }
    }
    @Test
    public void test05_openWindow() {
        WebElement newTabButton = driver.findElement(By.xpath("//div/a"));
        newTabButton.click();
        String currentWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().equals("https://atidcollege.co.il/Xamples/ex_switch_newWindow.html")) {
                WebElement outputText = driver.findElement(By.id("new_window_container"));
                Assert.assertEquals(outputText.getText(), "This is a new window");
                driver.close();
                driver.switchTo().window(currentWindow);
                break;
            }
        }
    }
    @Test
    @AfterClass
    public void afterClass() {

        driver.quit();

    }
}
