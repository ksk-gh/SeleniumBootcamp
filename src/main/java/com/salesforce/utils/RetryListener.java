package com.salesforce.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		annotation.setRetryAnalyzer(com.salesforce.utils.RetryFailedTestcases.class);
		
		//System.out.println(testClass+" Inside Retry "+testConstructor+ " Inside Retry "+testMethod);
	}
}