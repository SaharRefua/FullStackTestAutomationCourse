package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base { // init global objects

    //General
    protected  static Actions action;
    protected  static WebDriverWait wait;
    protected  static SoftAssert softAssert;
    protected  static Screen screen;

    //Web
    protected  static WebDriver driver;

    //Mobile
    protected  static AppiumDriver mobileDriver;

    protected  static DesiredCapabilities dc = new DesiredCapabilities();
    //Rest API
    protected  static RequestSpecification httpRequest;
    protected  static Response response;

    protected  static JSONObject params = new JSONObject();

    protected  static JsonPath jp;
    // Page Objects - Web
    protected  static pageObjects.grafana.LoginPage grafanaLogin;
    protected  static pageObjects.grafana.MainPage grafanaMain;
    protected  static pageObjects.grafana.LeftMenuPage grafanaLeftMenu;
    protected  static pageObjects.grafana.ServerAdminPage grafanaServerAdmin;
    protected  static pageObjects.grafana.AddNewUserPage grafanaAddNewUser;
    protected  static pageObjects.grafana.EditUserPage grafanaEditUser;

    // Page Objects - Mobile
    protected  static pageObjects.mortgage.MainPage mortgageMain;
    // Page Objects - Electron
    protected  static pageObjects.todo.MainPage todoMain;

}
