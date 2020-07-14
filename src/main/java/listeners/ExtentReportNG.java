package listeners;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class ExtentReportNG implements IReporter   {

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		
		for(ISuite suite:suites)  // ISuite contains all the execution details of Suites in TestNG
		{
			
			System.out.println("Suite :"+ suite.getName());
			Map<String,ISuiteResult> results = suite.getResults();  // This method returns all the execution details of Tests
			System.out.println("Suite :"+ suite.getName());
			 for(Map.Entry<String, ISuiteResult> temp:results.entrySet())
			 {
				 System.out.println(temp.getKey()+" : "+temp.getValue());
				 				 
		     }
			
			for (ISuiteResult r : results.values()) {
				System.out.println(r.getTestContext().getName());
				System.out.println(r.getTestContext().getPassedTests());
				actualResult(r.getTestContext().getPassedTests());
				System.out.println(r.getTestContext().getFailedTests());
				actualResult(r.getTestContext().getFailedTests());
			}
		}
			
			
		
	}
	
	public void actualResult(IResultMap rm)
	{
		for(ITestResult temp:rm.getAllResults()) 
		{
			System.out.println(temp.getMethod().getMethodName()); //extracting Method names
		}
		
	
		
	}

}
