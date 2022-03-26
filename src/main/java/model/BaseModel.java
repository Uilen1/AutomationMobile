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
    public void queEstouNaAbaDeFormulários() throws InterruptedException {
//        killDriver();
//        MobileElement element =  menuMaps.formulario();
//        basePage.clickByElement(element);
//        MobileElement element2 =  menuMaps.elementByAcessibilityId("slid");
//        basePage.clickInSeekBar(element2,0.5,50);
//        MobileElement element = menuMaps.elementByText("Cliques");
//        basePage.clickByElement(element);
//        MobileElement element2 = menuMaps.elementByText("Clique Longo");
//        basePage.longClickElement(element2);
//        MobileElement element = menuMaps.elementByText("Alertas");
//        basePage.clickByElement(element);
//        MobileElement element2 = menuMaps.elementByText("ALERTA SIMPLES");
//        basePage.clickByElement(element2);
//        basePage.tapByCoordinates(100,200);
    }

    @Então("finalizo a sessão")
    public void finalizoASessão() {
        killDriver();
    }

}
