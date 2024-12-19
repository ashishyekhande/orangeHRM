package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ={"src/test/java/cucumber"},
glue = {"cucumber"},tags = "@login",
plugin = {"pretty","html:Report/cucumber.html"},
monochrome = true)
public class cucumberTestRunner extends AbstractTestNGCucumberTests
{


}
