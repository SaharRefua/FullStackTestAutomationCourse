package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

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
    @Step("Verify visibility Image Elements")
    public static void visualElement(String expectedImageName) {
        try{
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (Exception e) {
            System.out.println("Error Comparing Image File: " + e);
            fail();
        }
    }

    @Step("Verify Element Displayed")
    public static void existenceOfElement(List <WebElement> elems) {
       assertTrue(elems.size() >0);
    }

    @Step("Verify Element Not Displayed")
    public static void nonexistenceOfElement(List <WebElement> elems) {
        assertFalse(elems.size() >0);
    }
    @Step("Verify Text with Text")
    public static void verifyText(String actual, String expected ){assertEquals(actual, expected);}
    @Step("Verify Number with Number")
    public static void verifyNumber(int actual, int expected ){assertEquals(actual, expected);}

}
