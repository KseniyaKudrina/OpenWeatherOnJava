package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainTest extends BaseTest {

    @Test
    public void testOpenPage(){

        String nameCopyright = "© 2012 — 2023 OpenWeather ® All rights reserved";
        openBaseURL();
        MainPage mainPage = new MainPage(getDriver());

        Assert.assertEquals(mainPage.getTextName(),nameCopyright);
    }

}
