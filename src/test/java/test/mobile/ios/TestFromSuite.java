package test.mobile.ios;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mobile.AlertsViewPage;
import pages.mobile.Homepage;
import test.BaseTest;
import utilities.AutomationUtils;
import utilities.DateTimeUtils;

public class TestFromSuite extends BaseTest {

    Homepage homePage;
    AlertsViewPage alertsViewPage;

    @BeforeClass
    public void init() {
        homePage = new Homepage(m_driver);
        alertsViewPage = new AlertsViewPage(m_driver);
    }

    @Test
    public void testTextEntry() {
        m_driver.findElementByAccessibilityId("Alert Views").click();
        m_driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Text Entry']").click();
        m_driver.findElementByXPath("//*[@type='XCUIElementTypeOther']").sendKeys("Hello Appium");
        m_driver.findElementByName("OK").click();
    }

    @Test
    public void testTextEntryPOM() {
        homePage.alertsView.click();
        alertsViewPage.textEntryButton.click();
        alertsViewPage.textEntryTextBox.sendKeys("test");
        alertsViewPage.OkButton.click();
        alertsViewPage.secureTextEntryButton.click();
        alertsViewPage.secureTextEntryTextBox.sendKeys("password$123");
        alertsViewPage.OkButton.click();
    }

    public static void main(String[] args) {
        System.out.println(DateTimeUtils.getTodaysDate()+"  "+ DateTimeUtils.getDateRange("2019-12-18", "2019-12-28"));
        System.out.println("First Name>>"+ AutomationUtils.getInputString(9)+" length  "+ AutomationUtils.getInputString(9).length());
        System.out.println("Last Name>>"+ AutomationUtils.getInputString(8 , true)+" length>>  "+ AutomationUtils.getInputString(8, true).length());
        System.out.println("Last Name>>"+ AutomationUtils.getInputString(10 , true, true)+" length>>  "+ AutomationUtils.getInputString(10, true, true).length());
        System.out.println(AutomationUtils.getRandomInt(0, 750));
        System.out.println(AutomationUtils.getRandomInt(9));
    }

}
