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
		//folder = new File(".\\reports\\" + date);
		
	//	folder = new File("./reports/" + date);
		folder = new File("reports" +"/"+ date);

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
				snap = MediaEntityBuilder.createScreenCaptureFromPath("./../../" + folder + "/snaps/"+snapNumber + ".png").build();
			
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

	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * private static ExtentReports extent; private static final
	 * ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>(); private
	 * static final ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	 * private static final ThreadLocal<String> testName = new
	 * ThreadLocal<String>();
	 * 
	 * private String fileName = "result.html"; private String pattern =
	 * "dd-MMM-yyyy HH-mm-ss";
	 * 
	 * public String testcaseName, testDescription, authors, category, dataFileName,
	 * dataFileType, excelFileName; public static String folderName = "";
	 * 
	 * @BeforeSuite(alwaysRun = true) public synchronized void startReport() {
	 * String date = new SimpleDateFormat(pattern).format(new Date()); folderName =
	 * "reports/" + date;
	 * 
	 * File folder = new File("./" + folderName); if (!folder.exists()) {
	 * folder.mkdir(); } ExtentHtmlReporter htmlReporter = new
	 * ExtentHtmlReporter("./" + folderName + "/" + fileName);
	 * htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	 * htmlReporter.config().setChartVisibilityOnOpen(!true);
	 * htmlReporter.config().setTheme(Theme.STANDARD);
	 * htmlReporter.config().setDocumentTitle("Salesforce");
	 * htmlReporter.config().setEncoding("utf-8");
	 * htmlReporter.config().setReportName("Salesforce");
	 * htmlReporter.setAppendExisting(true); extent = new ExtentReports();
	 * extent.attachReporter(htmlReporter); }
	 * 
	 * @BeforeClass(alwaysRun = true) public synchronized void startTestCase() {
	 * ExtentTest parent = extent.createTest(testcaseName, testDescription);
	 * parent.assignCategory(category); parent.assignAuthor(authors);
	 * parentTest.set(parent); testName.set(testcaseName); }
	 * 
	 * public synchronized void setNode() { ExtentTest child =
	 * parentTest.get().createNode(getTestName()); test.set(child); }
	 * 
	 * public abstract long takeSnap();
	 * 
	 * public void reportStep(String desc, String status, boolean bSnap) {
	 * synchronized (test) {
	 * 
	 * // Start reporting the step and snapshot MediaEntityModelProvider img = null;
	 * if (bSnap && !(status.equalsIgnoreCase("INFO") ||
	 * status.equalsIgnoreCase("skipped") )) { long snapNumber = 100000L; snapNumber
	 * = takeSnap(); try { img = MediaEntityBuilder
	 * .createScreenCaptureFromPath("./../../" + folderName + "/images/" +
	 * snapNumber + ".jpg") .build(); } catch (IOException e) { } } if
	 * (status.equalsIgnoreCase("pass")) { test.get().pass(desc, img); } else if
	 * (status.equalsIgnoreCase("fail")) { // additional steps to manage alert
	 * pop-up test.get().fail(desc, img); throw new
	 * RuntimeException("See the reporter for details.");
	 * 
	 * } else if (status.equalsIgnoreCase("warning")) { test.get().warning(desc,
	 * img); } else if (status.equalsIgnoreCase("skipped")) {
	 * test.get().skip("The test is skipped due to dependency failure"); } else if
	 * (status.equalsIgnoreCase("INFO")) { test.get().info(desc); }
	 * 
	 * 
	 * } }
	 * 
	 * public void reportStep(String desc, String status) { reportStep(desc, status,
	 * true); }
	 * 
	 * @AfterSuite(alwaysRun = true) public synchronized void endResult() { try { if
	 * (getDriver() != null) { getDriver().quit(); } } catch
	 * (UnreachableBrowserException e) { } extent.flush(); }
	 * 
	 * 
	 * public String getTestName() { return testName.get(); }
	 * 
	 * public Status getTestStatus() { return
	 * parentTest.get().getModel().getStatus(); }
	 */
	
	
	
	
	
}
