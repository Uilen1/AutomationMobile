package hook;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static factory.DriverFactory.killDriver;

public class Hook {

    private static Logger logger = LoggerFactory.getLogger(Hook.class);

    @After
    public static void afterAllTests(Scenario scenario){
        logger.info("Status do Scenario de teste: {}", scenario.getStatus());
        logger.info("Eliminando o driver da sessão");
        killDriver();
    }
}
