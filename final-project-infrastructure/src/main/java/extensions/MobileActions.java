package extensions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

public class MobileActions extends CommonOps {
    @Step("Update text element")
    public static void updateText(MobileElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Tap on Element")
    public static void tap(MobileElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        TouchAction action = new TouchAction(mobileDriver);
        action.tap((new TapOptions().withElement(ElementOption.element(elem)))).perform();
    }

    @Step("Swipe")
    public static void swipe(Direction dir) {
        System.out.println("Swipe(): dir" + dir);
        final int ANIMATION_TIME = 200;
        final int PRESS_TIME = 200;
        int edgeBorder = 10;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = mobileDriver.manage().window().getSize();

        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        switch (dir) {
            case DOWN:
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP:
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT:
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT:
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new RuntimeException("Unknown swipe direction: " + dir);
        }

        try {
            new TouchAction(mobileDriver)
                    .press(pointOptionStart)
                    .waitAction()
                    .moveTo(pointOptionEnd)
                    .release()
                    .perform();
        } catch (Exception e) {
            System.out.println("Error on swipeScreen(): " + e);
        }
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            //ignore
        }
    }


    @Step("Zoom Element")
    public static void zoom(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getLocation().getX() + (elem.getSize().getWidth() / 2);
        int y = elem.getLocation().getY() + (elem.getSize().getHeight() / 2);
        TouchAction finger1 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption()
                .withElement(elem).withCoordinates(x , y-10))
                .moveTo(new ElementOption()
                        .withElement(elem).withCoordinates(x , y-100));
        TouchAction finger2 = new TouchAction(mobileDriver);
        finger2.press(new ElementOption()
                .withElement(elem).withCoordinates(x , y+10))
                .moveTo(new ElementOption()
                        .withElement(elem).withCoordinates(x , y+100));
        MultiTouchAction action = new MultiTouchAction(mobileDriver);
        action.add(finger1).add(finger2).perform();
    }
    @Step("Pinch Element")
    public void pinch(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getLocation().getX() + (elem.getSize().getWidth() / 2);
        int y = elem.getLocation().getY() + (elem.getSize().getHeight() / 2);
        TouchAction finger1 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption()
                        .withElement(elem).withCoordinates(x , y-100))
                .moveTo(new ElementOption()
                        .withElement(elem).withCoordinates(x , y-10));
        TouchAction finger2 = new TouchAction(mobileDriver);
        finger2.press(new ElementOption()
                        .withElement(elem).withCoordinates(x , y+100))
                .moveTo(new ElementOption()
                        .withElement(elem).withCoordinates(x , y+10));
        MultiTouchAction action = new MultiTouchAction(mobileDriver);
        action.add(finger1).add(finger2).perform();
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }
}
