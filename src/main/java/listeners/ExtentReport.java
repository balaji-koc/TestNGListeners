package listeners;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.*;
public class ExtentReport implements IReporter {

	
	 //ExtentX  reports;
	 public ExtentReports extent;
	 public ExtentHtmlReporter htmlReporter;
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		init();
	 for(ISuite suite:suites)
	 {		
		 Map<String, ISuiteResult> tests = suite.getResults();
		 //List<ISuiteResult> results =  (List<ISuiteResult>) tests.values();
		   for(ISuiteResult r: tests.values())
		   {
			ITestContext context = r.getTestContext();   
			buildNodes(context.getPassedTests(), Status.PASS);
			buildNodes(context.getFailedTests(), Status.FAIL);
			buildNodes(context.getSkippedTests(),Status.SKIP);
			}
		 
		 
	 }
	 for (String s : Reporter.getOutput()) {
         extent.setTestRunnerOutput(s);
     }
     
     extent.flush();
			
	}
	
	public void buildNodes(IResultMap result_map, Status status)
	{
		ExtentTest test; 
		if(result_map.size()>0)
		{
			for(ITestResult test_result :result_map.getAllResults())
			{
				test = extent.createTest(test_result.getMethod().getMethodName());
				System.out.println(test_result.getMethod().getMethodName());
				if (test_result.getThrowable() != null) {
                    test.log(status, test_result.getThrowable());
                }
                else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
			}
			
		}
	}
	
	public void init()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/extent_report.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
        
        System.out.println("File created method executed...... ");
		
	}


}
