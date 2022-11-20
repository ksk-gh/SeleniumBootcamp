package com.salesforce.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reporter {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test, node;
	public static File folder;
	public String testCaseName, testNodes, testDescription, category, author;
	
public void createTestReport() {
	
String date=new SimpleDateFormat("dd-MM-yyyy").format(new Date());	

folder=new File(".\\reports\\"+date);

if(!folder.exists()) {
	folder.mkdir();
}
extent= new ExtentReports();
htmlReporter = new ExtentHtmlReporter(new File(folder+"\\index.html"));
htmlReporter.setAppendExisting(true);
extent.attachReporter(htmlReporter);
}


public ExtentTest createTestcaseEntry(String testcase,String testDescription,String author,String category) {
	
test=extent.createTest(testcase,testDescription);
test.assignAuthor(author);
test.assignCategory(category);
return test;

}

public ExtentTest startIteration(String node) {
	test.createNode(node);
	return test;
}
	

public abstract long takeSnap();


public void reportStep(String step,String status) {
	long snapNumber=takeSnap();
	MediaEntityModelProvider snap=null;
	try {
		snap=MediaEntityBuilder.createScreenCaptureFromPath(folder+"\\"+snapNumber+".png").build();
	} catch (IOException e) {
	}
	if(status.equalsIgnoreCase("PASS")) {
		
		test.log(Status.PASS,step,snap);
	}else if(status.equalsIgnoreCase("FAIL")) {
		test.log(Status.FAIL,step,snap);
	}else if(status.equalsIgnoreCase("WARNING")) {
		test.log(Status.WARNING,step,snap);
	}
	else if(status.equalsIgnoreCase("INFO")) {
		test.log(Status.INFO,step,snap);
	}
}

public void publishReport() {
	extent.flush();
}

}
