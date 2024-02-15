package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base{

    public static void initGrafana(){   // init grafana page objects
        grafanaLogin = PageFactory.initElements(driver, pageObjects.grafana.LoginPage.class);
        grafanaMain = PageFactory.initElements(driver, pageObjects.grafana.MainPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver, pageObjects.grafana.LeftMenuPage.class);
        grafanaServerAdmin = PageFactory.initElements(driver, pageObjects.grafana.ServerAdminPage.class);
        grafanaAddNewUser = PageFactory.initElements(driver, pageObjects.grafana.AddNewUserPage.class);
        grafanaEditUser = PageFactory.initElements(driver, pageObjects.grafana.EditUserPage.class);

    }

    public static void initMortgage(){   // init Mortgage page objects
        mortgageMain = new pageObjects.mortgage.MainPage(mobileDriver);
    }
    public static void initToDO(){   // init Mortgage page objects
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    public static void initCalculator(){   // init Calculator page objects
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }



}
