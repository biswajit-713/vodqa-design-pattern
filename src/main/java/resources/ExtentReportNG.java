package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
    static ExtentReports extentReport;

    public static ExtentReports getExtentReport() {
        String filePath = System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filePath);
        extentSparkReporter.config().setReportName("Spree Commerce Test Demo");
        extentSparkReporter.config().setDocumentTitle("Test Results");

        extentReport = new ExtentReports();
        extentReport.attachReporter(extentSparkReporter);
        extentReport.setSystemInfo("QA", "Preeti A");

        return extentReport;
    }
}
