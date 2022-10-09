package com.salesforce.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestcases implements IRetryAnalyzer{
	int retryCount=0;
	public boolean retry(ITestResult result) {
	
		if(retryCount<2)
		{
			retryCount++;
			return true;
		}
		return false;
	}

}
