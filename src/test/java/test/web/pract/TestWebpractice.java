package test.web.pract;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.web.pract.Webpractice;
import pages.web.pract.WebpracticeDownload;
import test.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;


public class TestWebpractice extends BaseTest {

    Webpractice wp;

    @BeforeClass
    public void init() {
        wp = new Webpractice(driver);

    }

    @Test
    public void testDynamictable() {
        driver.get("https://selenium.dev/");
        wp = new Webpractice(driver);
        wp.clickOnDownload();
        WebpracticeDownload wpd = new WebpracticeDownload(driver);
        System.out.println("Ruby>>>>>>>>"+wpd.getLangaugeVersion("Ruby"));
        System.out.println("JavaScript>>>>>>>>"+wpd.getLangaugeVersion("JavaScript"));
        System.out.println("Python>>>>>>>>"+wpd.getLangaugeVersion("Python"));
        System.out.println("Java>>>>>>>>"+wpd.getLangaugeVersion("Java"));
        System.out.println("C#>>>>>>>>"+wpd.getLangaugeVersion("C#"));
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("image.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        driver.get("http://demoqa.com/menu/");
        System.out.println("demoqa webpage Displayed");
        Actions actions = new Actions(driver);
        //Retrieve WebElement 'Music' to perform mouse hover
        WebElement menuOption = driver.findElement(By.xpath(".//div[contains(text(),'Music')]"));
        //Mouse hover menuOption 'Music'
        actions.moveToElement(menuOption).perform();
        System.out.println("Done Mouse hover on 'Music' from Menu");

        //Now Select 'Rock' from sub menu which has got displayed on mouse hover of 'Music'
        WebElement subMenuOption = driver.findElement(By.xpath(".//div[contains(text(),'Rock')]"));
        //Mouse hover menuOption 'Rock'
        //actions.moveToElement(subMenuOption).build().perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", new Object[]{subMenuOption});
        actions.moveToElement(subMenuOption).build().perform();
        System.out.println("Done Mouse hover on 'Rock' from Menu");

        //Now , finally, it displays the desired menu list from which required option needs to be selected
        //Now Select 'Alternative' from sub menu which has got displayed on mouse hover of 'Rock'
        WebElement selectMenuOption = driver.findElement(By.xpath(".//div[contains(text(),'Alternative')]"));
        selectMenuOption.click();
        System.out.println("Selected 'Alternative' from Menu");
    }

    @Test
    public void testSelect() {
        driver.get("");
        WebElement menuOption = driver.findElement(By.xpath(".//div[contains(text(),'Music')]"));
        Select se = new Select(menuOption);
        se.selectByIndex(1);
        se.selectByValue("");
        se.selectByVisibleText("");
        se.getAllSelectedOptions();
        se.getOptions();
        se.deselectAll();

    }

    @Test
    public void naukri(){
        driver.get("https://www.naukri.com/");
        driver.findElement(By.xpath("//div[text()='Login']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gowthamreddy.mallangi@gmail.com");
        driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("Naukri@123");
        driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
    }

    @Test
    public void testAirIndia() throws InterruptedException {
        driver.get("https://ffai.loyaltyplus.aero/ailoyalty/register.jsf");
        wp.enterNameOnCard("Gowtham");
        driver.findElement(By.xpath("//label[contains(@id,'title_label')]")).click();
        sleep(3000);
        //driver.findElement(By.xpath("//li[text()='MISS']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@id, 'title_label')]"));
        for (int i = 1;i < list.size();i++) {
            System.out.println(driver.findElement(By.xpath("//ul[contains(@id, 'title_label')]/li["+i+"]")).getText());
        }
        sleep(3000);
        driver.findElement(By.xpath("//input[contains(@id,'dateOfBirth_input')]")).click();
        Select selMonth = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        selMonth.selectByVisibleText("Feb");
        sleep(3000);
        wp.enterReferralCode("123454321");
        //wp.selectDateOfMonth("Mar");
        //wp.selectDateOfYear("1992");
        //wp.selectDate("24");
        //driver.findElement(By.xpath("//input[contains(@id,'dateOfBirth_input')]")).click();
        //driver.findElement(By.xpath("//a[text()='27']")).click();
        //driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[contains(@class, 'current-day ui-datepicker-today')]")).click();
        //driver.findElement(By.xpath("//input[contains(@id,'dateOfBirth_input')]")).sendKeys("27/Jan/2020");
        //driver.findElement(By.xpath("//input[contains(@id,'fathersName')]")).click();
        //sleep(3000);
        //driver.findElement(By.xpath("//input[contains(@id,'mothersName')]")).sendKeys("test");
        //driver.findElement(By.xpath("//input[contains(@id,'fathersName')]")).sendKeys("Reddy");

    }

    @Test
    public void testZoo() throws InterruptedException {
        driver.get("https://app.zunos.com");
        sleep(2000);
        driver.findElement(By.xpath("//button[text() = 'Login to Zunos']")).click();
        sleep(2000);
        driver.findElement(By.xpath("//input[@name = 'Username']")).sendKeys("Lakshmi.Chaitanya@sephora.com");
        sleep(2000);
        driver.findElement(By.xpath("//input[@name = 'Username']")).submit();
        sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(), 'Type password')]")).click();
        sleep(2000);//
        driver.findElement(By.xpath("//input[@name = 'Password']")).sendKeys("Ilovesaahithi1");
        sleep(2000);
        driver.findElement(By.xpath("//input[@name = 'Password']")).submit();
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//div[contains(text(), 'My Sephora Learning')]")).click();
        sleep(3000);
        driver.findElement(By.xpath("//div[contains(@class, 'search')]")).click();
        sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Search Courses, Files and More']")).click();
        sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Search Courses, Files and More']")).sendKeys("test");
        //div[contains(text(), 'My Sephora Learning')]
    }

    @AfterMethod
    public void clear(){
        //driver.quit();
    }


}
