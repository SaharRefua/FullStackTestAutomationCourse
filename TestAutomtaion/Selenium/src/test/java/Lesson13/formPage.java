package Lesson13;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class formPage {

    @FindBy(id = "occupation")
    public WebElement txt_occupation;

    @FindBy(how = How.ID, using = "age")
    public WebElement txt_age;
    @FindBy(how = How.ID, using = "location")
    public WebElement txt_location;

    @FindBy(xpath = "//input[@value='Click Me']")
    public WebElement btn_submit;

    public void fillForm(String occupation,String age, String location) {
        txt_occupation.sendKeys(occupation);
        txt_age.sendKeys(age);
        txt_location.sendKeys(location);
        btn_submit.click();
    }
}
