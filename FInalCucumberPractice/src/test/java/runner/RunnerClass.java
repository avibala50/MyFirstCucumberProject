package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\aviba\\eclipse-workspace\\FInalCucumberPractice\\src\\test\\resources\\Features",
		glue = {"step_definitions","common"},
		dryRun = false,
		monochrome = true,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed.txt","html:targets/report.html"}
		
		
		)
public class RunnerClass {

}
