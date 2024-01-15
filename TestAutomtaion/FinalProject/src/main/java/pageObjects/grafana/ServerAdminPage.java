package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ServerAdminPage {
    @FindBy(how = How.CSS ,using="a[class='css-td06pi-button']")
    public WebElement btn_newUser;
    @FindBy(how = How.XPATH ,using="//div[@class='css-ulujq6'][1]")
    public WebElement link_users;

    @FindBy(how = How.CSS, using= "tr[class='css-1e8ylo6-row']")
    public List<WebElement> rows;
    @FindBy(how = How.XPATH, using= "//tr[@class='css-1e8ylo6-row']/td/a")
    public List<WebElement> editUserLinks;

    @FindBy(how = How.XPATH , using= "//a[href='/admin/orgs']")
    public WebElement link_orgs;

    @FindBy(how = How.XPATH , using= "//a[href='/admin/settings']")
    public WebElement link_settings;
    @FindBy(how = How.CSS , using= "input[class='css-8tk2dk-input-input']")
    public WebElement txt_search;



}
