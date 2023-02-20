package ApiTests;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.Test;




public class RequestTest extends BaseTestApi {


    @Test
    @Story("getUsersFalse")
    @Description("getUsersFalse")
    @Attachment
    public void getUsersFalse(){
        userPage.getUsersFalse();
    }
    @Test
    @Story("getUsersTrue")
    @Description("getUsersTrue")
    @Attachment
    public void getUsersTrue(){
        userPage.getUsersTrue();
    }
    // реквест и ассерт  спецификации
}
