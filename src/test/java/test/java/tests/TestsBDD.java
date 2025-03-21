package test.java.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps.APISteps",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestsBDD {

}
