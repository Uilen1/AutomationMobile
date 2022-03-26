package pages;

import static factory.DriverFactory.*;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.ActionOptions;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.interactions.touch.TouchActions;
import utils.Utils;

public class BasePage extends Utils {
    public void clickByElement(MobileElement element){
        waitVisibilityOfElement(element);
        element.click();
    }
    public void longClickElement(MobileElement mobileElement){
        waitVisibilityOfElement(mobileElement);
        new TouchAction(getDriver()).
                longPress(longPressOptions().withElement(element(mobileElement))).
                perform();
    }

    public void clickInSeekBar(MobileElement element,Double porcentage, int delta){
        waitVisibilityOfElement(element);
        int y = element.getLocation().y + (element.getSize().height)/2;
        int xInicial = element.getLocation().x + delta;
        int x = (int) (xInicial + porcentage*(element.getSize().width - 2*delta));
        tapByCoordinates(x,y);
    }


    public void tapByCoordinates(int x, int y){
        new TouchAction<>(getDriver()).tap(PointOption.point(x,y)).perform();
    }

    public void writeByElement (MobileElement element, String text){
        waitVisibilityOfElement(element);
        element.sendKeys(text);
    }

    public String getTextOfElement (MobileElement element){
        waitVisibilityOfElement(element);
        return element.getText();
    }


}
