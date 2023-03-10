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
import java.time.format.DateTimeFormatter;
import java.util.List;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;


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
    @Step
    public void checkUsersAndIdStep(){
        List<UserData> users = given()
                .spec(requestSpecification)
                .when()
                .get(""+"/api/users?page=2")
                .then().spec(responseSpecification).log().all()
                .extract().body().jsonPath().getList("first_name",UserData.class);
    }

    @Test
    public void RegistrationUser(){
        String requestBody = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"pisto\"}";
        Response response = given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .post("/api/users");
        response.then().statusCode(201).log().all()
                .extract().body().jsonPath().getList("first_name",UserData.class);
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
