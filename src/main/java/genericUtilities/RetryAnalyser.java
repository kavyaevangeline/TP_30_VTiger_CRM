package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{

	int intialCount=0;
	int retryLimit=4;

	@Override
	public boolean retry(ITestResult result) {
		if(intialCount<retryLimit) {
			intialCount++;
			return true;
		}
		
		return false;
	}
	
	
}
