package Pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.*;


public class ProductPage {
    public String BUY_BUTTON = "//span[contains(@class,'buy-button__label')]";
    public String MODAL_CONTENT ="//div[contains(@class,'modal__content')]";

    @Step("clickBuyButton")
    public ProductPage clickBuyButton(String button){
        $$x(BUY_BUTTON).findBy(Condition.text(button)).click();
        return this;
    }
    @Step("modalVisibiliti")
    public ProductPage modalVisibiliti(){
        $x(MODAL_CONTENT).should(Condition.appear);
        return this;
    }
}
