package workflows;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class WebFlows extends CommonOps {
    @Step("Login Grafana Flow with user: {0} and pass: {1}")
    public static void login(String user, String pass) {
        UIActions.updateText(grafanaLogin.txt_username, user);
        UIActions.updateText(grafanaLogin.txt_password, pass);
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);

    }

    @Step("Login Grafana Flow with user: {0} and pass: {1}")
    public static void creatNewUser(String name, String email, String user, String pass) {
        UIActions.click(grafanaServerAdmin.btn_newUser);
        UIActions.updateText(grafanaAddNewUser.txt_name, name);
        UIActions.updateText(grafanaAddNewUser.txt_email, email);
        UIActions.updateText(grafanaAddNewUser.txt_password, pass);
        UIActions.updateText(grafanaAddNewUser.txt_username, user);
        UIActions.click(grafanaAddNewUser.btn_createUser);
        UIActions.click(grafanaAddNewUser.btn_userHeaderLink);
    }

    @Step("Delete last user")
    public static void deleteLastUser() {
        UIActions.click(grafanaServerAdmin.editUserLinks.get(grafanaServerAdmin.editUserLinks.size() - 1));
        UIActions.click(grafanaEditUser.btn_deleteUser);
        UIActions.click(grafanaEditUser.btn_confirmDeleteUser);
    }

    @Step("Search and verify user")
    public static void searchAndVerifyUser(String user, String shouldExist) {
        UIActions.updateText(grafanaServerAdmin.txt_search, user);
        if (shouldExist.equalsIgnoreCase("exist"))
            Verifications.existenceOfElement(grafanaServerAdmin.rows);

        else if (shouldExist.equalsIgnoreCase("not-exist")){
            Verifications.nonexistenceOfElement(grafanaServerAdmin.rows);
        }
        else {
            System.out.println("Invalid value for shouldExist parameter");
        }


    }

}
