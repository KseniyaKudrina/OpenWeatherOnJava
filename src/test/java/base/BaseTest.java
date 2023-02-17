package base;

import org.openqa.selenium.WebElement;
import pages.MainPage;
import utils.ReportUtils;
import utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private WebDriverWait webDriverWait20;
    final String BASE_URL = TestUtils.getBaseUrl();

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
        getDriver().quit();
        webDriverWait = null;
    }

    protected WebDriver getDriver() {

        return driver;
    }

    protected WebDriverWait getWait20(){
        if(webDriverWait20 == null){
            webDriverWait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
        return webDriverWait20;
    }
    protected WebDriverWait getWait10(){
        if(webDriverWait == null){
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return webDriverWait;
    }
    public MainPage openBaseURL(){

        getDriver().get(BASE_URL);
        waitForGrayContainerDissappeared();
        return new MainPage(getDriver());
    }
    public void waitForGrayContainerDissappeared(){
        getWait10().until(ExpectedConditions.
                invisibilityOfElementLocated(
                        By.className("own-loader-container")));
    }
    public String getText(By by){

        return getDriver().findElement(by).getText();
    }
    public void click(By by){
        getWait10().until(ExpectedConditions.visibilityOfElementLocated(by));
        getWait10().until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void waitElementToBeVisible(By by){
        getWait10().until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public String getExternalPageTitle(){
        return getDriver().getTitle();
    }
    public String getExternalPageURL(){
        return getDriver().getCurrentUrl();
    }
    public List<WebElement> webElementList(String text){
        List<WebElement> list = driver.findElements(By.xpath(text));
        return list;
    }



}
