package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MapsPage;

public class MapsPageTest extends BaseTest {
    @Test // перейти на MapsPage и подтвердить, что нажатие на checkboxCities отключает города
    public void testClickCitiesCheckBox(){
        final String oldURL = openBaseURL().getCurrentURL();
        openBaseURL().clickByMapsMenu();

        Assert.assertNotEquals(oldURL,getDriver().getCurrentUrl());

        MapsPage mapsPage = new MapsPage(getDriver());
        mapsPage.clickCheckboxCities();
        Assert.assertTrue(mapsPage.checkboxOffCities());

    }

}
