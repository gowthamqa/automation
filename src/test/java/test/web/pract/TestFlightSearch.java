package test.web.pract;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestFlightSearch extends BaseTest {

    @Test
    public void search() {
        //driver.findElement()
        driver.findElement(By.id("Editbox13_show")).sendKeys("");
    }
}
