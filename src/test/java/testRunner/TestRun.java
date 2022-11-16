package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/Login.feature",
		glue="stepDefinition",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-html-report.html","json:target/cucumber-json-report.json"}
		)
public class TestRun {

}
