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
	public static ExtentTest test, suiteTest;
	public static File folder;
	public String testCaseName, testNodes, testDescription, category, author;

	// start testsuite
	public void createTestReport() {
		//String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		
		String date = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
	//	String date1 = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
		folder = new File(".\\reports\\" + date);
		if (!folder.exists()) {
			folder.mkdir();
		}
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(new File(folder + "\\result.html"));
		htmlReporter.setAppendExisting(true);
		extent.attachReporter(htmlReporter);
	}

	// create test module
	public ExtentTest createTestcaseEntry(String testcase, String testDescription, String author, String category) {
		suiteTest = extent.createTest(testcase, testDescription);
		
		suiteTest.assignAuthor(author); 
		suiteTest.assignCategory(category);
		 
		return suiteTest;
	}

	// create test case or node
	public ExtentTest startIteration(String testNodes) {
		test = suiteTest.createNode(testNodes);
		return test;
	}

	public abstract long takeSnap();

	public void reportStep(String step, String status, boolean snapshot) {
		long snapNumber = takeSnap();
		MediaEntityModelProvider snap = null;
		if (snapshot && !status.equalsIgnoreCase("info")) {
			try {
			//	snap = MediaEntityBuilder.createScreenCaptureFromPath("./../../" + folder + "/" + snapNumber + ".png").build();
				snap = MediaEntityBuilder.createScreenCaptureFromPath(snapNumber + ".png").build();
			
			} catch (IOException e) {
			}
		}
		if (status.equalsIgnoreCase("PASS")) {

			test.log(Status.PASS, step, snap);
		} else if (status.equalsIgnoreCase("FAIL")) {
			test.log(Status.FAIL, step, snap);
		} else if (status.equalsIgnoreCase("WARNING")) {
			test.log(Status.WARNING, step, snap);
		} else if (status.equalsIgnoreCase("INFO")) {
			test.log(Status.INFO, step, snap);
		}
	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}
	
	//publish report
	public void publishReport() {
		extent.flush();
	}

}
