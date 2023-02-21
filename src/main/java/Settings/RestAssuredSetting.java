package Settings;

import com.codeborne.selenide.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class RestAssuredSetting {
    PropertyReader properties = new PropertyReader();
    public String URL = Configuration.baseUrl = properties.getPropValues("mainUrlApi");

    public RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(URL)
            .build().contentType(ContentType.JSON);
    public ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(lessThan(5000L))
            .build();
}
