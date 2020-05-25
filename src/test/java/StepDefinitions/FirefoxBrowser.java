package StepDefinitions;


import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.Given;
import io.cucumber.java.en.When;

public class FirefoxBrowser extends Baseclass {
	


@Given("^user will launch Firefox Browser$")
public void user_will_launch_Firefox_Browser() throws Throwable {
	System.setProperty("webdriver.ie.driver","src/test/java/Drivers/IEDriverServer.exe");
	   driver=new InternetExplorerDriver();
}


@When("^customer will open url$")
public void customer_will_open_url() throws Throwable {
   driver.get("https://www.google.com/");
}

@When("^close the browser$")
public void close_the_browser() throws Throwable {
    driver.close();
}

}
