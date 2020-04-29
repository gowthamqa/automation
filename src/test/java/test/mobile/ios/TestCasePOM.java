package test.mobile.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestCasePOM {

    IOSDriver<IOSElement> driver = null;

    @BeforeClass
    public void capabilities() throws MalformedURLException {
        DesiredCapabilities dcapabilities = new DesiredCapabilities();
        dcapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        dcapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        dcapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        dcapabilities.setCapability(MobileCapabilityType.APP, "//Users//gowthamr//Desktop//UICatalog.app");

        driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dcapabilities);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        //HomePage hp = PageFactory.initElements(driver, HomePage.class);
        //hp.alertsView.click();
    }
}
