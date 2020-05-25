package Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		features="src/test/java/Features/FirefoxFeature.feature",
		glue="src/test/java/StepDefinitions/FirefoxBrowser.java",
		dryRun=false,
		monochrome= true
		
		
		)


public class TestRunnerFirefox {
	
	@AfterClass
	public static void writeExtentReport() {
	    Reporter.loadXMLConfig("src\\test\\java\\Configurations\\Config.xml");
	}  


}
