package pages.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class PreferencesPage extends BasePage {

    public PreferencesPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
    public WebElement dependencies;

    @AndroidFindBy(id = "android:id/checkbox")
    public WebElement wifiCheckBox;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
    public WebElement wifiSettings;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement editBox;

    @AndroidFindBy(className="android.widget.Button")
    public List<WebElement> buttons;
}
