package pageObjects.orangeHRM.pim.employee;

import org.openqa.selenium.WebDriver;

public class EmergencyContactsPO extends EmployeeTabs {
    WebDriver driver;

    public EmergencyContactsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
