package runner;

import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/java/features"},
        glue = {"src/main/java/stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/cucumber.json"
        }
)
public class TestRunner {
}
