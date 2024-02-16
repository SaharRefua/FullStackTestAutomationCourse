package sanity;

import extensions.Verifications;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;
@Listeners(utilities.Listeners.class)
public class GrafanaAPI extends CommonOps {
    @Test(description = "Test 01: Get Team From Grafana")
    @Description("This Test Verify Team Property")
    public void test01_VerifyTeam(){
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"),"kuku");
    }

    @Test(description = "Test 02: Add Team And verify")
    @Description("This Test Add Team to Grafana and Verify it")
    public void test02_AddTeamAndVerify(){
        ApiFlows.postTeam("YoniTeam","YoniTeam@gmail.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"),"YoniTeam");
    }

    @Test(description = "Test 03: Update Team And verify")
    @Description("This Test Updates Team in Grafana and Verify it")
    public void test03_UpdateTeamAndVerify(){
        String id = ApiFlows.getTeamProperty("teams[0].id");
        ApiFlows.updateTeam("YoniTeam","YoniTeam@walla.com",id);
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].email"),"YoniTeam@walla.com");
    }
    @Test(description = "Test 04: Delete Team And verify")
    @Description("This Test Delete Team in Grafana and Verify it")
    public void test04_DeleteTeamAndVerify(){
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"),"2");
        String id = ApiFlows.getTeamProperty("teams[0].id");
        ApiFlows.deleteTeam(id);
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"),"1");
    }

}
