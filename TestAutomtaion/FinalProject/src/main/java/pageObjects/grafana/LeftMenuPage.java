package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftMenuPage {
    @FindBy(how = How.XPATH , using= "//button[@id='mega-menu-toggle']")
    public WebElement btn_menu;
    @FindBy(how = How.XPATH , using= "//div[@class='sidemenu-item dropdown'][4]")
    public WebElement btn_alerting;

    @FindBy(how = How.XPATH , using= "//div[@class='sidemenu-item dropdown'][5]")
    public WebElement btn_configuration;
    @FindBy(how = How.XPATH , using= "//button[@aria-label='Expand section Administration']")
    public WebElement btn_server;
    @FindBy(how = How.XPATH , using= "//div/*[contains(text(), 'Users and access')]")
    public WebElement btn_usersAndAccess;
}
