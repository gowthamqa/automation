package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.SyncUtils;

public class BasePage {

    public AppiumDriver<?> driver;
    public WebDriver web_driver;
    public WebDriverWait wait;
    public JavascriptExecutor executor = (JavascriptExecutor) web_driver;
    public SyncUtils sync;

    public BasePage(AppiumDriver<?> driver) {
        this.driver = driver;
        this.initPageElements(driver);
        this.wait = new WebDriverWait(driver, 10L);
    }

    public BasePage(WebDriver driver) {
        this.web_driver = driver;
        this.initPageElements(web_driver);
        this.wait = new WebDriverWait(web_driver, 10L);
        this.sync = new SyncUtils(driver);
    }


    private void initPageElements(AppiumDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private void initPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickUsingJavaScript(WebElement webElement) {
        this.executor.executeScript("arguments[0].click();", new Object[]{webElement});
    }

}
