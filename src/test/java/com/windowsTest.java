package com;



import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class windowsTest {
    public static WindowsDriver driver = null;

    @BeforeClass
    public void Setup()  {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "appPath");
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void loginTest(){
        driver.findElementByName("txtId").sendKeys("celik");
        driver.findElementByName("txtPass").sendKeys("1234");
        driver.findElementByName("btnGiris").click();
    }

   @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
