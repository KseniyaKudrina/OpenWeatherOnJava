package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends FooterMenuPage{
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

    @FindBy(xpath ="//div[@class='dropdown-selector']")
    private WebElement differentWeatherDdMoreOptionsDdSelector;


    final By ASC_A_QUESTION_MENU_DROPDOWN = By.xpath("//li[@class='with-dropdown']//a[contains(@href,'https://home.openweathermap.org/questions')]");
    final By PRICING_BUTTON = By.linkText("Pricing");


    public MainPage(WebDriver driver) {
        super(driver);
    }
    public void waitForGrayContainerDissappeared(){
        getWait().until(ExpectedConditions.
                invisibilityOfElementLocated(
                        By.className("own-loader-container")));
    }
    public String getTextName(){
       return getText(footerNameCompany);
    }
   /*public void inputSearchCriteria(String text){
       input(text, __ элемент __); нужен элемент для ввода текста
    } */

}
