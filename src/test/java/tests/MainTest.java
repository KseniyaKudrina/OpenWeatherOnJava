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
    @Test
    public void testCountTopMenuTitles(){
        int countTopMenuTitles = 15;
        openBaseURL();
        MainPage mainPage = new MainPage(getDriver());
        Assert.assertEquals(mainPage.getWebElementsTopMenu(), countTopMenuTitles);

    }

}
