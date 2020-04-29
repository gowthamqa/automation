package pages.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class AlertsViewPage extends BasePage {

    public AlertsViewPage(AppiumDriver<?> driver) {
        super(driver);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Text Entry']")
    @AndroidFindBy(xpath="//*[@text='Preference']")
    public WebElement textEntryButton;

    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeOther']")
    @AndroidFindBy(xpath = "//*[@type='XCUIElementTypeOther']")
    public WebElement textEntryTextBox;

    @iOSXCUITFindBy(xpath = "//*[@name='OK']")
    @AndroidFindBy(xpath = "//*[@name='OK']")
    public WebElement OkButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Secure Text Entry\"]")
    @AndroidFindBy(xpath = "//*[@name='OK']")
    public WebElement secureTextEntryButton;

    @iOSXCUITFindBy(className = "XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//*[@name='OK']")
    public WebElement secureTextEntryTextBox;


}
