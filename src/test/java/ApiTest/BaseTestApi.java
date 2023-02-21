package ApiTest;

import ApiUsers.UserData;
import Settings.RestAssuredSetting;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.Before;
import org.junit.jupiter.api.Test;


import java.util.List;


import static io.restassured.RestAssured.given;

public class BaseTestApi extends RestAssuredSetting {
    @Before
    public void BeforeTestApi(){
    }

    @Test
    @Story("checkUsersAndIdTest")
    @Description("checkUsersAndIdTest")
    @Attachment
    public void checkUsersAndIdTest(){
        List<UserData> users = given()
                .spec(requestSpecification)
                .when()
                .get(""+"users?page=2")
                .then().spec(responseSpecification).log().all()
                .extract().body().jsonPath().getList("first_name",UserData.class);
    }
}
