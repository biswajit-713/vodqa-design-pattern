package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;
import resources.ExtentReportNG;

import java.io.IOException;

public class Listeners extends Base implements ITestListener  {
    ExtentTest extentTest;
    ExtentReports extentReports = ExtentReportNG.getExtentReport();
    ThreadLocal<ExtentTest> threadLocal = new ThreadLocal();

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        threadLocal.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        threadLocal.get().log(Status.PASS, "Test case passes: "+ result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        threadLocal.get().log(Status.FAIL, "Test case failed: "+ result.getMethod().getMethodName());
        threadLocal.get().fail(result.getThrowable());

        WebDriver driver = null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {

            threadLocal.get().addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(), driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        threadLocal.remove();
        extentReports.flush();
    }
}
