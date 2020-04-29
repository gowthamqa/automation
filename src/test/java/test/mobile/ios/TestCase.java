package test.mobile.ios;


import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestCase {

    IOSDriver<IOSElement>driver = null;

    @BeforeClass
    public void capabilities() throws MalformedURLException {
        DesiredCapabilities dcapabilities = new DesiredCapabilities();
        dcapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        dcapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        dcapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        dcapabilities.setCapability(MobileCapabilityType.APP, "//Users//gowthamr//Desktop//UICatalog.app");

        driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), dcapabilities);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }


    @Test(priority = 0)
    public void testTextEEntry() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Text Entry']").click();
        driver.findElementByXPath("//*[@type='XCUIElementTypeOther']").sendKeys("Hello Appium");
        driver.findElementByName("OK").click();

    }

    @iOSXCUITFindBy(className = "XCUIElementTypeOther")
    public MobileElement slider;

    @Test(priority = 1)
    public void testSecureTextEntry() {
        driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Secure Text Entry\"]").click();
        driver.findElementByClassName("XCUIElementTypeOther").sendKeys("12345");
        driver.findElementByName("OK").click();
    }

    @Test(priority = 2)
    public void testSelectChoice() {
        driver.findElementByAccessibilityId("Other").click();
        String choice = driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Choice One\"]").getAttribute("name");
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Choice One\"]").click();
        System.out.println(choice);
    }

    @Test(priority = 3)
    public void testOkayOrCancel() {
        driver.findElementByAccessibilityId("Okay / Cancel").click();
        String message = driver.findElementByName("A Short Title Is Best").getText();
        Assert.assertEquals(message, "A Short Title Is Best", ">>>Title: "+message);
        driver.findElementByName("OK").click();
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"UICatalog\"]").click();
    }

    @Test(priority = 4, enabled = false)
    public void testPicker() {
        driver.findElementByAccessibilityId("Picker View").click();
        for (int i = 0; i < 3; i++){
            System.out.println(driver.findElementByXPath("//*[@type = 'XCUIElementTypeOther']").getText());
            System.out.println(driver.findElementByXPath("//*[@type = 'XCUIElementTypeOther']").getAttribute("name"));
            driver.findElementByXPath("//*[@type = 'XCUIElementTypeOther']").click();
        }
    }

    @Test(priority = 5, enabled = false)
    public void testDatePicker() {
        driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Date Picker\"]").click();
        WebElement dayElement = driver.findElementByXPath("//XCUIElementTypeDatePicker/XCUIElementTypeOther/XCUIElementTypePickerWheel[1]");
        WebElement hourElement = driver.findElementByXPath("//XCUIElementTypeDatePicker/XCUIElementTypeOther/XCUIElementTypePickerWheel[2]");
        WebElement minutElement = driver.findElementByXPath("//XCUIElementTypeDatePicker/XCUIElementTypeOther/XCUIElementTypePickerWheel[3]");
        WebElement clockElement = driver.findElementByXPath("//XCUIElementTypeDatePicker/XCUIElementTypeOther/XCUIElementTypePickerWheel[4]");
        System.out.println(driver.findElementByXPath("//*[@type = 'XCUIElementTypeStaticText']").getAttribute("name"));
        System.out.println("Before Change"+dayElement.getAttribute("value"));
        pickerwheelStep(driver, dayElement, "next", 0.15);
        System.out.println("After Change"+dayElement.getAttribute("value"));
        System.out.println(driver.findElementByXPath("//*[@type = 'XCUIElementTypeStaticText']").getAttribute("name"));
        System.out.println("Before Change"+hourElement.getAttribute("value"));
        pickerwheelStep(driver, hourElement, "previous", 0.15);
        System.out.println("After Change"+hourElement.getAttribute("value"));
        System.out.println(driver.findElementByXPath("//*[@type = 'XCUIElementTypeStaticText']").getAttribute("name"));
        System.out.println("Before Change"+minutElement.getAttribute("value"));
        pickerwheelStep(driver, minutElement, "next", 0.15);
        System.out.println("After Change"+minutElement.getAttribute("value"));
        System.out.println(driver.findElementByXPath("//*[@type = 'XCUIElementTypeStaticText']").getAttribute("name"));
        System.out.println("Before Change"+clockElement.getAttribute("value"));
        pickerwheelStep(driver, clockElement, "previous", 0.15);
        System.out.println("After Change"+clockElement.getAttribute("value"));
        System.out.println(driver.findElementByXPath("//*[@type = 'XCUIElementTypeStaticText']").getAttribute("name"));
    }


    private static void pickerwheelStep(IOSDriver driver, WebElement element, String direction, double offset) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("order", direction);
        params.put("offset", offset);
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: selectPickerWheelValue", params);
    }


}
