package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

public class UIActions extends CommonOps {

    @Step("Click on element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    @Step("Update text element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Insert key")
    public static void insertKey(WebElement elem, Keys value ){
        elem.sendKeys(value);
    }

    @Step("Update text element as human user")
    public static void updateTextHuman(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        for (char ch : text.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(500, java.util.concurrent.TimeUnit.MILLISECONDS);
            elem.sendKeys(ch + "");
        }
//        elem.sendKeys(text);
    }
    @Step("Clear text element")
    public static void clearText(WebElement elem){
        elem.clear();
    }
    @Step("Update drop down element")
    public static void updateDropDown(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);

    }
    public static void mouseHover(WebElement elem1, WebElement elem2){
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }
    public static void mouseHover(WebElement elem1){
        action.moveToElement(elem1).click().build().perform();
    }

}
