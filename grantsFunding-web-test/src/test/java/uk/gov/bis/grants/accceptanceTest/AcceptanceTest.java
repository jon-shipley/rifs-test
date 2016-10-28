package uk.gov.bis.grants.accceptanceTest;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = { "html:target/cucumber-reports/html", "json:target/cucumber-reports/cucumber.json" }, 
		features = {"src/test/resources/features.functional/Rifs/"},glue="uk.gov.bis.grants.stepdefs",tags={"@Sprint3,@Sprint2,@Sprint1","~@ignore,@Pending"})


public class AcceptanceTest {

}
