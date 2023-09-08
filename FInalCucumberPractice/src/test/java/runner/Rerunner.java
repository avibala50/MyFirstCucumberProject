package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="@target/failed.txt",
		glue = {"step_definitions","common"},
		dryRun = false,
		monochrome = true
		
		
		)
public class Rerunner {

}
