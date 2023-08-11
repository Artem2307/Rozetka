package Pages;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.Test;


import static com.codeborne.selenide.Selenide.*;

public class HomePageElements {

    public static String LOGIN_BUTTON = "//rz-user//button[contains(@class,'ng-star-inserted')]";
    public static String MODAL_TABDLE = "//div[@class='modal__content']";
    public static String REGISTRATION_BUTTON = "//button[contains(@class,'button--link')]";
    public static String REGISTER_BUTTON = "//button[contains(@class,'auth-modal__submit')]";
    public static String DATA_ENTRY_TABLE = "//fieldset";
    public static String ERRORS_TABLE = "//ul[contains(@class,'errors-list ng-star-inserted')]";
    public final String ERROR_MASSEGE = ("//p[contains(@class,'error-message')]");
    public static String LOGIN_PROFILE_BUTTON = "//button[contains(@class,'auth-modal__submit')]";


    @Step("registration name")
    public void registration(String name, String surname, String phone, String email, String password) {
        $x(LOGIN_BUTTON).click();
        $x(MODAL_TABDLE).should(Condition.appear, Condition.visible);
        $x(REGISTRATION_BUTTON).click();
        $x(DATA_ENTRY_TABLE).should(Condition.visible);
        $("#registerUserName").setValue(name);
        $("#registerUserSurname").setValue(surname);
        $("#registerUserPhone").setValue(phone);
        $("#registerUserEmail").setValue(email);
        $("#registerUserPassword").setValue(password);
        $x(REGISTER_BUTTON).click();
    }

    @Step("registrationError")
    public void registrationError() {
        $x(ERRORS_TABLE).should(Condition.visible);
    }

    @Step("loginError")
    public String loginError() {
        $x(ERROR_MASSEGE).should(Condition.appear);
        return $x(ERROR_MASSEGE).toString();
    }

    @Step("profileLogin")
    public void profileLogin(String phone, String password) {
        $x(LOGIN_BUTTON).click();
        $x(MODAL_TABDLE).should(Condition.appear, Condition.visible);
        $("#auth_email").setValue(phone);
        $("#auth_pass").setValue(password);
        $x(LOGIN_PROFILE_BUTTON).click();
    }
}


