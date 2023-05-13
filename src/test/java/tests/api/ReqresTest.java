package tests.api;

import api_Reqres_in.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;


public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void testGETRequest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecification200());

        List<Data> users = given()
                .when()
               // .contentType(ContentType.JSON)
               // .get(URL + "api/users?page=2")
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", Data.class);

       users.forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
       Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));

       // через лист
        /*List<String> avatars = users.stream().map(Alert::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
        for(int i = 0; i<avatars.size(); i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
        */
    }
    @Test
    public void testSuccsesRegistrationPOST(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecification200());

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        Register user = new Register("eve.holt@reqres.in", "pistol");

        SuccessRegistration successRegistration = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessRegistration.class);

        Assert.assertNotNull(successRegistration.getId());
        Assert.assertNotNull(successRegistration.getToken());

        Assert.assertEquals(id, successRegistration.getId());
        Assert.assertEquals(token, successRegistration.getToken());
    }

    @Test
    public void testUnSuccsesRegistrationPOST(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecificationError400());

        Register user = new Register("fvffv@bhjdc", "");

        UnSuccessRegistration unSuccessRegistration = given()
                .body(user)
                .post("api/register")
                .then().log().all()
                .extract().as(UnSuccessRegistration.class);

        Assert.assertEquals("Missing password", unSuccessRegistration.getError());
    }

    @Test
    public void testSortedYearsGET(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecification200());

        List<ColorsData> colorsData = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);

        List<Integer> years = colorsData.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());

        Assert.assertEquals(sortedYears, years);
    }
    @Test
    public void testDellUserDELETE(){
        Specifications.installSpecification(Specifications.requestSpec(URL),
                Specifications.responseSpecificationUnique(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();
    }

    @Test
    public void testCreateNewUserPOST(){
        Specifications.installSpecification(Specifications.requestSpec(URL),
                Specifications.responseSpecificationUnique(201));
        String expectedName = "morpheus";
        String expectedJob = "leader";

        CreateNewUserRequestBody newUser = new CreateNewUserRequestBody("morpheus", "leader");
        CreateNewUserResponseBody responseBody = given()
                .body(newUser)
                .when()
                .post("api/users")
                .then().log().all()
                .extract().as(CreateNewUserResponseBody.class);

        Assert.assertEquals(expectedName, responseBody.getName());
        Assert.assertEquals(expectedJob, responseBody.getJob());

    }




}

