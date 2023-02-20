package ApiTests;

import APITest.Specifications;
import APITest.UserPage;
import Settings.PropertyReader;
import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class BaseTestApi {
    UserPage userPage = new UserPage();
    PropertyReader properties = new PropertyReader();
    String baseUrl = properties.getPropValues("URL");

    @Before
    @Step("Open 'https://dummy.restapiexample.com/'")
    public void setUp(){
        Specifications.installSpec(Specifications.requestSpec(baseUrl),Specifications.responseSpec200());
    } 
}
