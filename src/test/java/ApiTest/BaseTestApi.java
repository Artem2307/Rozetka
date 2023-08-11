package ApiTest;

import ApiUsers.UserData;
import Settings.RestAssuredSetting;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;


import static io.restassured.RestAssured.given;



@RunWith(JUnit4.class)
@ExtendWith(TextReportExtension.class)
@DisplayName("getUsersFalse")
@Feature("getUsersFalse")

public class BaseTestApi extends RestAssuredSetting {
    @Test
    @Story("getUsersFalse")
    @Description("getUsersFalse")
    @Attachment
    public void checkUsersAndIdTest(){
        checkUsersAndIdStep();
    }
    @Test
    public void checkUsersAndIdStep(){
        UserData user = new UserData(1,"sadasd","Artem","SDsDd");
        List<UserData> users = given()
                .spec(requestSpecification)
                .when()
                .get(""+"/api/users?page=2")
                .then().spec(responseSpecification).log().all()
                .extract().body().jsonPath().getList("first_name",UserData.class);
    }

    @Test
    public void SetMessage(){
        String requestBody = "{\"name\": \"Artem_Prabduik\", \"email\": \"pravdyk1@gmail.com\",\"message\": \"https://docs.google.com/document/d/1b-Rf5NSp9SD6awi98jXxTz10vZODwNfjokNH0vhCn1A/edit?usp=sharing\"}";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://api.byteplex.info/api/test/contact/");
        response.then().statusCode(201);
    }

    @Test
    public void testUserLogin() {
        String requestBody = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"pisto\"}";

        Response response = given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .put("/api/users/2");

        response.then().statusCode(200).log().all()
                .extract().body().jsonPath().getList("first_name",UserData.class);
    }

    @Test
    public void testUserDelete() {
        String requestBody = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"pisto\"}";
        LocalDateTime now = LocalDateTime.now();
        Response response = given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .delete("/api/users/2");

        response.then().statusCode(204);
    }
}
