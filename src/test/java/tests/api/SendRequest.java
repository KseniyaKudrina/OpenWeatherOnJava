package tests.api;

import api_store.GetUsers;
import api_store.SendRequest_CreateNewUserRequest;
import api_store.SendRequest_CreateNewUserResponse;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static api_Reqres_in.Specifications.responseSpecificationAndHeader;
import static api_Reqres_in.Specifications.responseSpecificationUnique;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

public class SendRequest {
    private final static String URL = "https://send-request.me";
    @Test
    //POST "Добавление нового пользователя/все поля заполнены"
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
    //POST "Добавление нового пользователя/заполнены только обязательные поля"
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
    //POST Добавление нового пользователя с пустыми полями /проверка 422 кода"
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
    @Test
    // GET просмотр пользователей, лимит по умолчанию = 3
    public void testGetUserList(){
        responseSpecificationAndHeader(200);

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/api/users/")
                .then()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<GetUsers> list = jsonPath.getList("data", GetUsers.class);
        int count = list.size();

        Assert.assertEquals(count, 3);

        List<String>newList = list.stream().map(GetUsers::getLast_name).collect(Collectors.toList());

        Assert.assertNotNull(newList);
    }
    @Test
    // GET запрос с ошибкой limit и ofset текстовое значение
    public void testGetUserListValidationError(){
        responseSpecificationAndHeader(422);

        given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/api/users/?limit=mvmncv&offset=nvnnbngnb")
                .then()
                .and().body("detail.msg[0]", is ("value is not a valid integer"));
    }



}
