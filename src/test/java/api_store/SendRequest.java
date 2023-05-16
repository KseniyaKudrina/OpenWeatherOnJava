package api_store;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.Test;

import static api_Reqres_in.Specifications.responseSpecificationUnique;
import static io.restassured.RestAssured.given;

public class SendRequest {
    private final static String URL = "https://send-request.me";
    @Test
    @DisplayName("Добавление нового пользователя/все поля заполнены")
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
    @DisplayName("Добавление нового пользователя/заполнены только обязательные поля")
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


}
