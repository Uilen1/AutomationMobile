package maps;

import static factory.DriverFactory.*;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class MenuMaps {


    public MobileElement formulario(){
        return getDriver().findElement(By.xpath("//*[@text='Formulário']"));
    }
}
