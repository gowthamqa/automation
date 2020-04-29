package pages.web.turvo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement userNameEle;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordEle;

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement logInButton;

    public void login(String email, String password){
        sync.waitElementToBeVisible(userNameEle);
        userNameEle.sendKeys(email);
        sync.waitElementToBeVisible(passwordEle);
        passwordEle.sendKeys(password);
        sync.waitElementToBeClickable(logInButton);
        logInButton.click();
    }
}
