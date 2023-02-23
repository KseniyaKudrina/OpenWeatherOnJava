package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class FooterMenuTest extends BaseTest {
    @Test //навигационный тест - подтверждение перехода на PrivacyPolicy
    public void testPrivacyPolicyFooterLinkNavigatesToPrivacyPolicyWeb(){
        final String basePageTitle = "Сurrent weather and forecast - OpenWeatherMap";
        final String expectedURL = "https://openweather.co.uk/privacy-policy";

        final String oldURL = openBaseURL().getCurrentURL();

        openBaseURL();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.scrollToPageBottom();
        mainPage.clickPrivacyPolicy();
        mainPage.switchToExternalPage();

        Assert.assertNotEquals(mainPage.getExternalPageURL(),oldURL);
        Assert.assertEquals(getExternalPageURL(),expectedURL);
        Assert.assertNotEquals(getExternalPageTitle(),basePageTitle);
    }
    @Test //навигационный тест - подтверждение перехода на Git
    public void testIconGitFooterLinkNavigatesToGitWeb(){
        final String basePageTitle = "Сurrent weather and forecast - OpenWeatherMap";
        final String expectedURL = "https://github.com/search?q=openweathermap&ref=cmdform";

        final String oldURL = openBaseURL().getCurrentURL();

        openBaseURL();
        MainPage mainPage = new MainPage(getDriver());
        mainPage
                .scrollToPageBottom()
                .clickGitIcon();
        mainPage.switchToExternalPage();

        Assert.assertNotEquals(mainPage.getExternalPageURL(),oldURL);
        Assert.assertEquals(getExternalPageURL(),expectedURL);
        Assert.assertNotEquals(getExternalPageTitle(),basePageTitle);

    }


}
