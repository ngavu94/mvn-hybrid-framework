package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.pim.employee.EmployeeListPageUI;

public class EmployeeListPO extends BasePage {
    WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    public AddNewEmployeePO clickToAddEmployeeButton() {
        waitForElementClickable(driver, EmployeeListPageUI.ADD_NEW_EMPLOYEE_BUTTON);
        clickToElement(driver, EmployeeListPageUI.ADD_NEW_EMPLOYEE_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAddNewEmployeePage(driver);
    }
}
