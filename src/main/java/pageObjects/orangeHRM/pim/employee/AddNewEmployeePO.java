package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.pim.employee.AddNewEmployeePageUI;

public class AddNewEmployeePO extends BasePage {
    WebDriver driver;

    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstnameTextbox(String valueToSenkey) {
        waitForElementVisible(driver, AddNewEmployeePageUI.FIRST_NAME_TEXTBOX);
        senkeysToElement(driver, AddNewEmployeePageUI.FIRST_NAME_TEXTBOX, valueToSenkey);
    }

    public void enterToMiddlenameTextbox(String valueToSenkey) {
        waitForElementVisible(driver, AddNewEmployeePageUI.MIDDLE_NAME_TEXTBOX);
        senkeysToElement(driver, AddNewEmployeePageUI.MIDDLE_NAME_TEXTBOX, valueToSenkey);
    }

    public void enterToLastnameTextbox(String valueToSenkey) {
        waitForElementVisible(driver, AddNewEmployeePageUI.LAST_NAME_TEXTBOX);
        senkeysToElement(driver, AddNewEmployeePageUI.LAST_NAME_TEXTBOX, valueToSenkey);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, AddNewEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, AddNewEmployeePageUI.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public PersonalDetailPO clickToSaveButton() {
        waitForElementClickable(driver, AddNewEmployeePageUI.SAVE_BUTTON);
        clickToElement(driver, AddNewEmployeePageUI.SAVE_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailPage(driver);
    }
}
