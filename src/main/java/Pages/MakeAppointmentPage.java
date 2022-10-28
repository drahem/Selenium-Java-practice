package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.swing.plaf.PanelUI;

public class MakeAppointmentPage {

    WebDriver driver;

    public By facility = By.id("combo_facility");
    public By tokyo = By.xpath("//*[contains(text(),'Tokyo CURA Healthcare Center')]");
    public By hongkong = By.xpath("//*[contains(text(),'Hongkong CURA Healthcare Center')]");
    public By seoul = By.xpath("Seoul CURA Healthcare Center");
    public By readMissionCheckbox = By.id("chk_hospotal_readmission");
    public By mediCareBtn = By.id("radio_program_medicare");
    public By mediCadBtn = By.id("radio_program_medicaid");
    public By noneBtn = By.id("radio_program_none");
    public By dateElement = By.id("txt_visit_date");
    public By commentField = By.id("txt_comment");
    public By bookAppointmentBtn = By.id("btn-book-appointment");

    public MakeAppointmentPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFacility(String facilityName){
        driver.findElement(facility).click();
        if (facilityName == "tokyo"){
            driver.findElement(tokyo).click();
        }
        else if (facilityName == "hongkong"){
            driver.findElement(hongkong).click();
        }
        else if (facilityName == "seoul"){
            driver.findElement(seoul).click();
        }
    }

    public void selectReadMission(boolean status){
        if (status){
            driver.findElement(readMissionCheckbox).click();
        }
    }

    public void selectProgram(String programName){
        if (programName == "medicare"){
            driver.findElement(mediCareBtn).click();
        }
        else if (programName == "medicaid"){
            driver.findElement(mediCadBtn).click();
        }
        else if(programName == "none"){
            driver.findElement(noneBtn).click();
        }
    }

    public void setDate(String date){
        driver.findElement(dateElement).sendKeys(date);
    }

    public void enterComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickBookBtn(){
        driver.findElement(bookAppointmentBtn).click();
    }
}
