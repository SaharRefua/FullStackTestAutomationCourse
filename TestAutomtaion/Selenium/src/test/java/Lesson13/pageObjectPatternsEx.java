package Lesson13;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class pageObjectPatternsEx {
    WebDriver driver;
    loginPage login;
    formPage form;
    lastPage last;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        MonteScreenRecorder.startRecord("beforeMethod");
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        MonteScreenRecorder.stopRecord();
    }

    @BeforeClass
    public void startSession() throws Exception {
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
    public void closeSession() throws Exception {
        Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
        driver.quit();

    }

    @Test
    public void test01() {
        login.loginForm("selenium", "webdriver");
        form.fillForm("qa", "30", "Tel Aviv");
        Assert.assertTrue(last.btn_clickMe.isDisplayed());

    }

    @Test
    public void test02() {
        login.loginForm("seleniu", "webdriver");
        form.fillForm("", "30", "Tel Aviv");
        Assert.assertTrue(last.btn_clickMe.isDisplayed());

    }


}
