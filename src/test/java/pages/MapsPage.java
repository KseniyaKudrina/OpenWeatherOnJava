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
    @FindBy(xpath = "//a[contains(@title,'Nominatim Search')]")
    private WebElement nominatimSearch;
    @FindBy(xpath = "//div[@class='leaflet-bar leaflet-control']//input")
    private WebElement nominatimSearchField;

    @FindBy(xpath = "//div[@class='row city-main-info']//span[text()='Erie']")
    private WebElement nominatimSearchCityErie;


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
    public void clickNominatimSearch(){
        getWait().until(ExpectedConditions.visibilityOf(nominatimSearch));
        click(nominatimSearch);
    }
    public MapsPage inputSearchCriteria(String text) {
        input(text,nominatimSearch);
        return this;
    }
    public boolean nominatimSearchCityErie(){

        return nominatimSearchCityErie.isDisplayed();
    }
    public void clickNominatimSearchField(){
        getWait().until(ExpectedConditions.visibilityOf(nominatimSearchField));
        click(nominatimSearchField);
    }

}
