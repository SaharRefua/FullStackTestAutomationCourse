package ChatGpt.Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "submit")
    private WebElement submit;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submit.click();
    }
}