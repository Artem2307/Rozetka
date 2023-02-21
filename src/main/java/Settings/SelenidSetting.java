package Settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class SelenidSetting {
    PropertyReader properties = new PropertyReader();
    public  void setting(){
        com.codeborne.selenide.Configuration.browser = "chrome";
        com.codeborne.selenide.Configuration.driverManagerEnabled = true;
        Configuration.baseUrl = properties.getPropValues("mainUrl");
        Configuration.browserSize ="1920x1080";
        Selenide.open("");
    }

}
