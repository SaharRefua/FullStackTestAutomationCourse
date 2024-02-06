package Lesson18;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class CalcuApp {
    public WindowsDriver driver;
    public DesiredCapabilities capabilities;

    String calApp= "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";
    String paintApp= "C:/Windows/System32/mspaint.exe";
    @BeforeClass
    public void Setup() throws MalformedURLException {

        capabilities = new DesiredCapabilities();
        capabilities.setCapability("app",calApp);
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"),capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void test01(){
        driver.findElement(By.name("One")).click();
        driver.findElement(By.name("Plus")).click();
        driver.findElement(By.name("Two")).click();
        driver.findElement(By.name("Equals")).click();
        String results = driver.findElement(By.xpath("//*[@AutomationId='CalculatorResults']")).getText();
        String resultsValue = results.replace("Display is ","");
        System.out.println(resultsValue);
        assertEquals(resultsValue,"3");

    }

    @AfterClass
    public void endSession(){
        driver.quit();

    }
}
