package model;

import static factory.DriverFactory.*;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import maps.MenuMaps;
import pages.BasePage;

public class BaseModel {
    MenuMaps menuMaps = new MenuMaps();
    BasePage basePage = new BasePage();

    @Dado("que  estou na aba de formulários")
    public void queEstouNaAbaDeFormulários() {
        killDriver();
        MobileElement element =  menuMaps.formulario();
        basePage.clickByElement(element);
    }

    @Então("finalizo a sessão")
    public void finalizoASessão() {
        killDriver();
    }


}
