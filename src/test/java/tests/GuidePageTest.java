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
        openBaseURL()
                .clickGuideMenu();

        GuidePage guidePage = new GuidePage(getDriver());
        guidePage.countButtonsLearnMore();

        Assert.assertEquals(countButtonsLearnMore, guidePage.countButtonsLearnMore());
    }
}
