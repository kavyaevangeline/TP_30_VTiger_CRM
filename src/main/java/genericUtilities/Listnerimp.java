package genericUtilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listnerimp extends BaseClass implements ITestListener {

	public static ThreadLocal<ExtentTest> testthread = new ThreadLocal<>();
	public ExtentReports report;
	public ExtentSparkReporter htmlreport;

	@Override
	public void onTestStart(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		ExtentTest test = report.createTest(methodname);
		testthread.set(test);
		testthread.get().log(Status.INFO, methodname+"===>Execution has started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		testthread.get().log(Status.PASS, "<b>"+methodname+"Execution was Successful</b>");	//<b> </b> ---- bold text format
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String time = jLibs.sysDate();//.replace(" ", "-").replace(":", "-");
		try {
			TakesScreenshot ts = (TakesScreenshot)wdriver.get();
			File source = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(".\\screenshot\\" + methodName +time+ ".png");

			FileUtils.copyFile(source, dest);
			String path = dest.getAbsolutePath();

			testthread.get().addScreenCaptureFromPath(path);
			testthread.get().log(Status.FAIL, "<i>"+methodName+"Execution failed</i>");	//<i> </i> --- italic text format
			testthread.get().log(Status.FAIL, result.getThrowable());
		} catch (Exception e) {
			e.printStackTrace();
			}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		testthread.get().log(Status.WARNING, "<i>"+methodname+" execution skipped </i>");
	}

	@Override
	public void onStart(ITestContext context) {

		String time = jLibs.sysDate();//.replace(" ", "-").replace(":", "-");
		htmlreport = new ExtentSparkReporter("./ExtentReport/report_" + time + ".html");
		htmlreport.config().setDocumentTitle("Report");
		htmlreport.config().setReportName("VTiger CRM Reports");
		htmlreport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		
		
		report.setSystemInfo("os", "windows10");
		report.setSystemInfo("browser", "edge");
		report.setSystemInfo("base_url", "http://localhost:8888/");
		report.setSystemInfo("reporter", "Kavya G");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
