package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageClasses.Login;
import PageClasses.RegisterPage;

import cucumber.api.DataTable;
//import io.cucumber.core.logging.LoggerFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Firstproject extends Baseclass {

	String email;
	public static Logger log;

	public ExtentTest test;
	public ExtentReports report;


	@Given("user launch Chrome Browser")
	public void user_launch_Chrome_Browser() throws IOException {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reporterName = "ExtentReportResults-" + timeStamp + ".html";
		report = new ExtentReports(System.getProperty("user.dir") + "\\target\\" + reporterName);
		test = report.startTest("Automation Testcases");
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		l = new Login(driver);
		r = new RegisterPage(driver);

	}

	@When("user opens url")
	public void user_open_url() throws IOException {
		try {

			driver.get(RepositoryParser.getBrowserInfo("url"));
			test.log(LogStatus.PASS, "url is launched successfully" + test.addScreenCapture(captureScreenshot()));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "url is not opened" + e.getMessage() + test.addScreenCapture(captureScreenshot()));
		}
	}

	@Then("user clicks on insurance project")
	public void user_clicks_on_insurance_project() throws IOException {
		try {

			Actions a = new Actions(driver);
			a.moveToElement(Login.insurancelink).build().perform();
			   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			l.insurancelnk();
			
			test.log(LogStatus.PASS, "insurance project link got opened" + test.addScreenCapture(captureScreenshot()));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "insurance project link not got opened" + e.getMessage()
					+ test.addScreenCapture(captureScreenshot()));
		}

	}

	@Then("verify the page title")
	public void page_title_should_be() throws IOException {
		try {

			Assert.assertEquals(RepositoryParser.getBrowserInfo("pagetitle"), driver.getTitle());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            test.log(LogStatus.PASS, "page got verified" + test.addScreenCapture(captureScreenshot()));
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"pagetitle is not verified" + e.getMessage() + test.addScreenCapture(captureScreenshot()));
		}
	}

	@Then("click on Register button")
	public void click_on_Register_button() throws IOException {
		try {

			l.RegisterButton();
			test.log(LogStatus.PASS, "Register button opened" + test.addScreenCapture(captureScreenshot()));
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"register button is not clicked" + e.getMessage() + test.addScreenCapture(captureScreenshot()));
		}
	}

	@Then("user enter details")
	public void user_enter_details(DataTable crendials) throws IOException {

		try {

			List<List<String>> l = crendials.raw();

			r.titledropdown(l.get(0).get(0));
			r.setFirstName(l.get(0).get(1));
			r.setsurName(l.get(0).get(2));
			r.setMobileNumber(l.get(0).get(3));
			r.setDateofBirth(l.get(0).get(4), l.get(0).get(5), l.get(0).get(6));
			r.setRadiobtn2();

			r.setperiod(l.get(0).get(7));
			r.setoccupation(l.get(0).get(8));

			r.setAddress(l.get(0).get(9));
			r.setCity(l.get(0).get(10));
			r.setCountry(l.get(0).get(11));

			r.setpostcode(l.get(0).get(12));
			email = randomemailid() + "@gamil.com";
			r.setEmail(email);
			r.setpassword(l.get(0).get(13));
			r.setCpassword(l.get(0).get(14));
			r.submitbutton();
			test.log(LogStatus.PASS, "Detils are enetered succesfully" + test.addScreenCapture(captureScreenshot()));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Detils are not enetered succesfully" + e.getMessage()
					+ test.addScreenCapture(captureScreenshot()));
		}
	}


	@When("user enter login details")
	public void user_enter_login_details() throws IOException {
		try {
			r.setEmail(email);
			r.setpassword1(RepositoryParser.getBrowserInfo("password"));
			test.log(LogStatus.PASS,
					"user enetered login detils succesfully" + test.addScreenCapture(captureScreenshot()));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "user not entered login detils succesfully" + e.getMessage()
					+ test.addScreenCapture(captureScreenshot()));
		}
	}

	@Then("user click on login button")
	public void user_click_on_login_button() throws IOException {
		try {

			r.submitbutton();
			test.log(LogStatus.PASS, "login is successful" + test.addScreenCapture(captureScreenshot()));
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Login is not Successfull" + e.getMessage() + test.addScreenCapture(captureScreenshot()));
		}
	}

	@And("Close the browser")
	public void close_the_browser() {

		//driver.close();
		report.endTest(test);
		report.flush();

	}
	
	
	@When("^user opens site$")
	public void user_opens_site() throws Throwable {
		 try {
			 driver.get(RepositoryParser.getBrowserInfo("site")); 
			 test.log(LogStatus.PASS, "url is opened successfully"+test.addScreenCapture(captureScreenshot()));
		  }
		  catch(Exception e)
		  {
			  System.out.println("Test case got failed");
			  test.log(LogStatus.FAIL,
						"Browsergot launched" + e.getMessage() + test.addScreenCapture(captureScreenshot()));
		  }
	}

	@When("^user handles the dynamic webtable$")
	public void user_handles_the_dynamic_webtable() throws Throwable {
		List<WebElement> rowcount;
		List<WebElement> coloumncount;
		
	    try {
	    	
	    	rowcount = driver.findElements(By.xpath(RepositoryParser.getBrowserInfo("rowspath") ));
	    	System.out.println("no of rows--"+rowcount.size());
	    	coloumncount=driver.findElements(By.xpath(RepositoryParser.getBrowserInfo("columnspath") ));
	    	System.out.println("no of coloumns--"+coloumncount.size());
	    	
	        String startxpath="//*[@id=\"leftcontainer\"]/table/tbody/tr[";
	    	String endXpath="]/td[1]"; 	
	    	
	    	for(int i=2;i<=rowcount.size();i++)
	    	{
	    		String value=driver.findElement(By.xpath(startxpath+i+endXpath)).getText();
	    		if(value.contains("Chennai Petro."))
	    		{
	    			String rowvalues=driver.findElement(By.xpath(startxpath+i+"]")).getText();
	    			System.out.println("the values of given company"+rowvalues);
	    		}
	    	}
	    	test.log(LogStatus.PASS, "details are captured "+test.addScreenCapture(captureScreenshot()));
	    	
	    }
	    catch(Exception e)
		  {
			  System.out.println("Test case got failed");
			  test.log(LogStatus.FAIL,
						"Browsergot launched" + e.getMessage() + test.addScreenCapture(captureScreenshot()));
		  }
}
}
