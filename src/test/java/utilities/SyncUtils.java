package utilities;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncUtils {

    public WebDriver driver;
    public WebDriverWait wait;
    private static Logger log = Logger.getLogger(SyncUtils.class);

    public SyncUtils(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30L);
        this.driver = driver;
    }

    public void waitElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        System.out.println(element.getText()+" found element");

    }

    public void waitElementToBeClickable(WebElement element) {
         wait.until(ExpectedConditions.elementToBeClickable(element));
         //log.info(element+" identified to click");
         //System.out.println(element.getText()+" identified to click");

    }

    public void waitElementToBeSelected(WebElement element) {
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

}
