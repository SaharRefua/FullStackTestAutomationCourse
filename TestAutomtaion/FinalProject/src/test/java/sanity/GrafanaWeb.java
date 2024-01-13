package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import java.util.concurrent.TimeUnit;

public class GrafanaWeb extends CommonOps {
    @Test
    public void test01_verifyHeader(){
        WebFlows.login("admin", "admin");
        Verifications.verifyTextInElement(grafanaMain.head_dashboard, "Dashboards");

    }
    @Test
    public void test02_verifyDefaultsUsers(){
        UIActions.click(grafanaLeftMenu.btn_menu);
        UIActions.click(grafanaLeftMenu.btn_server);
        UIActions.click(grafanaLeftMenu.btn_usersAndAccess);
        UIActions.click(grafanaServerAdmin.link_users);
        Verifications.numberOfElements(grafanaServerAdmin.rows, 1);
    }

    @Test
    public void test03_verifyCreateNewUser(){
        WebFlows.creatNewUser("Yossi", "yossi@gmail.com", "yossi", "12345");
        Verifications.numberOfElements(grafanaServerAdmin.rows, 2);

    }
    @Test(enabled = false)
    public void test04_verifyDeleteNewUser(){
        WebFlows.deleteLastUser();
        Verifications.numberOfElements(grafanaServerAdmin.rows, 1);

    }
    @Test
    public void test05_verifyProgressSteps(){
        Verifications.visibilityOfElements(grafanaMain.list_progressSteps);

    }
}
