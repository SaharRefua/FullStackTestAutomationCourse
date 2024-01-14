package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends CommonOps implements ITestListener {

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
        try {
            MonteScreenRecorder.stopRecord();
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }

        //Delete recorded file
        File file = new File("./test-recording/"+ test.getName() +".avi");
        if (file.delete()){
            System.out.println("Failed Deleted Successfully");
        }
        else {
            System.out.println("Failed to Deleted File");
        }
    }

    public void onTestFailure(ITestResult test) {
        // TODO Auto-generated method stub
        System.out.println("Test Failed....");
        try {
            MonteScreenRecorder.stopRecord();
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
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

