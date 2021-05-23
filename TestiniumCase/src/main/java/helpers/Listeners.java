package helpers;

import base.BaseClass;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }


    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info("Test case is starting: " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("Test case was successfully finished: " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.error("Test case failed:" + "\t" + iTestResult.getThrowable().getMessage());
        try {
            saveScreenshotPNG(BaseClass.driver);
            saveTextLog("Test case failed:" + "\t" + iTestResult.getThrowable().getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.warn("Test case was skipped: " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.startLog(iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.endLog(iTestContext.getName());
    }
}
