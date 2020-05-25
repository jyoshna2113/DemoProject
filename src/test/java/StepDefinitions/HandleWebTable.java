package StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.When;

public class HandleWebTable extends Baseclass {
	
ExtentTest test;
	
    @When("user opens site")
	public void user_opens_url() throws IOException {
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
	
	@When("user handles the dynamic webtable")
	public void user_handles_the_dynamic_webtable() throws IOException {
		List<WebElement> rowcount;
		List<WebElement> coloumncount;
		
	    try {
	    	
	    	rowcount = driver.findElements(By.xpath(RepositoryParser.getBrowserInfo("rowspath") ));
	    	System.out.println("no of rows--"+rowcount.size());
	    	coloumncount=driver.findElements(By.xpath(RepositoryParser.getBrowserInfo("columnspath") ));
	    	System.out.println("no of rows--"+coloumncount.size());
	    	
	    	//to get third row and fourth column text
	    	
	    	String startxpath="//*[@id=\"leftcontainer\"]/table/tbody/tr[";
	    	String endXpath="]/td[1]";
	    	
	    	
	    	for(int i=2;i<=rowcount.size();i++)
	    		
	    	{
	    		
	    		String value=driver.findElement(By.xpath(startxpath+i+endXpath)).getText();
	    		if(value.contains("Chennai Petro"))
	    		{
	    			for(int j=1;j<=5;j++) {
	    			String rowvalues=driver.findElement(By.xpath(startxpath+i+"]/td["+j+"]")).getText();
	    			System.out.println("the values of given company"+rowvalues);
	    		}
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
