package utilities;

import Lesson13.MonteScreenRecorder;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;


public class CommonOps extends Base {
    public static String getData(String tagName) {
        try {
            File inputFile = new File("../Configuration/DataConfig.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName(tagName);
            if (nodeList.getLength() > 0) {
                Node node = nodeList.item(0);
                return node.getTextContent();
            } else {
                System.out.println("Tag not found: " + tagName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = initChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = driver = initFirefoxDriver();
        } else if (browserType.equalsIgnoreCase("ie")) {
            driver = driver = initIEDriver();
        } else {
            throw new RuntimeException("Invalid Browser Type stated");
        }
        ManagePages.initGrafana();
//        wait = new WebDriverWait(driver, Integer.parseInt(getData("Timeout")), java.util.concurrent.TimeUnit.SECONDS);
        // Your long value representing timeout in seconds
        long timeoutInSeconds = Long.parseLong(getData("Timeout"));

        // Convert the long value to a Duration object
        Duration timeoutDuration = Duration.ofSeconds(timeoutInSeconds);
        // Convert Duration to long (milliseconds)
        long durationInMillis = timeoutDuration.toMillis();
        // Create WebDriverWait with the specified timeout
        wait = new WebDriverWait(driver, durationInMillis);
//        driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
//        driver.get("http://localhost:3000/");
        driver.get(getData("URL"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), java.util.concurrent.TimeUnit.SECONDS);
        action = new Actions(driver);

    }
    public static  void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID,getData("UDID") );
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try{
//            mobileDriver = new AndroidDriver<>(new URL((getData("AppiumServer"))), dc);
            mobileDriver = new AndroidDriver<> (new URL(getData("AppiumServer")), dc);
        }
        catch (Exception e){
            System.out.println("Can not connect to Appium Server, see details: " + e);
        }
        ManagePages.initMortgage();

        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(Objects.requireNonNull(getData("Timeout"))), java.util.concurrent.TimeUnit.SECONDS);
        // wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        // Your long value representing timeout in seconds
        long timeoutInSeconds = Long.parseLong(getData("Timeout"));

        // Convert the long value to a Duration object
        Duration timeoutDuration = Duration.ofSeconds(timeoutInSeconds);
        long durationInMillis = timeoutDuration.toMillis();
        // Create WebDriverWait with the specified timeout
        wait = new WebDriverWait(mobileDriver, durationInMillis);

    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    @BeforeClass
    public void startSession() {
        //String platform = "web"; //System.getProperty("platformName");

        if (getData("PlatformName").equalsIgnoreCase("web")) {
            initBrowser("chrome");
        }
        else if (getData("PlatformName").equalsIgnoreCase("mobile")){
            initMobile();
        }
//        else if (platform.equalsIgnoreCase("electron")){
//            initElectron();
//        }
        else if (getData("PlatformName").equalsIgnoreCase("api")){
            initAPI();
        }
        else {
            throw new RuntimeException("Invalid platform name stated");
        }
        softAssert = new SoftAssert();
        screen = new Screen();
    }

    public static void initAPI(){
        RestAssured.baseURI= getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("UserName"),getData("Password"));
    }

    @AfterClass
    public void closeSession() {
        if(!getData("PlatformName").equalsIgnoreCase("api")) {
            if (!getData("PlatformName").equalsIgnoreCase("web"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }
    @BeforeMethod
    public void beforeMethod(Method method) {
        if(!getData("PlatformName").equalsIgnoreCase("api")){
            try {
                MonteScreenRecorder.startRecord(method.getName());
            }
            catch (Exception e ){
                System.out.println("Failed to start video recording " + method.getName());

            }
        }

    }

}
