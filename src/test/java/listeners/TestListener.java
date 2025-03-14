package listeners;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        log.info((String.format("======================================== STARTING TEST {} ========================================%n", iTestResult.getName())));
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info(String.format("======================================== FINISHED TEST {} Duration: {} ========================================%n", iTestResult.getName(),
                getExecutionTime(iTestResult)));
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.info(String.format("======================================== FAILED TEST {} Duration: {} ========================================%n", iTestResult.getName(),
                getExecutionTime(iTestResult)));
        takeScreenshot(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.info(String.format("======================================== SKIPPING TEST {} ========================================%n", iTestResult.getName()));
        takeScreenshot(iTestResult);
    }

    @Attachment(value = "Last screen state", type = "image/png")
    private byte[] takeScreenshot(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        try {
            WebDriver driver = (WebDriver) context.getAttribute("driver");
            if (driver != null) {
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } else {
                return new byte[]{};
            }
        } catch (NoSuchSessionException | IllegalStateException ex) {
            return new byte[]{};
        }
    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
