package practiceCucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/practiceCucumber",
glue = "practiceCucumber",
plugin = {"pretty","html:Report/cucumberPraactice.html"},
monochrome = true)

public class testRunner extends AbstractTestNGCucumberTests {

}
