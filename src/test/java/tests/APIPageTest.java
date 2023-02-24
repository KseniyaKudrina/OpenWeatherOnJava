package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.APIPage;
import pages.MainPage;

public class APIPageTest extends BaseTest {
    @Test //количество кнопок "APIDoc" на странице API должно == 23
    public void testCountLinksAPIDoc(){
        final int countButtonsAPIDocs = 23;
        openBaseURL();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickAPITopMenu();

        APIPage apiPage = new APIPage(getDriver());

        Assert.assertEquals(countButtonsAPIDocs,  apiPage.getCountWebElementsAPIDocsLinks());
    }


}
