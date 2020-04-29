package pages.web.pract;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utilities.AutomationUtils;

public class Webpractice extends BasePage {


    public Webpractice(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public Webpractice(WebDriver driver) {
        super(driver);
    }

    public  String date="Test";

    @FindBy(linkText = "Downloads")
    public WebElement downloadLink;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    public WebElement selectMonth;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    public WebElement selectYear;

    @FindBy(id = "register_form:profile:referral")
    public WebElement referralId;

    @FindBy(xpath = "//input[contains(@id,'nameOnCard')]")
    public WebElement nameOnCard;



    public void clickOnDownload() {
        //wait.until(ExpectedConditions.elementToBeClickable(downloadLink)).click();
        //downloadLink.click();
        sync.waitElementToBeClickable(downloadLink);
        downloadLink.click();
    }

    public void enterReferralCode(String value) {
        sync.waitElementToBeVisible(referralId);
        referralId.sendKeys(value);
    }

    public void enterNameOnCard(String name) {
        sync.waitElementToBeVisible(nameOnCard);
        nameOnCard.sendKeys(name);
    }

    public void selectDateOfYear(String text) {
        sync.waitElementToBeClickable(selectYear);
        AutomationUtils.selectByVisableText(selectYear, text);
    }

    public void selectDateOfMonth(String text) {
        sync.waitElementToBeClickable(selectMonth);
        AutomationUtils.selectByVisableText(selectMonth, text);
    }

    public void selectDate(String date) {
        web_driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
    }




}
