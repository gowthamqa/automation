package test.mobile.ios;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestCaseSCroll {

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
    public void testScroll(){
        Dimension size = driver.manage().window().getSize();
        swipeUp(driver, size);
        swipeDown(driver, size);
        swipeUp(driver, size);
        driver.findElementByAccessibilityId("Steppers").click();
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Increment\"][1]").click();
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Increment\"][1]").click();
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Increment\"][1]").click();
        String result = driver.findElementByXPath("//*[@type=\"XCUIElementTypeStaticText\"][1]").getText();
        System.out.println(result);
        driver.navigate().back();
        driver.findElementByAccessibilityId("Switches").click();
    }

    public void swipeUp(IOSDriver driver, Dimension size) {
        int startX = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.80);
        int endY = (int) (size.getHeight() * 0.20);

        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo( PointOption.point(startX, endY))
                .release()
                .perform();
    }

    public void swipeDown(IOSDriver driver, Dimension size) {
        int startX = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.20);
        int endY = (int) (size.getHeight() * 0.80);

        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    public void swipeRight(IOSDriver driver, WebElement element) {
        int startX = element.getSize().getWidth() / 2;
        int startY = (int) (element.getSize().getHeight() * 0.60);
        int endY = (int) (element.getSize().getHeight() * 0.10);

        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

}
