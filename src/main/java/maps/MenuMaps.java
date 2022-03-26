package maps;

import static factory.DriverFactory.*;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class MenuMaps {


    public MobileElement formulario(){
        return getDriver().findElement(By.xpath("//*[@text='Formulário']"));
    }
    public MobileElement elementByText(String text){
        return getDriver().findElement(By.xpath("//*[@text='"+text+"']"));
    }
    public MobileElement elementByAcessibilityId(String text){
        return getDriver().findElement(MobileBy.AccessibilityId(text));
    }
}
