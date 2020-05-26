package Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		features="src\\test\\java\\Features\\NewFeature.feature",
		glue= {"StepDefinitions","src/test/java/StepDefinitions/Hookstest.java"},
		dryRun=false,
		monochrome= true,
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extendreport.html"},
		tags= {"@Login"}
		
		)

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
	    Reporter.loadXMLConfig("src\\test\\java\\Configurations\\Config.xml");
	}  


}
