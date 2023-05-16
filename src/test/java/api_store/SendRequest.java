package api_store;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.Test;

import static api_Reqres_in.Specifications.responseSpecificationUnique;
import static io.restassured.RestAssured.given;

public class SendRequest {
    private final static String URL = "https://send-request.me";
    @Test
    //"Добавление нового пользователя/все поля заполнены"
    public void testAddNewUser(){
        responseSpecificationUnique(201);

        String firstName = "Lemon";
        String lastName = "Fruit";
        Integer companyId = 1;

        SendRequest_CreateNewUserRequest sendRBody =
                new SendRequest_CreateNewUserRequest(firstName,lastName,companyId);

        SendRequest_CreateNewUserResponse Response =
                given()
                .body(sendRBody)
                .when()
                .contentType(ContentType.JSON)
                .post(URL + "/api/users/")
                .then().extract().as(SendRequest_CreateNewUserResponse.class);

        Assert.assertEquals(firstName, Response.getFirst_name());
        Assert.assertEquals(lastName, Response.getLast_name());
        Assert.assertEquals(companyId, Response.getCompany_id());
    }
    @Test
    //"Добавление нового пользователя/заполнены только обязательные поля"
    public void testAddNewUserPlusNotOptionalFields(){
        responseSpecificationUnique(201);

        String lastName = "Cherry"; //одно обязательное поле

        SendRequest_CreateNewUserRequest sendRBody =
                new SendRequest_CreateNewUserRequest(null,lastName,null);

        SendRequest_CreateNewUserResponse Response =
                given()
                        .body(sendRBody)
                        .when()
                        .contentType(ContentType.JSON)
                        .post(URL + "/api/users/")
                        .then().extract().as(SendRequest_CreateNewUserResponse.class);

        Assert.assertEquals(lastName, Response.getLast_name());
    }

    @Test
    //Добавление нового пользователя с пустыми полями /проверка 422 кода"
    public void testAddNewUserEmptyFields(){
        responseSpecificationUnique(422);

        String expMSG = "none is not an allowed value";

        SendRequest_CreateNewUserRequest sendRBody =
                new SendRequest_CreateNewUserRequest(null,null,null);

        Response response =
                given()
                        .body(sendRBody)
                        .when()
                        .contentType(ContentType.JSON)
                        .post(URL + "/api/users/")
                        .then()
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();
        String msg = jsonPath.get("detail.msg").toString();

        Assert.assertTrue(msg.contains(expMSG));

    }


}
