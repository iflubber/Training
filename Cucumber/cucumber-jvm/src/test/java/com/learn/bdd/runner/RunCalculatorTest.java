package com.learn.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json", "junit:target/cucumber/cucumber.xml" },
        tags = {"@add"},//{"~@minus"}//{"@add,@minus"}//{"@add,~@minus"}
        glue = "com.learn.bdd.steps",
//        features = {"classpath:cucumber/calculator.feature"}
        features = {"classpath:cucumber/"} //run all feature files
//        ,dryRun = true //just checks if all the steps in the feature file have got step definitions; no execution
		,monochrome = true	
)
public class RunCalculatorTest {
}
