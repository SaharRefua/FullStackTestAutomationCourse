package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners  extends CommonOps implements ITestListener{

    public void onStart(ITestContext execution) {
        // TODO Auto-generated method stub
        System.out.println("Testing run the tests....");
    }

    public void onFinish(ITestContext execution) {
        // TODO Auto-generated method stub
        System.out.println("Test Finished....");
    }

    public void onTestStart(ITestResult test) {
        // TODO Auto-generated method stub
        System.out.println("Test Started....");
    }

    public void onTestSuccess(ITestResult test) {
        // TODO Auto-generated method stub
        System.out.println("Test Success....");
    }

    public void onTestFailure(ITestResult test) {
        // TODO Auto-generated method stub
        System.out.println("Test Failed....");
        takeScreenshot();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        // TODO Auto-generated method stub
        System.out.println("Test Failed but within success percentage....");
    }

    public void onTestSkipped(ITestResult test) {
        // TODO Auto-generated method stub
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
}

