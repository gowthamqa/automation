package test;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ChgebAPI extends BaseTest{

    @Test
    public void run(){
        driver.get("https://apidocs.chargebee.com/docs/api");
        driver.findElement(By.xpath("//a[contains(text(),'JAVA')]")).click();
    }
}
