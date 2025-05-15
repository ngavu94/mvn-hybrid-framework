package pageObjects.bipower.timekeeping.overtime;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.bipower.timekeeping.RequestOvertimeUI;

public class RegisterOvertimePO extends BasePage {
    WebDriver driver;
    public RegisterOvertimePO(WebDriver driver){
       this.driver= driver;
    }

    public void inputRequestCode(String code) {
        sendkeysToElement(driver, RequestOvertimeUI.REQUEST_CODE_TEXTBOX, code);
    }

    public void selectProject(String projectName) {
        clickToElement(driver, RequestOvertimeUI.PROJECT_DROPDOWN);
        waitForElementVisible(driver, String.format(RequestOvertimeUI.PROJECT_ITEM_BY_NAME, projectName));
        clickToElement(driver, String.format(RequestOvertimeUI.PROJECT_ITEM_BY_NAME, projectName));
    }

    public void inputOvertimeReason(String reason) {
        sendkeysToElement(driver, RequestOvertimeUI.OVERTIME_REASON_TEXTAREA, reason);
    }

    public void inputStartDate(String date) {
        sendkeysToElement(driver, RequestOvertimeUI.START_DATE_TEXTBOX, date);
    }

    public void inputFromTime(String time) {
        sendkeysToElement(driver, RequestOvertimeUI.FROM_TIME_TEXTBOX, time);
    }

    public void inputToTime(String time) {
        sendkeysToElement(driver, RequestOvertimeUI.TO_TIME_TEXTBOX, time);
    }

    public void inputJiraLink(String link) {
        sendkeysToElement(driver, RequestOvertimeUI.JIRA_LINK_TEXTBOX, link);
    }

    public void clickSave() {
        clickToElement(driver, RequestOvertimeUI.SAVE_BUTTON);
    }
}
