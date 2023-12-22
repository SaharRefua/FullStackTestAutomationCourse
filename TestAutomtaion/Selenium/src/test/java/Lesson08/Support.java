package Lesson08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class Support {
    public static void verifyElements(WebDriver driver) {
        SoftAssert soft = new SoftAssert();
        String expected = "elem ";
        List<WebElement> elements = driver.findElements(By.cssSelector(" div[id='ms-aloha']>div[class='ms-selectable']>ul[class='ms-list']>li[class='ms-elem-selectable']"));
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText());

            soft.assertEquals(elements.get(i).getText(), expected + (i + 3));
        }
        soft.assertAll();
    }
}
