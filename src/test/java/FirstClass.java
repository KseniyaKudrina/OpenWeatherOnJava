import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class FirstClass extends BaseTest {
    final static String BASE_URL = "https://openweathermap.org/";
    final static By FOOTER_NAME_COMPANY = By.
            xpath("//div[@class = 'horizontal-section my-5']//span[contains(text(), '© 2012 — 2023 OpenWeather ® All rights reserved')]");
    final static By SUPPORT_DROPDOWN = By.id("support-dropdown");
    final static By ASC_A_QUESTION_MENU_DROPDOWN = By.xpath("//li[@class='with-dropdown']//a[contains(@href,'https://home.openweathermap.org/questions')]");
    final static By DIFFERENT_WEATHER_BUTTON = By.xpath("//div[@id='weather-widget']//span[@class='control-el owm-switch']");
    final static By PRICING_BUTTON = By.linkText("Pricing");
    private void openBaseURL(){
        getDriver().get(BASE_URL);
    }
    private void waitForGrayFrameDissapeared(){
        getWait20().until(ExpectedConditions.
                invisibilityOfElementLocated(
                        By.className("own-loader-container")));
    }
    private String getText(By by, WebDriver driver){
        return driver.findElement(by).getText();
    }
    private void click(By by, WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    private void waitElementToBeVisible(By by, WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }



    @Test
    public void testOpenPage(){

        String nameCopyright = "© 2012 — 2023 OpenWeather ® All rights reserved";

        openBaseURL();
        waitForGrayFrameDissapeared();

        Assert.assertEquals(getText(FOOTER_NAME_COMPANY, getDriver()),nameCopyright);
    }

    @Test
    public void testSelectAscAQuestion() throws InterruptedException {

        openBaseURL();
        waitForGrayFrameDissapeared();
        waitElementToBeVisible(SUPPORT_DROPDOWN, getWait10());
        click(SUPPORT_DROPDOWN, getWait10());
        click(ASC_A_QUESTION_MENU_DROPDOWN, getWait10());

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
        String url = "https://openweathermap.org/";

        getDriver().get(url);
        getDriver().manage().window().maximize();
        Thread.sleep(8000);

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
    @Test
    public void testOpenNewPage_ClickHowToBuy(){
        String homePageTitle = "Сurrent weather and forecast";
        openBaseURL();
        waitForGrayFrameDissapeared();
        waitElementToBeVisible(PRICING_BUTTON, getWait10());
        click(PRICING_BUTTON, getWait10());

        Assert.assertNotEquals(homePageTitle,getDriver().getTitle());



    }



}
