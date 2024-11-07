package orgOrangeHrmRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",                     // Path to the feature files
        glue = {"LoginPageStepDefinition"},                          // Package containing step definitions
        plugin = {
                "pretty",                               // Prints Gherkin steps in console output
                "html:target/cucumber-reports.html",    // Generates an HTML report
                "json:target/cucumber.json"             // Generates a JSON report for additional reporting tools
        },
        monochrome = true,                              // For readable console output
        tags = "@LoginTests"                            // Optional: Run specific tagged scenarios if needed
)



public class TestRunner extends AbstractTestNGCucumberTests {

   @Override
  @DataProvider(parallel = true)  // Enables parallel execution if needed
  public Object[][] scenarios() {
        return super.scenarios();
    }
}
