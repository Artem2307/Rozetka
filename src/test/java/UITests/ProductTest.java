package UITests;

import com.codeborne.selenide.junit5.TextReportExtension;
import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;


@DisplayName("Product")
@ExtendWith(TextReportExtension.class)
@Feature("Products")
public class ProductTest extends BaseTest {

    @Test
    @Story("BuyProduct")
    @Description("BuyProduct")
    @Attachment
    public void BuyProduct(){
        searchPage.search("Iphone 13")
                .clickProduct("Apple iPhone 13 128GB Starlight");
        productPage.clickBuyButton()
                .modalVisibiliti();
    }

    @Test
    @Story("ProductSearch")
    @Description("ProductSearch")
    @Attachment
    public void ProductSearch() {
        Assert.assertTrue(searchPage.search("Iphone 13").getFirstProductName().contains("13"));
        Assert.assertTrue(searchPage.search("Iphone 12").getFirstProductName().contains("12"));
    }
}
