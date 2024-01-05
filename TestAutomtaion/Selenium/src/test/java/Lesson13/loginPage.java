package Lesson13;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage {
    @FindBy(xpath = "//input[@name='username2']")
    public WebElement txt_username;

    @FindBy(how = How.XPATH, using = "//input[@name='password2']")
    public WebElement txt_password;

    @FindBy(id = "submit")
    public WebElement btn_submit;

    public void loginForm(String username, String password) {
        txt_username.sendKeys(username);
        txt_password.sendKeys(password);
        btn_submit.click();
    }
}
