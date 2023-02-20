package UITests;


import Pages.HomePageElements;
import Pages.ProductPage;
import Pages.SearchPage;

import Settings.SelenidSetting;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;



public class BaseTest {
    HomePageElements homePageElements = new HomePageElements();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    SelenidSetting selenidSetting =new SelenidSetting();


    @Before
    @Step("Open URL")
    public  void setUp() {
        selenidSetting.setting();
        Selenide.open("");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true)
                .savePageSource(true));
    }


    @After
    @Step("Close URL")
    public void tearDown(){
        Selenide.close();
        System.out.println("Finish");
    }


}
