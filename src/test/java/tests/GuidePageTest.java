package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GuidePage;
import pages.TopMenuPage;

import java.util.ArrayList;
import java.util.List;

public class GuidePageTest extends BaseTest {

    @Test //количество кнопок "Learn more" на странице Guide должно == 5
    public void testCountButtonsLearnMore(){
        final int countButtonsLearnMore = 5;
        openBaseURL();
        click(By.xpath("//div[@id='desktop-menu']//a[text()='Guide']"));
        //TopMenuPage topMenuPage = new TopMenuPage(getDriver());

        List<WebElement> list = getDriver().
                findElements(By.xpath("//div[@class='col-sm-12']//a[@class='ow-btn round btn-orange']"));
        List <String> textElements = new ArrayList<>();
        int count = 0;
        for(WebElement element : list){
            if(element.getText().equals("Learn more")){
                count++;
            textElements.add(element.getText());
            }
        }
        Assert.assertEquals(countButtonsLearnMore, count);


    }
}
