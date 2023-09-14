package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter  {
    static Properties prop;

    private static ExtentReports extentReport;

    public static ExtentReports generateExtentReport() {
        if (extentReport == null) {
            extentReport = createExtentReport();
        }
        return extentReport;
    }

    private static ExtentReports createExtentReport() {
        ExtentReports extentReport = new ExtentReports();
        String filepath=System.getProperty("user.dir")+"/src/test/java/resources/browser.properties";
		try
		{
			FileInputStream file=new FileInputStream(filepath);
			prop=new Properties();
			prop.load(file);
		}
		catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

        TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata"); // IST timezone

        dateFormat.setTimeZone(istTimeZone);

 

        String timestamp = dateFormat.format(new Date());

 

        // Define the file path with the timestamp

        String reportFilePath = System.getProperty("user.dir") + "/src/main/reports/extentReport_" + timestamp + ".html";

        File extentReportFile = new File(reportFilePath);

 

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

 

        sparkReporter.config().setTheme(Theme.DARK);

        sparkReporter.config().setReportName("Gillette Test Report");

        sparkReporter.config().setDocumentTitle("Gillette Automation Automation Report");

        sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

 

        extentReport.attachReporter(sparkReporter);

 

        extentReport.setSystemInfo("Application URL", prop.getProperty("url"));

        extentReport.setSystemInfo("Browser Name", prop.getProperty("browserName"));

        extentReport.setSystemInfo("Email", prop.getProperty("validEmail"));

        extentReport.setSystemInfo("Password", prop.getProperty("validPassword"));

        extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));

        extentReport.setSystemInfo("Username", System.getProperty("user.name"));

        extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

 

        return extentReport;

    }

}

