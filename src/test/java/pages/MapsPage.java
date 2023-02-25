package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MapsPage extends FooterMenuPage {
    @FindBy(xpath = "//div[@class='weather-layer-container__cities']//label[@class='weather-layer-container__label']")
    private WebElement checkboxCities;
    @FindBy(xpath = "//div[@id='map-wrap']//div[contains(@style,'z-index: 7;')]")
    private WebElement invisibilityNamesCities;
    public MapsPage(WebDriver driver) {
        super(driver);
    }
    public String getCurrentURL(){
       return getDriver().getCurrentUrl();
    }
    public void clickCheckboxCities(){
        getWait().until(ExpectedConditions.visibilityOf(checkboxCities));
        click(checkboxCities);
    }
    public boolean checkboxOffCities(){
        getDriver().findElement(By.xpath("//div[@id='map-wrap']//div[contains(@style,'z-index: 7;')]"));
        return invisibilityNamesCities.isDisplayed();
    }

}
