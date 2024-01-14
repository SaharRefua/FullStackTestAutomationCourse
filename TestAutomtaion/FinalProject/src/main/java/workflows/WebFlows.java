package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;
public class WebFlows extends CommonOps {
    @Step("Login Grafana Flow with user: {0} and pass: {1}")
    public static void login(String user, String pass){
        UIActions.updateText(grafanaLogin.txt_username, user);
        UIActions.updateText(grafanaLogin.txt_password, pass);
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);

    }
    @Step("Login Grafana Flow with user: {0} and pass: {1}")
    public static void creatNewUser(String name, String email, String user, String pass){
        UIActions.click(grafanaServerAdmin.btn_newUser);
        UIActions.updateText(grafanaAddNewUser.txt_name,name);
        UIActions.updateText(grafanaAddNewUser.txt_email, email);
        UIActions.updateText(grafanaAddNewUser.txt_password, pass);
        UIActions.updateText(grafanaAddNewUser.txt_username, user);
        UIActions.click(grafanaAddNewUser.btn_createUser);
        UIActions.click(grafanaAddNewUser.btn_userHeaderLink);
    }
    @Step("Delete last user")
    public static void deleteLastUser(){
        UIActions.click(grafanaServerAdmin.editUserLinks.get(grafanaServerAdmin.editUserLinks.size()-1));
        UIActions.click(grafanaEditUser.btn_deleteUser);
        UIActions.click(grafanaEditUser.btn_confirmDeleteUser);
    }

}
