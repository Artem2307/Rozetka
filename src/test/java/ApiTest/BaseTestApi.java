package ApiTest;

import ApiUsers.UserData;
import Settings.RestAssuredSetting;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;


import java.util.List;


import static io.restassured.RestAssured.given;

@DisplayName("API")
@ExtendWith(TextReportExtension.class)
@Feature("API")
public class BaseTestApi extends RestAssuredSetting {
    @Before
    public void BeforeTestApi(){
    }

    @Test
    @Story("Registration")
    @Description("Registration")
    @Attachment
    public void checkUsersAndIdTest(){
        checkUsersAndIdStep();
    }
    @Step
    public void checkUsersAndIdStep(){
        List<UserData> users = given()
                .spec(requestSpecification)
                .when()
                .get(""+"users?page=2")
                .then().spec(responseSpecification).log().all()
                .extract().body().jsonPath().getList("first_name",UserData.class);
    }
}
