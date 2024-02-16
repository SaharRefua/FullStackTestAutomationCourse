package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ServerAdminPage {
    @FindBy(how = How.CSS ,using="a[class='btn btn-primary']")
    public WebElement btn_newUser;
    @FindBy(how = How.XPATH ,using="//a[@href='/admin/users']")
    public WebElement link_users;

    @FindBy(how = How.CSS, using= "tr[ng-repeat='user in ctrl.users']")
    public List<WebElement> rows;
    @FindBy(how = How.XPATH, using= "//tr[@ng-repeat='user in ctrl.users']")
    public List<WebElement> editUserLinks;

    @FindBy(how = How.XPATH , using= "//a[@href='/admin/orgs']")
    public WebElement link_orgs;

    @FindBy(how = How.XPATH , using= "//a[@href='/admin/settings']")
    public WebElement link_settings;
    @FindBy(how = How.CSS , using= "input[placeholder=\"Find user by name/login/email\"]")
    public WebElement txt_search;



}
