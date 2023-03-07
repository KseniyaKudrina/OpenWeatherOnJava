package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GuidePage;

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
