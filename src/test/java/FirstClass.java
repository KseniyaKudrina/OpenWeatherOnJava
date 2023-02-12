import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class FirstClass extends BaseTest {
    final String BASE_URL = "https://openweathermap.org/";
    final By FOOTER_NAME_COMPANY = By.
            xpath("//div[@class = 'horizontal-section my-5']//span[contains(text(), '© 2012 — 2023 OpenWeather ® All rights reserved')]");
    final By SUPPORT_DROPDOWN = By.id("support-dropdown");
    final By ASC_A_QUESTION_MENU_DROPDOWN = By.xpath("//li[@class='with-dropdown']//a[contains(@href,'https://home.openweathermap.org/questions')]");
    final By DIFFERENT_WEATHER_BUTTON = By.xpath("//div[@id='weather-widget']//span[@class='control-el owm-switch']");
    final By PRICING_BUTTON = By.linkText("Pricing");
    final By DROP_DOWN_MORE_OPTIONS = By.xpath("//div[@class='more-options']");
    final By DIFFERENT_WEATHER_POP_UP_CONTAINER = By.xpath("//div[@class='pop-up-container']");
    final By DIFFERENT_WEATHER_DD_MORE_OPTIONS_DD_SELECTOR = By.xpath("//div[@class='dropdown-selector']");


    @Test
    public void testOpenPage(){

        String nameCopyright = "© 2012 — 2023 OpenWeather ® All rights reserved";
        openBaseURL();

        Assert.assertEquals(getText(FOOTER_NAME_COMPANY),nameCopyright);
    }

    @Test
    public void testSelectAscAQuestion() throws InterruptedException {

        openBaseURL();
        waitElementToBeVisible(SUPPORT_DROPDOWN);
        click(SUPPORT_DROPDOWN);
        click(ASC_A_QUESTION_MENU_DROPDOWN);

        String winHandleBefore = getDriver().getWindowHandle();

        //Переключаемся на новое окно
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }

        Select SubjectField = new Select(getDriver().findElement(By.
                xpath("//div[@class='col-sm-8']/select[@id='question_form_subject']")));
        SubjectField.selectByIndex(2);

        //Закрываем новое окно
        getDriver().close();
        //Переключаемся назад к первоначальному окну
        getDriver().switchTo().window(winHandleBefore);
    }
    @Test
    public void testChangeBGColor_DifferentWeatherButton() throws InterruptedException {

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
    @Test //кликнуть по PRICING_BUTTON и подтвердить переход на другую вкладку
    public void testOpenNewPage_ClickHowToBuy(){
        final String homePageTitle = "Сurrent weather and forecast";
        openBaseURL();
        waitElementToBeVisible(PRICING_BUTTON);
        click(PRICING_BUTTON);

        Assert.assertNotEquals(homePageTitle,getDriver().getTitle());
    }
    @Test
    public void testListElementsDropDown(){
        openBaseURL();
        click(DIFFERENT_WEATHER_BUTTON);
        click(DROP_DOWN_MORE_OPTIONS);
        click(DIFFERENT_WEATHER_DD_MORE_OPTIONS_DD_SELECTOR);

        List <WebElement> list = getDriver().findElements(By.xpath("//ul[@class='dropdown-menu']/*"));
        List <String> textElements = new ArrayList<>();
        for(WebElement element : list){
            textElements.add(element.getText());
        }
        System.out.println(textElements);
        list.get(3).click();
        
    }



}
