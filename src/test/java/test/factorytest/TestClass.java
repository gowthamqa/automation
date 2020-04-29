package test.factorytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {

    private String user;
    private String password;
    public TestClass (String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver", "chromedriver8");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ffai.loyaltyplus.aero/ailoyalty/register.jsf");
        driver.findElement(By.xpath("//input[contains(@id,'mothersName')]")).sendKeys(user);
        driver.findElement(By.xpath("//input[contains(@id,'fathersName')]")).sendKeys(password);
        System.out.println(">>>>>>>>>>>>>>:  "+user+" and "+password+" : <<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    @Test(invocationCount=5)
    public void test2()
    {
        System.out.println("Hello");
        System.out.println(Thread.currentThread().getId());
    }

}
