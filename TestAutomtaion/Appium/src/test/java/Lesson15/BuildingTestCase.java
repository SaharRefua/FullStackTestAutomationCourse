package Lesson15;//package <set your test package>;import com.google.common.util.concurrent.Uninterruptibles;import io.appium.java_client.MobileElement;import io.appium.java_client.TouchAction;import io.appium.java_client.android.Activity;import io.appium.java_client.remote.AndroidMobileCapabilityType;import io.appium.java_client.android.AndroidDriver;import io.appium.java_client.android.AndroidElement;import io.appium.java_client.remote.MobileCapabilityType;import io.appium.java_client.touch.LongPressOptions;import io.appium.java_client.touch.offset.ElementOption;import org.openqa.selenium.By;import org.openqa.selenium.remote.DesiredCapabilities;import org.testng.Assert;import org.testng.annotations.*;import java.net.URL;import java.net.MalformedURLException;import java.time.Duration;import java.util.concurrent.TimeUnit;import java.util.logging.Level;public class BuildingTestCase {    private String reportDirectory = "/Users/sahar.refua/saharR/FullStackTestAutomationCourse/TestAutomtaion/FinalProject/AppiumStudioReports/";    private String reportFormat = "xml";    private String testName = "AppiumStudioTest.html";    protected AndroidDriver<AndroidElement> driver = null;    TouchAction action;    DesiredCapabilities dc = new DesiredCapabilities();    @BeforeMethod    public void setUp() throws MalformedURLException {        dc.setCapability("reportDirectory", reportDirectory);        dc.setCapability("reportFormat", reportFormat);        dc.setCapability("testName", testName);        dc.setCapability(MobileCapabilityType.UDID, "ce06171675fb030102");        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.apis");        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        action = new TouchAction(driver);    }    @Test    public void test1() {        driver.executeScript("seetest:client.verifyElementFound(\"NATIVE\", \"//*[@text='Views']\", 0)");//        String str = "seetest:client.verifyElementFound("NATIVE", \"//*[@text=\"Views\"],3)";//        client.verifyElementFound("NATIVE", "text=Login", 0);//        driver.executeScript(str);//        driver.executeScript("seetest:client.verifyElementFound(\"NATIVE\", \"//*[@text=\"Views\"],0)");//        driver.startActivity("com.experitest.ExperiBank", ".LoginActivity");        // Specify the package name and activity name        String appPackage = "com.experitest.ExperiBank";        String appActivity = ".LoginActivity";        // Create an Activity object        Activity activity = new Activity(appPackage, appActivity);        // Start the specified activity        driver.startActivity(activity);    }    @Test    public void test02_simpleMenu() {        //Navigate to Custom Adapter:        driver.findElement(By.xpath("//*[@contentDescription='Views']")).click();        driver.findElement(By.xpath("//*[@contentDescription='Expandable Lists']")).click();        ;        driver.findElement(By.xpath("//*[@contentDescription='1. Custom Adapter']")).click();        longPress(driver.findElement(By.xpath("//*[@text='People Names']")), 2);        //Verifications        Assert.assertEquals(driver.findElement(By.xpath("//*[@text='Sample action']")).getText(), "Sample action2");//verify by text        //Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Sample action']")).isDisplayed());//Verify is displayed    }    public void longPress(MobileElement elem, int duration) {        action.longPress(new LongPressOptions()                        .withElement(ElementOption.element(elem))                        .withDuration(Duration.ofSeconds(duration)))                .perform();    }    @AfterMethod    public void tearDown() {        driver.quit();    }}