package pages.web.pract;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.List;

public class WebpracticeDownload extends BasePage {


    public WebpracticeDownload(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public WebpracticeDownload(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//table[@class='data-list']/tbody/tr")
    public List<WebElement> dataListTableRows;

    public String getLangaugeVersion(String language) {
        return wait.until(ExpectedConditions.visibilityOf(web_driver.findElement(By.xpath("//td[text()='"+language+"']/following-sibling::td")))).getText();
        //return web_driver.findElement(By.xpath("//td[text()='"+language+"']/following-sibling::td")).getText();
        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='" + accountID + "']//following::i[@class='far fa-sign-in addPointer']"))).click();
    }


}
