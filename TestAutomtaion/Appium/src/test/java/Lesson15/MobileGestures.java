package Lesson15;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class MobileGestures {
    private int index = 5;
    protected AndroidDriver<AndroidElement> driver = null;
    TouchAction action;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeClass
    public void setUp() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "ce06171675fb030102");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.apis");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        action = new TouchAction(driver);
    }

    @Test
    public void test01_changeTime() {

        //Navigate to Clock:
        driver.findElement(By.xpath("//*[@contentDescription='Views']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='Date Widgets']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='2. Inline']")).click();
        //Drag From 12 to 9:
        AndroidElement startHours = driver.findElement(By.xpath("//*[@contentDescription='12']"));
        AndroidElement finishHours = driver.findElement(By.xpath("//*[@contentDescription='9']"));
        dragAndDrop(startHours, finishHours);
        //Drag From 15 to 45:
        AndroidElement startMinutes = driver.findElement(By.xpath("//*[@contentDescription='15']"));
        AndroidElement finishMinutes = driver.findElement(By.xpath("//*[@contentDescription='45']"));
        dragAndDrop(startMinutes, finishMinutes);
        //Verify Results:
        String resultHours = driver.findElement(By.xpath("//*[@id='hours']")).getText();
        String resultSeprator = driver.findElement(By.xpath("//*[@id='separator']")).getText();
        String resultMinutes = driver.findElement(By.xpath("//*[@id='minutes']")).getText();
        String actualTime = resultHours + resultSeprator + resultMinutes;
        String expectedTime = "09:45";
        System.out.println(actualTime);
        Assert.assertEquals(actualTime, expectedTime);
    }

    @Test
    public void test02_simpleMenu() {
        //Navigate to Custom Adapter:
        driver.findElement(By.xpath("//*[@contentDescription='Views']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='Expandable Lists']")).click();
        driver.findElement(By.xpath("//*[@contentDescription='1. Custom Adapter']")).click();
        longPress(driver.findElement(By.xpath("//*[@text='People Names']")), 2);
        //Verifications
        Assert.assertEquals(driver.findElement(By.xpath("//*[@text='Sample action']")).getText(), "Sample action");//verify by text
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Sample action']")).isDisplayed());//Verify is displayed
    }

    @Test(enabled = false)
    public void test03_SearchForWebView() {
        driver.findElement(By.xpath("//*[@text='Views']")).click();
        List<AndroidElement> options = driver.findElements(By.xpath("//*[@id='text1']"));
        while (index < 20) {
            try {
                if (driver.findElement(By.xpath("//*[@text='WebView']")).isDisplayed()) {
                    break;
                } else {
                    dragAndDrop(options.get(index), options.get(index + 4));
                    index += 4;
                    Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
                }

            } catch (Exception e) {

                Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
            }


        }
    }


    public void dragAndDrop(MobileElement start, MobileElement finish) {
        action.press(new ElementOption()
                        .withElement(start))
                .moveTo(new ElementOption().withElement(finish))
                .release()
                .perform();
    }


    public void longPress(MobileElement elem, int duration) {
        action.longPress(new LongPressOptions()
                        .withElement(ElementOption.element(elem))
                        .withDuration(Duration.ofSeconds(duration)))
                .perform();
    }

    @AfterMethod
    public void reset() {
        driver.resetApp();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}