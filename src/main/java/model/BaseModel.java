package model;

import static factory.DriverFactory.*;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import maps.MenuMaps;
import org.openqa.selenium.By;
import pages.BasePage;

public class BaseModel {
    MenuMaps menuMaps = new MenuMaps();
    BasePage basePage = new BasePage();

    @Dado("que  estou na aba de formulários")
    public void queEstouNaAbaDeFormulários() throws InterruptedException {
//        MobileElement element =  menuMaps.formulario();
//        basePage.clickByElement(element);

        MobileElement element2 = menuMaps.elementByText("SeuBarriga Híbrido");
        basePage.clickByElement(element2);
        basePage.changeContext("Web");
    }

    @Então("finalizo a sessão")
    public void finalizoASessão() {
        killDriver();
    }

}
