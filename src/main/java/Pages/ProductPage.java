package Pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.*;


public class ProductPage {
    public String BUY_BUTTON = "//button[contains(@class,'buy-button button button--with-icon button--green button--medium buy-button--tile ng-star-inserted')]";
    public String MODAL_CONTENT ="//div[contains(@class,'modal__content')]";

    @Step("clickBuyButton")
    public ProductPage clickBuyButton(){
        $x(BUY_BUTTON).click();
        return this;
    }
    @Step("modalVisibiliti")
    public ProductPage modalVisibiliti(){
        $x(MODAL_CONTENT).should(Condition.appear);
        return this;
    }
}
