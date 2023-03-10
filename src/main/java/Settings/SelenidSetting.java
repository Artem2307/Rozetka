package Settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public class SelenidSetting {
    PropertyReader properties = new PropertyReader();
    public  void setting(){
        com.codeborne.selenide.Configuration.browser = "chrome";
        com.codeborne.selenide.Configuration.driverManagerEnabled = true;
        Configuration.baseUrl = properties.getPropValues("mainUrl");
        Configuration.browserSize ="1920x1080";
        Selenide.open("");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true)
                .savePageSource(true));
    }

}
