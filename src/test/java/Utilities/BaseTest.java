package Utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public static WindowsDriver driver = null;

    static ExtentReports extent;
    static ExtentHtmlReporter reporter;
    static ExtentTest logger;
    protected static Configuration configurationGet = Configuration.getInstance();


    @BeforeSuite
    public void beforeSuite() {
        extent = new ExtentReports();
        reporter = new ExtentHtmlReporter("./Reports/AutomationReport"+ String.valueOf(new File("./Reports").list().length+1)+".html");
        extent.attachReporter(reporter);
    }

    @BeforeMethod
    public void beforeMethod (Method method) {
        logger = extent.createTest(method.getName());
        logger.info("Driver has been initialized and the test has started.");

    }

    @BeforeTest
    public void Setup()  {

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "C:\\Users\\pos\\Desktop\\WinApp\\Project\\projectCafe.exe");
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String temp = ExtentReportUtilities.getScreenshot(driver);
            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("Test succeeded.");
        }

    }
    @AfterSuite
    public void afterSuite() { extent.flush(); }
   @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
