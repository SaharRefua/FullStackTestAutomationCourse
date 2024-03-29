package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.NAME, using = "Clear")
    public WebElement btn_clear;
    @FindBy(how = How.NAME, using = "One")
    public WebElement btn_one;
    @FindBy(how = How.NAME, using = "Two")
    public WebElement btn_two;
    @FindBy(how = How.NAME, using = "Eight")
    public WebElement btn_eight;
    @FindBy(how = How.NAME, using = "Plus")
    public WebElement btn_plus;
    @FindBy(how = How.XPATH, using = "//*[@AutomationId='equalButton']")
    public WebElement btn_result;
    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;

}
