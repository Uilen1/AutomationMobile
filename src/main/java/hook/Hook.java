package hook;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

import static factory.DriverFactory.getDriver;
import static factory.DriverFactory.killDriver;

public class Hook {

    private static Logger logger = LoggerFactory.getLogger(Hook.class);
    Utils utils = new Utils();

    @AfterAll
    public static void after_all(){
        logger.info("Eliminando o driver da sessão");
        killDriver();
    }

    @After
    public void reset_app(){
        logger.info("Resetando o APP para a execução do teste");
        getDriver().resetApp();
    }
    @AfterStep
    public void getScreenShot() throws Exception {
        utils.screenShot();
    }
}
