package UITests;


import Pages.HomePageElements;
import Pages.ProductPage;
import Pages.SearchPage;

import Settings.PropertyReader;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BaseTest {
    HomePageElements homePageElements = new HomePageElements();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    PropertyReader propertyReader = new PropertyReader();






    @After
    @Step("Close URL")
    public void tearDown(){
        Selenide.close();
        System.out.println("Finish");
    }




}
