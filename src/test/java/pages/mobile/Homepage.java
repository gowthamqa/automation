package pages.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class Homepage extends BasePage {

    public Homepage(AppiumDriver<?> driver) {
        super(driver);
    }

    @iOSXCUITFindBy(xpath = "//*[@text='Preference']")
    @AndroidFindBy(xpath="//*[@text='Preference']")
    public WebElement preferences;

    @iOSXCUITFindBy(accessibility = "Alert Views")
    @AndroidFindBy(xpath="//*[@text='Preference']")
    public WebElement alertsView;



}