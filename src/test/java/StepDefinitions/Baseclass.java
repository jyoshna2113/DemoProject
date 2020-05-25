package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageClasses.Login;
import PageClasses.RegisterPage;
import Utilities.ExtentreportListner;

import org.apache.commons.io.FileUtils;



public class Baseclass {
	
	public static WebDriver driver;
	public static Login l;
	public static RegisterPage r;
	public static ExtentreportListner report;
	public static Logger log;
	
	
	
	public Properties configpro;
	
	public static String randomemailid()
	{
		String emailid=RandomStringUtils.randomAlphabetic(5);
		return emailid;
	}
	
    public String captureScreenshot() throws IOException
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	String reporterName="Screenshot-"+timeStamp+".png";
    	String path=System.getProperty("user.dir")+"/Screenshots/"+reporterName;
    	File target=new File(path);
    	
    	FileUtils.copyFile(source, target);
   return path;
}


}
