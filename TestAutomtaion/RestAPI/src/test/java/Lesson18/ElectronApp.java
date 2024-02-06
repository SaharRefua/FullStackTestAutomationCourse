package Lesson18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;


public class ElectronApp {
    public WebDriver driver;
    public ChromeOptions opt;
    public DesiredCapabilities capabilities;

    @BeforeClass
    public void startSession(){
        System.setProperty("webdriver.chrome.driver","C:/Automation/electrondriver-v3.1.2-win32-x64/electrondriver.exe");
        opt = new ChromeOptions();
        opt.setBinary("C:/Automation/Electron API Demos-win32-ia32/Electron API Demos.exe");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("chromeOptions",opt);
        capabilities.setBrowserName("chrome");
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void test01(){
        driver.findElement(By.id("button-app-sys-information")).click();
        driver.findElement(By.id("button-menus")).click();
        driver.findElement(By.id("button-crash-hang")).click();
        driver.findElement(By.id("new-window-demo-toggle")).click();
        String viewDemo_btn = driver.findElement(By.id("new-window")).getAttribute("value");
        assertEquals("View Demo",viewDemo_btn);

    }

    @AfterClass
    public void endSession(){
        driver.quit();

    }
}
