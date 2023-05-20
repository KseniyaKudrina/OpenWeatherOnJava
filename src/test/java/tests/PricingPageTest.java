package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PricingPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

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
    @Test
    public void testCheckBrokenLinks(){
        String BURL = "https://openweathermap.org/";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;

        openBaseURL().clickByPricingMenu();
        // собираем все ссылки с тегом "а"
        List<WebElement> links = getDriver().findElements(By.tagName("a"));
        // проходим итератором
        Iterator<WebElement> it = links.iterator();
        // проверяем ссылки
        while(it.hasNext()){

            url = it.next().getAttribute("href");

            System.out.println(url);

            if(url == null || url.isEmpty()){
                System.out.println("URL пустой или не привязан"); // URL пустой или не привязан
                continue;
            }

            if(!url.startsWith(BURL)){ // не начинается с BaseURL
                System.out.println("не начинается с BaseURL");
                continue;
            }

            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());

                huc.setRequestMethod("HEAD"); // чтобы вернуть заголовки

                huc.connect();

                respCode = huc.getResponseCode();

                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        getDriver().quit();

    }
    @Test
    public void testComparisonOfTableParameters(){

        Map<String, String> expectedAtributes = new HashMap<>();
        expectedAtributes.put(PricingPage.HISTORY_BULK, "40+ years back");
        expectedAtributes.put(PricingPage.HISTORY_FORECAST_BULK, "5+ years back");
        expectedAtributes.put(PricingPage.STARTER, "1 month back");
        expectedAtributes.put(PricingPage.MEDIUM, "1 year back");
        expectedAtributes.put(PricingPage.ADVANCED, "By request");

        openBaseURL()
                .clickByPricingMenu();
        PricingPage pricingPage = new PricingPage(getDriver());
        pricingPage
                .getAtributes();
        System.out.println();

        Assert.assertEquals(pricingPage.getAtributes(), expectedAtributes);
    }


}
