package factory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static utils.Utils.getProp;

public class DriverFactory {
    private static AndroidDriver<MobileElement> driver;
    public static Properties properties = getProp();

    public static AndroidDriver<MobileElement> getDriver(){
        if (driver == null){
            if("local".equals(getProp().getProperty("CreationDriver"))){
                createDriver();
            }
            if("cloud".equals(getProp().getProperty("CreationDriver"))){
                createTestObjectDriver();
            }
        }
        return driver;
    }

    public static void createDriver() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName","Android");
            desiredCapabilities.setCapability("deviceName","");
            desiredCapabilities.setCapability("automationName","uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/apk/CTAppium_1_2.apk");

            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void createTestObjectDriver() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName","Android");
            desiredCapabilities.setCapability("app", "storage:a1bc359f-c074-41c6-ac38-a7003faa49a6");
            desiredCapabilities.setCapability("autoGrantPermissions", "true");
            desiredCapabilities.setCapability("noSign", "true");
            desiredCapabilities.setCapability("automationName","uiautomator2");

            driver = new AndroidDriver<MobileElement>(new URL("https://uilen:048ee269-e35d-4f82-9635-3718508bf029@ondemand.us-west-1.saucelabs.com:443/wd/hub"),desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
