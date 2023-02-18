package tests;

import base.BaseTest;
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

}
