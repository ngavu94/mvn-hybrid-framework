package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.employee.EmployeeListPO;
import pageUIs.orangeHRM.DashboardPageUI;

public class DashboardPO extends BasePage {
    WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeeListPO clickToPIMPage() {
        waitForElementClickable(driver, DashboardPageUI.PIM_LINK);
        clickToElement(driver, DashboardPageUI.PIM_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmployeeListPage(driver);
    }
}
