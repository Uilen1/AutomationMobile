import static factory.DriverFactory.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@SEU_BARRIGA_APPLICATION_CT_001",
        features = "src/main/resources/features",
        glue = {"model","hook"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "summary",
                "html:target/cucumber"
        }
)
public class BaseTest {


}
