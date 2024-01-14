package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Verifications  extends CommonOps {
    @Step("Verify Text in Element")
    public static void verifyTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }
    @Step("Verify number of elements")
    public static void numberOfElements(List<WebElement> elems, int expectedNumber){
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), expectedNumber);
    }
    @Step("Verify visibility of elements")
    public static void visibilityOfElements(List <WebElement> elems){
        for(WebElement elem : elems){
            wait.until(ExpectedConditions.visibilityOf(elem));
            softAssert.assertTrue(elem.isDisplayed() , "Element is not displayed"  + elem.getText());
        }
        softAssert.assertAll("Some Elements were not displayed");
    }
}
