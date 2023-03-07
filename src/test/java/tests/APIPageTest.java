package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.APIPage;
import pages.MainPage;

import java.util.Arrays;
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
    @Test // прокликать лист ссылок APIDocs
    public void testClickListAPIDocsLink(){
        List<String> as = Arrays.asList("One Call API 3.0 - OpenWeatherMap", "Current weather data - OpenWeatherMap",
                "Hourly Weather Forecast 4 days - OpenWeatherMap", "Daily Forecast 16 Days - OpenWeatherMap",
                "Climate forecast for 30 days - OpenWeatherMap", "Bulk downloading: Current and forecast weather data - OpenWeatherMap",
                "5 day weather forecast - OpenWeatherMap", "Historical weather API - OpenWeatherMap",
                "History API by timestamp - OpenWeatherMap", "History API Full Archive - OpenWeatherMap",
                "Statistical Weather Data API - OpenWeatherMap", "Accumulated parameters: accumulated temperature and accumulated precipitation - OpenWeatherMap",
                "Weather maps - OpenWeatherMap", "Weather map 1h - OpenWeatherMap", "Weather maps 1.0 - OpenWeatherMap",
                "Global precipitation map - OpenWeatherMap", "Global Precipitation Map Forecast - OpenWeatherMap",
                "Relief maps - OpenWeatherMap", "Air Pollution - OpenWeatherMap", "Geocoding API - OpenWeatherMap",
                "Weather Stations - OpenWeatherMap", "UV Index - OpenWeatherMap", "Weather Alerts. Weather Triggers API - OpenWeatherMap");

        openBaseURL().clickAPITopMenu();
        APIPage apiPage = new APIPage(getDriver());
        apiPage.getAPIDocsLinks();

        Assert.assertEquals(as, apiPage.getAPIDocsLinks());

    }


}
