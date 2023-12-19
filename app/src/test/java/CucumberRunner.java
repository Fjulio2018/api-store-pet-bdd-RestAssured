

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "not @wip and not @quarentena",
        glue = "bdd.automation.api.steps",
        features = {"src/test/resources/features"})


public class CucumberRunner {
}
