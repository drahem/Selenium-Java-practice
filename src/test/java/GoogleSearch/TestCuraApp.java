package GoogleSearch;

import Pages.LoginPage;
import Pages.MakeAppointmentPage;
import org.checkerframework.checker.units.qual.Temperature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCuraApp {
    public WebDriver driver;

    @BeforeClass
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TestBookAppointmentAtTokyoAndMedicare(){
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        // login
        LoginPage lp = new LoginPage(driver);
        int x = driver.findElements(lp.loginBtn).size();
        Assert.assertEquals(1,x);

        lp.enterUserName("John Doe");
        lp.enterPassword("ThisIsNotAPassword");
        lp.clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        // book appointment
        MakeAppointmentPage appointment = new MakeAppointmentPage(driver);
        appointment.selectFacility("tokyo");
        appointment.selectReadMission(true);
        appointment.selectProgram("test");
        appointment.setDate("31/10/2022");
        appointment.enterComment("this is a test comment...");
        appointment.clickBookBtn();

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
    }
}
