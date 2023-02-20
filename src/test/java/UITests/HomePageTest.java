package UITests;



import com.codeborne.selenide.junit5.TextReportExtension;
import io.qameta.allure.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TextReportExtension.class)
@DisplayName("Users")
@Feature("UI users")

public class HomePageTest extends BaseTest {

    @Test
    @Story("Registration")
    @Description("Registration")
    @Attachment
    public void RegistrationNegative(){
        homePageElements.registration("Артем","Артем","0667643400","2345@gmail.com","12345678");
        homePageElements.registrationError();
    }

    @Test
    @Story("Login")
    @Description("Login Negative")
    @Attachment
    public void ProfileLoginNegative(){
        homePageElements.profileLogin("380666666888","123456");
        //Assert.assertTrue(homePageElements.loginError().contains("Необхідно підтвердити, що ви не робот"));
    }

    // как работать с хистори аллур (енв проперти)


}
