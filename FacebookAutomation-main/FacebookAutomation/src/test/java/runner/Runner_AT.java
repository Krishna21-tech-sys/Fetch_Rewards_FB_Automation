package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, features = "src/test/resource/Features", glue = { "stepDefinitions",
		"runner" }, tags = { "@regression" }, plugin = { "html:target/cucumber-report/Regression",
				"json:target/cucumber.json", "rerun:target/rerun/failed_scenarios.txt" })

public class Runner_AT {
}
