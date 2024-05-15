package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/Login",
        glue = "checkout",
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class TestRunner {
}
