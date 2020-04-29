package test.web;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test.BaseTest;
import utilities.AutomationUtils;

public class Sample extends BaseTest {

    @Test
    public void test() {
        driver.get("https://mail.google.com/mail");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("gowthamreddy.mallangi");
        driver.findElement(By.xpath("//input[@type='email']")).submit();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("10741a0303");
        driver.findElement(By.xpath("//input[@type='password']")).submit();

    }

    public static void main(String[] args) {
        System.out.println(AutomationUtils.getRandomInt(2));
    }
}
