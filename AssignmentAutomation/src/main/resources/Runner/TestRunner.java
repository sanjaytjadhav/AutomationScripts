package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\main\\resources\\Features",
		glue={"stepDefination"},
		format ={"pretty","html:test-outout", "json:test-outout/cucumber.json", "junit:test-outout/cucumber.xml"},
		tags={"@Pass"},
		dryRun= false,
		monochrome = true
		)

public class TestRunner {

	
	
	
	
}
