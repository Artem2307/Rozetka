package ApiTest;

import ApiUsers.UserData;
import Settings.RestAssuredSetting;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import java.util.List;


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
