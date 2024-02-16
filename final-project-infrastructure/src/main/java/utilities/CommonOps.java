package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


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
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        action = new Actions(driver);
    }

    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        driver= new ChromeDriver(dc);
        ManagePages.initToDO();
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
    }

    public static void initDesktop() throws MalformedURLException {
        dc.setCapability("app",getData("CalculatorApp"));
       try{
           driver= new WindowsDriver(new URL(getData("AppiumServerDesktop")),dc);
       }
       catch (Exception e){
           System.out.println("Can not Connect to Appium Server,See Detailed: "+ e);
       }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
       ManagePages.initCalculator();
    }
    public static  void initMobile(){
        dc.setCapability(MobileCapabilityType.UDID,getData("UDID") );
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try{
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        }
        catch (Exception e){
            System.out.println("Can not connect to Appium Server, see details: " + e);
        }
        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        action = new Actions(mobileDriver);
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

    @Parameters({"PlatformName"})
    @BeforeClass
    public void startSession(String PlatformName) throws MalformedURLException {
        //String platform = "web"; //System.getProperty("platformName");
        Platform = PlatformName;

        if (Platform.equalsIgnoreCase("web")) {
            initBrowser("chrome");
        }
        else if (Platform.equalsIgnoreCase("mobile")){
            initMobile();
        }
        else if (Platform.equalsIgnoreCase("electron")){
            initElectron();
        }
        else if (Platform.equalsIgnoreCase("api")){
            initAPI();
        }
        else if (Platform.equalsIgnoreCase("desktop")){
            initDesktop();
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
        if(!Platform.equalsIgnoreCase("api")) {
            if (Platform.equalsIgnoreCase("mobile") )
                mobileDriver.quit();
            else
                driver.quit();

        }
    }
    @AfterMethod
    public void afterMethod() {
        if(Platform.equalsIgnoreCase("web")) {

            driver.get(getData("URL"));
        }
//        else if (Platform.equalsIgnoreCase("electron")){
//            ElectronFlows.emptyList();
//        }
    }
    @BeforeMethod
    public void beforeMethod(Method method) {
        if(!Platform.equalsIgnoreCase("api")){
            try {
                MonteScreenRecorder.startRecord(method.getName());
            }
            catch (Exception e ){
                System.out.println("Failed to start video recording " + method.getName());

            }
        }

    }

}
