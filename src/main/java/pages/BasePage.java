package pages;

import io.appium.java_client.MobileElement;
import maps.MenuMaps;

public class BasePage {
    public void clickByElement(MobileElement element){
        element.click();
    }
}
