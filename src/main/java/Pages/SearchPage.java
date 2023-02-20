package Pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage {
    public final ElementsCollection Products = $$x("//span[@class='goods-tile__title']");
    public final SelenideElement textBoxinput = $(By.xpath("//input[@type='text']"));
    public String PRODUCT_MODAL_RIGHT ="//div[contains(@class,'product-about__right')]";


    @Step("getFirstProductName")
    public String getFirstProductName() {
        return Products.first().toString();
    }
    @Step("search")
    public SearchPage search(String searchString) {
        textBoxinput.setValue(searchString);
        textBoxinput.pressEnter();
        textBoxinput.should(Condition.visible);
        return this;
     }

    @Step("clickProduct")
    public SearchPage clickProduct(String name){
        Products.findBy(Condition.text(name)).click();
        $x(PRODUCT_MODAL_RIGHT).should(Condition.appear);
        return this;
    }


}
