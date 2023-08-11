package ApiTest;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiClass {
    private static final String API_URL = "https://servicevisitor.backendless.app/api/services/QATest/sum";
    @Test
    public void testSumService() {
        for (int arg1 = 0; arg1 <= 10; arg1++) {
            for (int arg2 = 0; arg2 <= 10; arg2++) {
                Response response = given()
                        .param("arg1", arg1)
                        .param("arg2", arg2)
                        .when()
                        .get(API_URL);
                response.then().statusCode(200);
                int result = response.getBody().as(Integer.class);
                int expectedSum = arg1 + arg2;

                assertEquals(expectedSum, result,
                        String.format("Test Failed: %d + %d - Expected: %d, Actual: %d", arg1, arg2, expectedSum, result));
            }
        }
    }


    }


