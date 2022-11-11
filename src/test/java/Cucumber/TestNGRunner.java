package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber",glue="StepDefinition",monochrome=true,tags="@Regression",
plugin= {"html:target/Cucumber.html"})

public class TestNGRunner extends AbstractTestNGCucumberTests {
	
	}
