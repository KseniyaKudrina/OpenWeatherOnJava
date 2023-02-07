package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeSuite
    protected void beforeSuite (ITestContext context){
        Reporter.log(ReportUtils.getReportHeader(context), true);
    }

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
        Reporter.log(ReportUtils.END_LINE, true);
        Reporter.log("TEST RUN", true);
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult result) {
        Reporter.log(ReportUtils.getTestStatistics(method, result));
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait20(){
        if(webDriverWait == null){
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
        return webDriverWait;
    }
    protected WebDriverWait getWait10(){
        if(webDriverWait == null){
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return webDriverWait;
    }
    protected WebDriverWait getWait30(){
        if(webDriverWait == null){
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return webDriverWait;
    }
}
