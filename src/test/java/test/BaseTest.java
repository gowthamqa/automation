package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.ApplicationProperties;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public ApplicationProperties appProperties =   ApplicationProperties.getInstance();
    protected WebDriver driver;
    protected AppiumDriver<?> m_driver;
    public String url = appProperties.getApp_url();
    public String username = appProperties.getUsername();
    public String password = appProperties.getPassword();
    protected static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> a_driver;
    public static IOSDriver<IOSElement> i_driver = null;

    protected void starting() {
        driver = appProperties.createAndGetDriver();
        //m_driver = appProperties.createAndGetAppiumDriver();
    }

    protected void android_capabilities() throws MalformedURLException {
        DesiredCapabilities dcapabilities = new DesiredCapabilities();
        dcapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        dcapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        dcapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        dcapabilities.setCapability(MobileCapabilityType.APP, "//Users//gowthamr//Desktop//ApiDemos-debug.apk");
        //dcapabilities.setCapability(MobileCapabilityType.APP, "//Users//gowthamr//Desktop//General-Store.apk");
        a_driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dcapabilities);
        a_driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    protected void ios_capabilities() throws MalformedURLException {
        DesiredCapabilities dcapabilities = new DesiredCapabilities();
        dcapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        dcapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        dcapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        dcapabilities.setCapability(MobileCapabilityType.APP, "//Users//gowthamr//Desktop//UICatalog.app");

        i_driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), dcapabilities);
        i_driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    public static boolean isAppiumServerRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        }
        finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    @BeforeSuite
    public void setup() throws MalformedURLException {
        starting();
        //android_capabilities();
        //ios_capabilities();
    }

    @AfterSuite
    public void tearDown(){
        //driver.quit();
    }

}
