package genericUtilites;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provides implementation to ITestListeners interface of TestNG
 * @author Gayathri_93
 *
 */
public class ListenersImplementation implements ITestListener {
	
	ExtentReports report ;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---- Test Execution Started ----");
		
		//3.Add @Test to extent reports
		//ExtentTest test = report.createTest(methodName);
		test = report.createTest(methodName);
		
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---- Test PASS ----");
		
		//4. Log the PASS Status to extent Report
		test.log(Status.PASS, methodName+"---- Test PASS ----");
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---- Test FAIL ----");
		
		//5. Log the Fail Status to extent Report
		test.log(Status.FAIL,methodName+"---- Test FAIL ----" );
		
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		String screenshotName = methodName+"-"+j.getDate();
		
		try {
			String path = s.caputureScreenShot(BaseClass.sDriver, screenshotName);
			
			//6. Attach screenshot to Extent reports
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---- Test SKIP ----");
		
		//7. Log the SKIP status to extent reports 
		test.log(Status.SKIP,methodName+"---- Test SKIP ----" );
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("---- Suite Execution Started ----");
		
		//1. Extent Report Configuration
		ExtentSparkReporter rep = new ExtentSparkReporter(".\\ExtentReport\\Report- "+new JavaUtility().getDate()+".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setReportName("Vtiger execution report");
		rep.config().setTheme(Theme.DARK);
		
		//ExtentReports report = new ExtentReports();
		report = new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base platform", "Windows");
		report.setSystemInfo("Base platform", "Edge Browser");
		report.setSystemInfo("Base url", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "gayathri");
		
		
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("---- Suite Execution Finished ----");
		
		//2. Generate ExtentReport
		report.flush();
	}
	

}
