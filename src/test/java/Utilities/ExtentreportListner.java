package Utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentreportListner extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart()
	{
		String timestamp=new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date());
		String reporterName="My_Report-"+timestamp+".html";
		
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reporterName);
	 //   htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		htmlreporter.config().setDocumentTitle("Automation Testing");
		htmlreporter.config().setReportName("Functional Testing");
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname", "Localhost");
		extent.setSystemInfo("Os", "windows");
		extent.setSystemInfo("Reportername", "jyoshna");
	}
	
	public void onTestSuccess(ITestResult tr)
	{
	    test=extent.createTest(tr.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFail(ITestResult tr)
	{
	    test=extent.createTest(tr.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f=new File(screenshotpath);
		
		if(f.exists())
		{
			try {
				test.fail("Screenshot is below:" +test.addScreenCaptureFromPath(screenshotpath));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public void onTestSkipped(ITestResult tr)
	{
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}
	
	public void endReport()
	{
		extent.flush();
	}

	

}
