package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class WebFlows extends CommonOps {
    public static void login(String user, String pass){
        UIActions.updateText(grafanaLogin.txt_username, user);
        UIActions.updateText(grafanaLogin.txt_password, pass);
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);

    }
    public static void creatNewUser(String name, String email, String user, String pass){
        UIActions.click(grafanaServerAdmin.btn_newUser);
        UIActions.updateText(grafanaAddNewUser.txt_name,name);
        UIActions.updateText(grafanaAddNewUser.txt_email, email);
        UIActions.updateText(grafanaAddNewUser.txt_password, pass);
        UIActions.updateText(grafanaAddNewUser.txt_username, user);
        UIActions.click(grafanaAddNewUser.btn_createUser);
        UIActions.click(grafanaAddNewUser.btn_userHeaderLink);
    }

    public static void deleteLastUser(){
        UIActions.click(grafanaServerAdmin.editUserLinks.get(grafanaServerAdmin.editUserLinks.size()-1));
        UIActions.click(grafanaEditUser.btn_deleteUser);
        UIActions.click(grafanaEditUser.btn_confirmDeleteUser);
    }

}
