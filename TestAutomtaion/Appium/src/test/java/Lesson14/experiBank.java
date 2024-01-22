package Lesson14;
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class experiBank {
    private String UserName = "company";
    private String Password = "company";
    protected AndroidDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "ce06171675fb030102");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void test01() {
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).click();
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='passwordTextField']")));
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        driver.findElement(By.xpath("//*[@text='Make Payment']"));
        assertTrue(driver.findElement(By.xpath("//*[@text='Make Payment']")) != null);
        driver.findElement(By.xpath("//*[@text='Logout']")).click();

    }
    @Test
    public void EribTest() throws InterruptedException {
        String myBalance;

        driver.findElement(By.id("usernameTextField")).sendKeys(UserName);
        driver.findElement(By.id("passwordTextField")).sendKeys(Password);
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("makePaymentButton")).click();
        driver.findElement(By.id("phoneTextField")).sendKeys("0541234567");
        driver.findElement(By.id("nameTextField")).sendKeys("Yoni");
        driver.findElement(By.id("amountTextField")).sendKeys("1");
        driver.findElement(By.id("countryButton")).click();
        driver.findElement(By.name("Greenland")).click();
        driver.findElement(By.id("sendPaymentButton")).click();
        driver.findElement(By.id("button1")).click();
        driver.findElement(By.id("logoutButton")).click();
        driver.findElement(By.id("usernameTextField")).sendKeys(UserName);
        driver.findElement(By.id("passwordTextField")).sendKeys(Password);
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(1000);
        myBalance = ((WebElement) driver.findElements(By.className("android.view.View")).get(0)).getAttribute("name");
        System.out.println(myBalance);

        assertEquals(myBalance,"Your balance is: 99.00$");
        driver.findElement(By.id("logoutButton")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}