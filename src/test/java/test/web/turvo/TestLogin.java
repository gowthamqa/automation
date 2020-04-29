package test.web.turvo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.web.turvo.LoginPage;
import test.BaseTest;

public class TestLogin extends BaseTest {

    LoginPage loginPage;

    @BeforeClass
    public void init(){ loginPage = new LoginPage(driver); }

    @Test
    public void VerifyLogin() {
        driver.get(url);
        loginPage.login(username, password);
        System.out.println(driver.getTitle());
    }

}
