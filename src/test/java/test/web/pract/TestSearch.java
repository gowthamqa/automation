package test.web.pract;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import test.BaseTest;

import static java.lang.Thread.sleep;

public class TestSearch {

    WebDriver driver;

   // @Test
    public void test() throws InterruptedException {
        driver.get("https://www.easemytrip.com/");
        //driver.findElement(By.id("FromSector_show")).sendKeys(Keys.chord("Bangalore", Keys.ENTER));
        //driver.findElement(By.id("Editbox13")).sendKeys(Keys.chord("Delhi", Keys.ENTER));
        sleep(5000);
        driver.findElement(By.xpath("//input[@value='Search']")).click();
        sleep(3000);
        //driver.switchTo().alert().accept();
        /*List<WebElement> results = driver.findElements(By.xpath("//div[@data-infinite-scroll='loadMoreOutBound()']/div[contains(@class,'fltResult')]"));
        System.out.println(results.size());
        for (int i = 0;i < 4;i++){
            System.out.println(results.get(i).getAttribute("price"));
            System.out.println(results.get(i).getAttribute("aircode"));
            System.out.println(driver.findElement(By.xpath("//div[@data-infinite-scroll='loadMoreOutBound()']/div[contains(@class,'fltResult')]["+i+1+"]//span[contains(@class, 'txt-r4')]")).getText());
        }*/

    }
    @Test
    public void testWebDriverManager() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        driver.get("https://www.easemytrip.com/");
    }
}
