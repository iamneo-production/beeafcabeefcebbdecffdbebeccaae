package utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class base64 {
    public String captureScreenshotAsBase64(WebDriver driver) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata"); // IST timezone
        dateFormat.setTimeZone(istTimeZone);
        String timestamp = dateFormat.format(new Date());

        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        byte[] screenshotBytes = screenshotDriver.getScreenshotAs(OutputType.BYTES);

        String base64Screenshot = "";
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(screenshotBytes);
            base64Screenshot = Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return base64Screenshot;
    }
}
