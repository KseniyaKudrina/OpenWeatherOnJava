package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    protected WebDriver getDriver(){
        return driver;
    }

    protected WebDriverWait getWait(){
        if(wait == null){
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return wait;
    }
    protected Actions getActions(){
        if(actions == null){
            actions = new Actions(driver);
        }
        return  actions;
    }
    protected String getText(WebElement element){
        if(!element.getText().isEmpty()){
            getWait().until(ExpectedConditions.visibilityOf(element));
        }

        return element.getText();
    }
    protected void click(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    protected void clickBy(By by){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(by));
        getWait().until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    protected void input(String text, WebElement element){
        element.sendKeys();
    }
    protected void waitElementToBeVisible(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

}
