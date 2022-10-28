package GoogleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.PortUnreachableException;

public class TestGoogleSearch {

    public WebDriver driver;

    @BeforeClass
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TestGoogleSearch(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.selenium.dev/", "wrong result");
    }


    @Test
    public void TestLoginInvalidData(){


    }

    @Test
    public void TestLoginValidData(){


    }

    @Test(dependsOnMethods = "TestLoginValidData" , priority = 2)
    public void TestMakeAppointmentAtTokyo(){

    }


    @AfterClass
    public void endTest(){
        driver.close();
    }

}
