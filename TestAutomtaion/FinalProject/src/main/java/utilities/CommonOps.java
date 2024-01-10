package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;


public class CommonOps extends Base {

    public void initBrowser(String browserType){
        if (browserType.equalsIgnoreCase("chrome")){
            driver = initChromeDriver();
        }
        else if (browserType.equalsIgnoreCase("firefox")){
            driver = driver = initFirefoxDriver();
        }
        else if (browserType.equalsIgnoreCase("ie")){
            driver = driver = initIEDriver();
        }
        else {
            throw new RuntimeException("Invalid Browser Type stated");
        }
        ManagePages.initGrafana();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get("http://localhost:3000/");
        driver.manage().timeouts().implicitlyWait(5, java.util.concurrent.TimeUnit.SECONDS);
        action = new Actions(driver);

    }
     public static WebDriver initChromeDriver(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            return driver;
     }
    public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }
    @BeforeClass
    public void startSession(){
        String platform = "web"; //System.getProperty("platformName");
        if (platform.equalsIgnoreCase("web")){
            initBrowser("chrome");
        }
//        else if (platform.equalsIgnoreCase("mobile")){
//            initMobile();
//        }
//        else if (platform.equalsIgnoreCase("electron")){
//            initElectron();
//        }
//        else if (platform.equalsIgnoreCase("api")){
//            initAPI();
//        }
        else {
            throw new RuntimeException("Invalid platform name stated");
        }
    }
    @AfterClass
    public void closeSession(){
        driver.quit();
    }


}
