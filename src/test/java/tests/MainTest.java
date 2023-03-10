package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.ArrayList;
import java.util.List;

public class MainTest extends BaseTest {

    @Test
    public void testOpenPage(){

        String nameCopyright = "© 2012 — 2023 OpenWeather ® All rights reserved";
        openBaseURL();
        MainPage mainPage = new MainPage(getDriver());

        Assert.assertEquals(mainPage.getTextName(),nameCopyright);
    }
    @Test // количество разделов TopMenu на главной странице должно == 15
    public void testCountTopMenuTitles(){
        int countTopMenuTitles = 15;
        openBaseURL();
        MainPage mainPage = new MainPage(getDriver());

        Assert.assertEquals(mainPage.getCountWebElementsTopMenu(), countTopMenuTitles);

    }
    @Test // при нажатии на кнопку меняются единицы измерения температуры
    public void testChangeUnitsOfTemperature(){
        String temperatureUnits = "F";
        openBaseURL();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickTemperatureUnits();
        mainPage.getTextWait();

        Assert.assertTrue(mainPage.getTextWait().contains(temperatureUnits));
    }
    @Test // ввести в поле поиска название города и нажать "поиск", убедиться что поиск произошел по выбранному городу
    public void testH2Header_WhenSearchingCityCountry() {
        final String cityName = "Paris";
        final String expectedCityCountryNames = "Paris, FR";

        openBaseURL();
        MainPage mainPage = new MainPage(getDriver());

        final String oldCityCountryName = mainPage.getCityCountryName();

        mainPage.clickSearchCityField();
        mainPage.inputSearchCriteria(cityName);
        mainPage.clickSearchButton();
        mainPage.clickParisInDropDownList();
        mainPage.waitForCityCountryNameChanged(oldCityCountryName);

        String newCityCountryNames = mainPage.getCityCountryName();
        Assert.assertEquals(newCityCountryNames, expectedCityCountryNames);

    }
    @Test
    public void testChangeBGColor_DifferentWeatherButton() {

        openBaseURL();

        WebElement differentWeatherButton = getDriver().findElement(By.xpath(
                "//div[@id='weather-widget']//span[@class='control-el owm-switch']"
        ));
        Actions builder = new Actions(getDriver());
        Action mouseOverHome = builder
                .moveToElement(differentWeatherButton)
                .build();

        String bgColorAfter = differentWeatherButton.getCssValue("background-color");
        mouseOverHome.perform();
        String bgColorAfterBefore = differentWeatherButton.getCssValue("background-color");

        Assert.assertNotEquals(bgColorAfter,bgColorAfterBefore);
    }

}
