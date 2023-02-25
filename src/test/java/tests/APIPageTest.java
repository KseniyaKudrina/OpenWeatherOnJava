package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.APIPage;
import pages.MainPage;

import java.util.List;

public class APIPageTest extends BaseTest {
    @Test //количество кнопок "C" на странице API должно == 23
    public void testCountLinksAPIDoc(){
        final int countButtonsAPIDocs = 23;
        openBaseURL();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickAPITopMenu();

        APIPage apiPage = new APIPage(getDriver());

        Assert.assertEquals(countButtonsAPIDocs,  apiPage.getCountWebElementsAPIDocsLinks());
    }
    @Test
    public void testClickAPIDocsLink(){
        openBaseURL().clickAPITopMenu();
        APIPage apiPage = new APIPage(getDriver());
        List<String> listLinksAPI = new APIPage(getDriver()).getAPIDocsLinks();
        System.out.println(listLinksAPI);

    }


}
