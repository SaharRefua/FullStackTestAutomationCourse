package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import java.util.concurrent.TimeUnit;
@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {
    @Test(description = "Test01: Login to Grafana")
    @Description("Test Description: Login to Grafana Web Application and verified the main header")
    public void test01_verifyHeader(){
        WebFlows.login("admin", "admin");
        Verifications.verifyTextInElement(grafanaMain.head_dashboard, "Dashboards");

    }
    @Test(description = "Test02: Verify default users")
    @Description("Test Description: Verify the default users in Grafana")
    public void test02_verifyDefaultsUsers(){
        UIActions.click(grafanaLeftMenu.btn_menu);
        UIActions.click(grafanaLeftMenu.btn_server);
        UIActions.click(grafanaLeftMenu.btn_usersAndAccess);
        UIActions.click(grafanaServerAdmin.link_users);
        Verifications.numberOfElements(grafanaServerAdmin.rows, 1);
    }

    @Test(description = "Test03: Verify create and delete new user")
    @Description("Test Description: Verify create and delete new user in Grafana")
    public void test03_verifyCreateNewUser(){
        WebFlows.creatNewUser("Yossi", "yossi@gmail.com", "yossi", "12345");
        Verifications.numberOfElements(grafanaServerAdmin.rows, 2);

    }
    @Test(enabled = false)
    public void test04_verifyDeleteNewUser(){
        WebFlows.deleteLastUser();
        Verifications.numberOfElements(grafanaServerAdmin.rows, 1);

    }
    @Test(description = "Test05: Verify progress steps")
    @Description("Test Description: Verify progress steps in Grafana")
    public void test05_verifyProgressSteps(){
        Verifications.visibilityOfElements(grafanaMain.list_progressSteps);

    }
}
