package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public By userNameElement = By.id("txt-username");
    public By passwordElement = By.id("txt-password");
    public By loginBtn = By.id("btn-login");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUserName(String userName){
        driver.findElement(userNameElement).sendKeys(userName);
    }

    public void enterPassword(String password){
        driver.findElement(passwordElement).sendKeys(password);
    }

    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }
}
