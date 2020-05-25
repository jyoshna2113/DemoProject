package StepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hookstest extends Baseclass{
	
	RepositoryParser parser;
	
	
     @Before
	public void openbrowser() throws IOException
	{
    	 /*log=Logger.getLogger("Project");
    	 PropertyConfigurator.configure("Log4j.properties");*/
    	 parser = new RepositoryParser("src/test/java/Configurations/Propertyfile.properties");
		if(RepositoryParser.getBrowserInfo("headlessbrowser").equalsIgnoreCase("yes"))
		{
			System.setProperty("webdriver.chrome.driver", RepositoryParser.getBrowserInfo("chromepath"));
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			System.out.println("Headless option got selected");
		}
		else if(RepositoryParser.getBrowserInfo("browser").equalsIgnoreCase("chrome"))
		{
		System.out.println(RepositoryParser.getBrowserInfo("chromepath"));
		System.setProperty("webdriver.chrome.driver", RepositoryParser.getBrowserInfo("chromepath"));
        driver = new ChromeDriver();
	}
		else if(RepositoryParser.getBrowserInfo("browser").equalsIgnoreCase("ie"))
		{
			System.out.println(RepositoryParser.getBrowserInfo("iepath"));
			System.setProperty("webdriver.ie.driver", RepositoryParser.getBrowserInfo("iepath"));
	        driver = new InternetExplorerDriver();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        
		}
	
	}
     
     @After
     public void closebrowser()
     {
    	 driver.close();
     }
	}
