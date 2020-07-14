package listeners;

import java.util.List;
import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class MyExtentReportNG implements ITestListener, ISuiteListener   {
    ExtentHtmlReporter htmlreport;
	ExtentReports report;
	ExtentTest test;
	public void onStart(ISuite suite) {//  ISuite Methods
	htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/MyExtentNG.html");
	report=new ExtentReports();
	report.attachReporter(htmlreport);
	report.setReportUsesManualConfiguration(true);
	System.out.println("onStart Method of ISuiteListener ");
	}

	public void onFinish(ISuite suite) {  // ISuite Methods
		
		report.flush();
		System.out.println("onFinish Method of ISuiteListener ");
		
	}

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		for (String group : result.getMethod().getGroups())
            test.assignCategory(group);

		System.out.println("@@  on Test start :"+result.getMethod().getMethodName()+" @@ ");
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println(result.getMethod().getMethodName()+" "+ Status.PASS.toString()+"ed ##");
		test.log(Status.PASS, result.getMethod().getMethodName()+" "+ Status.PASS.toString());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" "+ Status.FAIL.toString()+"ed ##");
		test.log(Status.FAIL, result.getMethod().getMethodName()+" "+ Status.FAIL.toString());
		test.log(Status.FAIL, result.getThrowable());  //  LOGs EXCEPTION messages to report.
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println(result.getMethod().getMethodName()+" "+ Status.SKIP.toString()+"ed ##");
		test.log(Status.FAIL, result.getMethod().getMethodName()+" "+ Status.SKIP.toString());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onStart Method of ITestListener ");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onFinish Method of ITestListener ");
		for (String s : Reporter.getOutput()) {
	         report.setTestRunnerOutput(s);
	         System.out.println("Rpt : "+s);
	     }
	}

	

}
