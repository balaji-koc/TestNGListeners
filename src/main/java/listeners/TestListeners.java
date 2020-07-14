package listeners;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestListeners implements ITestListener {
	
	public ExtentHtmlReporter htmlreport;
	public ExtentReports report; 
	
	public TestListeners(List<XmlSuite> arg0, List<ISuite> suites, String outputDir)
	{
		for(ISuite suite:suites)  // ISuite contains all the execution details of Suites in TestNG
		{
			
			System.out.println("Suite :"+ suite.getName());
			Map<String,ISuiteResult> results = suite.getResults();  // This method returns all the execution details of Tests
			System.out.println("Suite :"+ suite.getName());
			 for(Map.Entry<String, ISuiteResult> temp:results.entrySet())
			 {
				 System.out.println(temp.getKey()+" : "+temp.getValue());
				 				 
		     }
		}
	}
	
	public void onTestStart(ITestResult result) {
	  System.out.println(result.getName()+" Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" Success");
		
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" Failed ");	
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" Started");
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getName()+" on Start method");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
				
		System.out.println(context.getName()+" on Finish method");
		System.out.println("Below are the Suites.." );
		//getSuites();
		System.out.println("Below are the Tests..");
		System.out.println("This is onFinish method || PASSED : " +context.getPassedTests());
		System.out.println("This is onFinish method || FAILED : " +context.getFailedTests());
		init();
		buildNodes(context.getPassedTests(), Status.PASS);	
		buildNodes(context.getFailedTests(), Status.FAIL);
		
		for (String s : Reporter.getOutput()) {
	         report.setTestRunnerOutput(s);
	     }
	     
	     report.flush();
	}
	
	public void buildNodes(IResultMap results, Status status)
	{
		ExtentTest test;
		System.out.println("Method names....");
		for(ITestNGMethod method : results.getAllMethods())
		{
			test=report.createTest(method.getMethodName());
			System.out.println(method.getMethodName());
			test.log(status, "Test " + status.toString().toLowerCase() + "ed");
			
		}
	}
	 
	public void init()
	{
		htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/My_extent_report.html");
		report = new ExtentReports();
		
		report.attachReporter(htmlreport);
		report.setReportUsesManualConfiguration(true);
		System.out.println("File created method executed...... ");
	}
	
	@AfterClass
	public void windup()
	{
		
		 System.out.println("After class method");
	}
}
