package com.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        tags= {"@pickup"},
        glue = "stepdefs",
        features = "classpath:features/"
)
public class RunTest {
}
