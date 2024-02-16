package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditUserPage {
    @FindBy(how = How.XPATH ,using="//div[@class=\"gf-form-button-row\"]/button[@class=\"btn btn-danger\"][2]")
    public WebElement btn_deleteUser;
    @FindBy(how = How.XPATH ,using="//button[@ng-click=\"onConfirm();dismiss();\"]")
    public WebElement btn_confirmDeleteUser;
    @FindBy(how = How.XPATH ,using="//input[@ng-model=\"user.login\"]")
    public WebElement btn_userTitle;

}
