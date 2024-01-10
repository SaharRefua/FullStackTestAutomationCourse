package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    @FindBy(how = How.CSS , using= "h6[title='Dashboards']")
    public WebElement head_dashboard;
}
