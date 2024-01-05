package Lesson13;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class pageObjectPatternsEx {
    WebDriver driver;
    loginPage login;
    formPage form;
    lastPage last;

    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/webdriveradvance.html");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        login = PageFactory.initElements(driver, loginPage.class);
        form = PageFactory.initElements(driver, formPage.class);
        last = PageFactory.initElements(driver, lastPage.class);
    }
    @AfterClass
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test
    public void test01() {
        login.loginForm("selenium", "webdriver");
        form.fillForm("qa", "30", "Tel Aviv");
        Assert.assertTrue(last.btn_clickMe.isDisplayed());

    }



}
