package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends FooterMenuPage {
    @FindBy(className = "own-loader-container")
    private WebElement grayContainer;
    @FindBy(xpath = "//div[@class = 'horizontal-section my-5']//span[contains(text(), '© 2012 — 2023 OpenWeather ® All rights reserved')]")
    private WebElement footerNameCompany;

    @FindBy(id = "support-dropdown")
    private WebElement supportDropdown;

    @FindBy(xpath = "//div[@id='weather-widget']//span[@class='control-el owm-switch']")
    private WebElement differentWeatherButton;

    @FindBy(xpath = "//div[@class='more-options']")
    private WebElement dropDownMoreOptions;

    @FindBy(xpath = "//div[@class='pop-up-container']")
    private WebElement differentWeatherPopUpContainer;

    @FindBy(xpath = "//div[@class='dropdown-selector']")
    private WebElement differentWeatherDdMoreOptionsDdSelector;

    @FindBy(xpath = "//div[@id='desktop-menu']//li")
    private WebElement sectionsTopMenu;

    @FindBy(xpath = "//div[text()='Imperial: °F, mph']")
    private WebElement temperatureUnitsF;

    @FindBy(xpath = "//span[@class='heading']")
    private WebElement unitsF;

    @FindBy(xpath = "//div[@class='section-content']//a[text()='Privacy Policy']")
    private WebElement privacyPolicyFooterMenu;

    @FindBy(xpath = "//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
    private WebElement searchCityField;

    @FindBy(xpath = "//div[@id = 'weather-widget']//button[@type = 'submit']")
    private WebElement searchButton;
    @FindBy(className = "search-dropdown-menu")
    private WebElement searchDropdownMenu;

    @FindBy(xpath = "//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
    private WebElement parisFRChoiceInDropdownMenu;

    @FindBy(xpath = "//div[@id = 'weather-widget']//h2")
    private WebElement h2CityCountryHeader;

    @FindBy(xpath = "//div[@class='social']//img[@src='/themes/openweathermap/assets/img/owm_icons/icon_github.png']")
    private WebElement gitIconFooterMenu;

    @FindBy(xpath = "//div[@id='desktop-menu']//a[@href='/api']")
    private WebElement menuAPITopMenu;




    /*final By ASC_A_QUESTION_MENU_DROPDOWN = By.
            xpath("//li[@class='with-dropdown']//a[contains(@href,'https://home.openweathermap.org/questions')]");
    final By PRICING_BUTTON = By.linkText("Pricing");*/


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void waitForGrayContainerDissappeared() {
        getWait().until(ExpectedConditions.
                invisibilityOfElementLocated(
                        By.className("own-loader-container")));
    }

    public String getTextName() {
        return getText(footerNameCompany);
    }
    public MainPage inputSearchCriteria(String text) {
        searchCityField.sendKeys(text);

           return this;
    }

    public int getCountWebElementsTopMenu() {
        List<WebElement> list = getDriver().
                findElements(By.xpath("//div[@id='desktop-menu']//ul//li"));
        List<String> textElements = new ArrayList<>();
        int count = 0;
        for (WebElement element : list) {
                textElements.add(element.getText());
                count++;
            }
        return count;
    }
    public void clickTemperatureUnits(){
        click(temperatureUnitsF);
    }
    public String getTextWait() {
        getWait().until(ExpectedConditions.elementToBeClickable(unitsF));
        return getText(unitsF);
    }
    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }
    public MainPage moveToElement() {
        Actions action = new Actions(getDriver());
        action.moveToElement(privacyPolicyFooterMenu).build().perform();
        return new MainPage(getDriver());
    }
    public void clickPrivacyPolicy(){
        getWait().until(ExpectedConditions.visibilityOf(privacyPolicyFooterMenu));
        click(privacyPolicyFooterMenu);
    }
    public void clickGitIcon(){
        getWait().until(ExpectedConditions.visibilityOf(gitIconFooterMenu));
        click(gitIconFooterMenu);
    }

    public void switchToExternalPage(){
        String winHandleBefore = getDriver().getWindowHandle();
        //Переключаемся на новое окно
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }
    }
    public String getExternalPageURL(){
        return getDriver().getCurrentUrl();
    }

    public MainPage scrollToPageBottom() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        return this;
    }
    public String getExternalPageTitle(){
        return getDriver().getTitle();
    }
    public void clickSearchCityField(){
        click(searchCityField);
    }
    public void clickSearchButton(){
        click(searchButton);
    }
    public MainPage clickParisInDropDownList() {
        getWait().until(ExpectedConditions.visibilityOf(searchDropdownMenu));
        click(parisFRChoiceInDropdownMenu);

        return this;
    }
    public MainPage waitForCityCountryNameChanged(String oldText) {
        waitTextToBeChanged(h2CityCountryHeader, oldText);

        return this;
    }
    public String getCityCountryName() {

        return getText(h2CityCountryHeader);
    }
    public void clickAPITopMenu(){
        click(menuAPITopMenu);
    }

}
