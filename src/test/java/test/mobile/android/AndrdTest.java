package test.mobile.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mobile.Homepage;
import pages.mobile.PreferencesPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndrdTest {


    AndroidDriver<AndroidElement> driver = null;

    @BeforeClass
    public void capabilities() throws MalformedURLException {
        DesiredCapabilities dcapabilities = new DesiredCapabilities();
        dcapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2");
        dcapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        dcapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        dcapabilities.setCapability(MobileCapabilityType.APP, "//Users//gowthamr//Desktop//ApiDemos-debug.apk");
        //dcapabilities.setCapability(MobileCapabilityType.APP, "//Users//gowthamr//Desktop//General-Store.apk");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dcapabilities);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    //export ANDROID_SDK=$HOME/Library/Android/sdk
    //export PATH=$ANDROID_SDK/emulator:$ANDROID_SDK/tools:$PATH
    //

    @Test
    public void test() {
        System.out.println("Starting App");
        Homepage home = new Homepage(driver);
        home.preferences.click();
        PreferencesPage preferences = new PreferencesPage(driver);
        preferences.dependencies.click();
        preferences.wifiCheckBox.click();
        preferences.wifiSettings.click();
        preferences.editBox.sendKeys("hello");
        preferences.buttons.get(0).click();
        //driver.findElementByXPath("//*[@text = 'Preference']").click();
    }

    @Test(enabled = false)
    public void testCart() {
        driver.findElementByClassName("android.widget.Spinner").click();
        scrollToText("China");
        driver.findElementByXPath("//*[@text = 'China']").click();
        driver.findElementByXPath("//*[@text = 'Enter name here']").sendKeys("Gowtham");
        driver.findElementByXPath("//*[@text = 'Female']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        //*[@text = 'Male']
        //*[@text = 'Female']

        //driver.findElementByClassName("android.widget.Spinner").click();


    }

    public void scrollToText(String text)
    {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("deviceName"));
    }

}
