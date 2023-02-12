package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

}
