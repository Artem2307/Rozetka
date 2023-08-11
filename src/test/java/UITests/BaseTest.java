package UITests;


import Pages.HomePageElements;
import Pages.ProductPage;
import Pages.SearchPage;

import Pages.bot;
import Settings.PropertyReader;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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
