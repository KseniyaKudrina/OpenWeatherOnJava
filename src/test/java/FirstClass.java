import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;

public class FirstClass extends BaseTest {

    @Test
    public void testOpenPage() throws InterruptedException {

        String url = "https://openweathermap.org/";
        String nameCopyright = "© 2012 — 2023 OpenWeather ® All rights reserved";

        getDriver().get(url);
        //Thread.sleep(5000);
        //WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.
                visibilityOfElementLocated(
                        By.xpath("//div[@class = 'horizontal-section my-5']//span[contains(text(), '© 2012 — 2023 OpenWeather ® All rights reserved')]")));

        WebElement footerNameCompany = getDriver().findElement(
                By.xpath("//div[@class = 'horizontal-section my-5']//span[contains(text(), '© 2012 — 2023 OpenWeather ® All rights reserved')]")
        );

        Assert.assertEquals(footerNameCompany.getText(),nameCopyright);
    }

    @Test
    public void testSelectAscAQuestion() throws InterruptedException{

        String url = "https://openweathermap.org/";

        getDriver().get(url);
        getDriver().manage().window().maximize();
        Thread.sleep(8000);

        WebElement SupportDropdown = getDriver().findElement(By.xpath("//div[@id = 'support-dropdown']"));
        SupportDropdown.click();
        Thread.sleep(2000);

        //Запоминаем основное окно
        String winHandleBefore = getDriver().getWindowHandle();

        WebElement AscAQuestionMenuDropdown = getDriver().findElement(
                By.xpath("//li[@class='with-dropdown']//a[contains(@href,'https://home.openweathermap.org/questions')]"));
        AscAQuestionMenuDropdown.click();
        Thread.sleep(7000);

        //Переключаемся на новое окно
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }

        Select SubjectField = new Select(getDriver().findElement(By.xpath("//div[@class='col-sm-8']/select[@id='question_form_subject']")));
        Thread.sleep(2000);
        SubjectField.selectByIndex(2);

        Thread.sleep(3000);

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


}
