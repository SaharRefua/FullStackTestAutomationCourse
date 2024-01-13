package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Base { // init global objects


    protected  static Actions action;
    protected  static WebDriver driver;
    protected  static WebDriverWait wait;
    protected  static SoftAssert softAssert;



    // Page Objects
    protected  static pageObjects.grafana.LoginPage grafanaLogin;
    protected  static pageObjects.grafana.MainPage grafanaMain;
    protected  static pageObjects.grafana.LeftMenuPage grafanaLeftMenu;
    protected  static pageObjects.grafana.ServerAdminPage grafanaServerAdmin;
    protected  static pageObjects.grafana.AddNewUserPage grafanaAddNewUser;
    protected  static pageObjects.grafana.EditUserPage grafanaEditUser;


}
