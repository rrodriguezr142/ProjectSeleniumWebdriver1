package com.magento.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static final ExtentReports extentReports = new ExtentReports();
	
	public synchronized static ExtentReports createExtentReports() {
		//ExtentSparkReporter report= new ExtentSparkReporter(System.getProperty("user.dir")+"/report/reports.html");
		ExtentSparkReporter report= new ExtentSparkReporter("./report/reports.html");
		report.config().setReportName("Reporte magento");
		report.config().setDocumentTitle("Report of Magento");
		report.config().setTheme(Theme.STANDARD);
		extentReports.attachReporter(report);
		extentReports.setSystemInfo("Report 1", "QA");
		extentReports.setSystemInfo("Author", "Ronald Rodriguez");
		
		return extentReports;
		
	}
}
