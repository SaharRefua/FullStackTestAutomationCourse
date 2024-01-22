package Lesson15;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MobileMethods {

    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeClass
    public void setUp() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "ce06171675fb030102");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.apis");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
    }

    @Test
    public void test01_verifyTotalItems() {
        List<AndroidElement> items=driver.findElements(By.id("text1"));
        Assert.assertEquals(items.size(),11);
    }
    @Test
    public void test02_printContentDetails(){
        AndroidElement contentElement=driver.findElement(By.xpath("//*[@contentDescription='Content']"));
        System.out.println("Element 'Content' Height: "+contentElement.getRect().getHeight());
        System.out.println("Element 'Content' Width: "+contentElement.getRect().getWidth());
        System.out.println("Element 'Content' X Coordinate: "+contentElement.getRect().getX());
        System.out.println("Element 'Content' Y Coordinate: "+contentElement.getRect().getY());
    }

    @Test
    public void test03_printDeviceDetails(){
        System.out.println("Application Name: "+driver.currentActivity());
        System.out.println("Device Time: "+driver.getDeviceTime());
    }


    @Test
    public void test04_verifyEriAppInstalled(){
        Assert.assertTrue(driver.isAppInstalled("com.experitest.ExperiBank"));
    }

    @Test
    public void test05_verifyOrientation(){
        if(!driver.getOrientation().equals("LANDSCAPE")){
            driver.rotate(ScreenOrientation.LANDSCAPE);
            Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
    }


    @Test
    public void test06_ScreenShots() throws IOException {
        driver.openNotifications();
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./notification.png"));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./home.png"));
    }


    @Test
    public void test07_MobileMethods() {
        if (!driver.isDeviceLocked()) {
            driver.lockDevice();
            Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        }
        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
            Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        }
        Assert.assertFalse(driver.isDeviceLocked());
    }
    @Test
    public void test08_verifyListViewCount(){
        String source=driver.getPageSource();
        int counter=0;
        String[] words=source.split(" ");
        for(String word:words){
            if(word.contains("ListView")){
                counter++;
            }
        }
        System.out.println("Counter is: "+counter);
        Assert.assertEquals(counter,4);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}