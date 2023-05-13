package api_Reqres_in;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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


    }






}

