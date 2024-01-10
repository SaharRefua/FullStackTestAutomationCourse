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
//    @Test
//    public void test02_verifyDefaultsUsers(){
//        UIActions.click(grafanaLeftMenu.btn_menu);
//        UIActions.mouseHover(grafanaLeftMenu.btn_server, grafanaServerAdmin.link_users);
//        Uninterruptibles.sleepUninterruptibly(100, TimeUnit.SECONDS);
//
//
//    }
}
