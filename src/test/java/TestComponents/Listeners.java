package TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.GlobalData.ExtentReporterNG;

import java.io.IOException;

public class Listeners extends BaseTest implements  ITestListener {

    ExtentReports extent = ExtentReporterNG.gerReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> treadLocal=new ThreadLocal<ExtentTest>();//thread safe
    @Override
    public void onTestStart(ITestResult result) {
       test=extent.createTest(result.getMethod().getMethodName());
       treadLocal.set(test); //unique thread id

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        treadLocal.get().log(Status.PASS,"Test Passed");



    }
    @Override
    public void onTestFailure(ITestResult result) {
        treadLocal.get().fail(result.getThrowable());
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String filePath= null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       // test.addScreenCaptureFromBase64String(filePath,result.getMethod().getMethodName());

        treadLocal.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
        //Screenshot 2-Attach it to the report

    }
    @Override
    public void onTestSkipped(ITestResult result) {

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

        this.onTestFailure(result);
    }
    @Override
    public void onStart(ITestContext context) {

    }
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

    }






}
