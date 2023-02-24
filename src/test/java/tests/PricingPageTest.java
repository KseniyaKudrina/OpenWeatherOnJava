package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PricingPage;

import java.util.ArrayList;
import java.util.List;

public class PricingPageTest extends BaseTest {
    @Test //кликнуть PricingMenu и подтвердить переход на другую вкладку
    public void testOpenPricingPage(){
        final String homePageTitle = "Сurrent weather and forecast";
        openBaseURL().clickByPricingMenu();

        Assert.assertNotEquals(homePageTitle,getDriver().getTitle());
    }
    @Test //сравнить элементы тбл SpecialProducts
    public void testListTableSpecialProducts(){
        List<String> elementsTableSpecialProducts = new ArrayList<>();
        elementsTableSpecialProducts.add(0,"Solar Radiation API");
        elementsTableSpecialProducts.add(1,"Global Weather Alerts Push notifications");
        elementsTableSpecialProducts.add(2,"Road Risk API (advanced configuration)");
        elementsTableSpecialProducts.add(3,"Global Precipitation Map - Forecast and historical data");
        elementsTableSpecialProducts.add(4,"Weather Maps 2.0 with 1-hour step");

        openBaseURL()
                .clickByPricingMenu()
                .listTableSpecialProducts();
        PricingPage pricingPage = new PricingPage(getDriver());

        Assert.assertEquals(elementsTableSpecialProducts,pricingPage.listTableSpecialProducts());

    }
}
