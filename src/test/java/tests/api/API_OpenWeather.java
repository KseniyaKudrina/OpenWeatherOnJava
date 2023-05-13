package tests.api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;


public class API_OpenWeather {
    String URL = "https://openweathermap.org/";
    @Test
    public void testFindCity(){
        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .get( URL + "data/2.5/onecall?lat=43.1555&lon=-7.3214&units=metric&appid=439d4b804bc8187953eb36d2a8c26a02")
                .then()
                .body("hourly", notNullValue())
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Float lat = jsonPath.get("lat");
        Float lon = jsonPath.get("lon");

        Assert.assertTrue(jsonPath.get("lat").equals(lat));
        Assert.assertTrue(jsonPath.get("lon").equals(lon));




    }
}
