package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportUtils {

	
	public static ExtentReports report;
	public static ExtentTest logger;

	public static void startReport(String reportPath, String reportName, String reportTitle){
	
		report=new ExtentReports(reportPath + reportName + "_" + new SimpleDateFormat("dd-MM-yyyy").format(new Date())+ ".html" , false);
		logger=report.startTest(reportTitle);	

	}

	public static void reportLog(LogStatus logstatus, String loginfo){
	
		logger.log(logstatus, loginfo);
		
	}
	
	public static String attachScreenshotInReport(String screenShotPath) {
		String screenShot = logger.addScreenCapture(screenShotPath);
		return screenShot;
		
	}
	
	public static void endReport(){
		report.endTest(logger);
		report.flush();
	
	}

}
