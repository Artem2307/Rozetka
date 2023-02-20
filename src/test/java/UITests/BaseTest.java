package UITests;


import Pages.HomePageElements;
import Pages.ProductPage;
import Pages.SearchPage;

import Settings.SelenidSetting;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
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
    }


    @After
    @Step("Close URL")
    public void tearDown(){
        Selenide.close();
        System.out.println("Finish");
    }


}
