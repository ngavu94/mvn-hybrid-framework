package pageObjects.bipower.timekeeping.overtime;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.bipower.timekeeping.ListOvertimeUI;

public class ListOverTimePO extends BasePage {
    WebDriver driver;

    public ListOverTimePO(WebDriver driver) {
        this.driver = driver;
    }

    public void searchByRequestCode(String requestCode) {
        sendkeysToElement(driver, ListOvertimeUI.REQUEST_CODE_SEARCH_BOX, requestCode);
        clickToElement(driver, ListOvertimeUI.SEARCH_BUTTON);
    }

    public boolean isRequestDisplayed(String requestCode) {
        return isElementDisplayed(driver, String.format(ListOvertimeUI.RECORD_ROW_BY_REQUEST_CODE, requestCode));
    }
}
