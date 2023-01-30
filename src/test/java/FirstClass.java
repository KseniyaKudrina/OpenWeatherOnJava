import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class FirstClass extends BaseTest {

    @Test
    public void testOpenPage() throws InterruptedException {

        String url = "https://openweathermap.org/";
        String nameCopyright = "© 2012 — 2023 OpenWeather ® All rights reserved";

        getDriver().get(url);
        Thread.sleep(5000);

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

       /* WebElement SubjectField = driver.findElement(
                By.xpath("//div[@class='col-sm-8']/select[@id='question_form_subject']"));
        Thread.sleep(2000);
        SubjectField.click();

        Thread.sleep(3000); */

        //Закрываем новое окно, если оно больше не нужно
        getDriver().close();
        //Переключаемся назад к первоначальному окну
        getDriver().switchTo().window(winHandleBefore);

    }
}
