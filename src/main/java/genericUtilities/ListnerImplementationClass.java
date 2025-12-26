package genericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) 
	{
		String methodname = result.getMethod().getMethodName();
	    test=report.createTest(methodname);
		test.log(Status.INFO, methodname+"execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+"-->passed");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
        String methodName=result.getMethod().getMethodName();
		String fileName=methodName+new JavaUtils().sysDate();
		try
		{
		
		TakesScreenshot ts=(TakesScreenshot) BaseClass.wdriver.get();
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\ListenerScreenShot\\"+fileName+".png");
		
		FileUtils.copyFile(src, dst);;
		String path=dst.getAbsolutePath();
		
		test.addScreenCaptureFromPath(path);//attaching failed screenshot into extent report
		
		test.log(Status.FAIL, result.getThrowable());//this is to print the exception
		test.log(Status.FAIL, methodName+"--->failed");//this is to print the message
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+"-->skipped");
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReport\\report"+new JavaUtils().sysDate()+".html");
		htmlreport.config().setDocumentTitle("TP-30");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("VTiger");
		
	    report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("base_browser", "chrome");
		report.setSystemInfo("base_platform", "windows");
		report.setSystemInfo("base_url", "http://loclahost:8888/");
		report.setSystemInfo("ReporterName", "Kavya G");
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}

	
}
