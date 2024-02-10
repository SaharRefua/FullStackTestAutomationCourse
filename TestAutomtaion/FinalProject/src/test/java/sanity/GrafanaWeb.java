package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {
    @Test(description = "Test01: Login to Grafana")
    @Description("Test Description: Login to Grafana Web Application and verified the main header")
    public void test01_verifyHeader(){
        WebFlows.login(getData("UserName"),getData("Password"));
        Verifications.verifyTextInElement(grafanaMain.head_dashboard, "Home Dashboard");
    }

    @Test( description = "Test02: Verify default users")
    @Description("Test Description: Verify the default users in Grafana")
    public void test02_verifyDefaultsUsers(){
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
        Verifications.numberOfElements(grafanaServerAdmin.rows, 1);
        Uninterruptibles.sleepUninterruptibly(3, java.util.concurrent.TimeUnit.SECONDS);
    }

    @Test(description = "Test03: Verify create and delete new user")
    @Description("Test Description: Verify create and delete new user in Grafana")
    public void test03_verifyCreateNewUser(){
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
        WebFlows.creatNewUser("Yossi", "yossi2@gmail.com", "yossi", "12345");
        Verifications.numberOfElements(grafanaServerAdmin.rows, 2);
    }
    @Test(description = "Test04: Verify delete new user")
    public void test04_verifyDeleteNewUser(){
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
        WebFlows.deleteLastUser();
        Verifications.numberOfElements(grafanaServerAdmin.rows, 1);
    }
    @Test(description = "Test05: Verify progress steps")
    @Description("Test Description: Verify progress steps in Grafana")
    public void test05_verifyProgressSteps(){
        Verifications.visibilityOfElements(grafanaMain.list_progressSteps);
    }
    @Test(enabled = false,description = "Test06: Verify Avatar Icon")
    @Description("Test Description: Verify Avatar Icon in Grafana Using Sikuli tool")
    public void test06_verifyAvatarIcon() throws FindFailed {
        Verifications.visualElement("grafanaIcon");
    }
    @Test(enabled = false,description = "Test07: search users", dataProvider = "csvReader", dataProviderClass = utilities.ManageDDT.class)
    @Description("Test Description: search users in a table using DDT")
    public void test07_searchUsers(String user, String shouldExist)  {
        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
        WebFlows.searchAndVerifyUser(user, shouldExist);
        Uninterruptibles.sleepUninterruptibly(3, java.util.concurrent.TimeUnit.SECONDS);
    }

    //    @Test(description = "Test07: search users")
//    @Description("Test Description: search users in a table using DDT")
//    public void test07_searchUsers()  {
//        UIActions.click(grafanaLeftMenu.btn_menu);
//        UIActions.click(grafanaLeftMenu.btn_server);
//        UIActions.click(grafanaLeftMenu.btn_usersAndAccess);
//        UIActions.click(grafanaServerAdmin.link_users);
//        WebFlows.searchAndVerifyUser("yossi", "exist");
//        Uninterruptibles.sleepUninterruptibly(3, java.util.concurrent.TimeUnit.SECONDS);
//        WebFlows.searchAndVerifyUser("yossi2", "not-exist");
//        Uninterruptibles.sleepUninterruptibly(3, java.util.concurrent.TimeUnit.SECONDS);
//    }
}
