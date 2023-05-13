package tests.api;


import base.BaseTest;

public class API_MainTest extends BaseTest {/*
    @Test
    public void test_API_HttpRequest_OpenBaseURL() {
        List<String> requests = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequestsContain("weather");

        openBaseURL();
        Assert.assertNotNull(requests);
        for (int i = 0; i < requests.size(); i += 2) {
            Assert.assertEquals(requests.get(i), "GET");
        }
        for (int i = 1; i < requests.size(); i += 2) {
            Assert.assertTrue(requests.get(i).contains("openweathermap.org/"));
        }
    }

    @Test
    public void test_API_CNTResponse_OpenBaseURL() {
        List<String> responses = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpResponsesContain("weather");

        openBaseURL();

        Assert.assertNotNull(responses);
        for (int i = 0; i < responses.size(); i += 4) {
            Assert.assertEquals(responses.get(i), "200");
        }
        for (int i = 1; i < responses.size(); i += 4) {
            Assert.assertEquals(responses.get(i), "OK");
        }
        for (int i = 2; i < responses.size(); i += 4) {
            Assert.assertTrue(responses.get(i).contains("openweathermap.org/"));
        }
        Assert.assertTrue(Double.parseDouble(responses.get(3).substring(10, 14)) <= 3);
    }

    @Test
    public void test_API_CNTRequests_WhenSearchingCityCountry() {
        List<String> requestsSearchButton = new CaptureNetworkTraffic()
                .setUpDevTool(getDriver())
                .captureHttpRequestsContain("weather");

        openBaseURL()
                .clickSearchCityField();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.inputSearchData("Paris")
                .clickSearchButton();

        Assert.assertNotNull(requestsSearchButton);
        Assert.assertEquals(requestsSearchButton.get(requestsSearchButton.size() - 2), "GET");
        Assert.assertTrue(requestsSearchButton.get(requestsSearchButton.size() - 1)
                .contains("openweathermap.org/data/2.5/find?q=Paris"));

        mainPage.clickParisInDropDownList();

        Assert.assertNotNull(requestsSearchButton);
        System.out.println(requestsSearchButton);
        Assert.assertEquals(requestsSearchButton.get(requestsSearchButton.size() - 2), "GET");
        Assert.assertTrue(requestsSearchButton.get(requestsSearchButton.size() - 1)
                .contains("openweathermap.org/data/2.5/onecall?lat=48.8534&lon=2.3488"));
    }*/
}
