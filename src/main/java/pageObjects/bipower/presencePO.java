package pageObjects.bipower;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.bipower.PageGenerator;
import pageUIs.bipower.timekeeping.PresencePageUI;

public class presencePO extends BasePage {
    WebDriver driver;

    public presencePO(WebDriver driver) {
        this.driver = driver;
    }

//    public OvertimeListPO clickToOvertimePage() {
//        waitForElementClickable(driver, PresencePageUI.SCREENNAME_LABEL);
//        clickToElement(driver, DashboardPageUI.PIM_LINK);
//        waitAllLoadingIconInvisible(driver);
//        return PageGenerator.getOvertimePage(driver);
//    }
}
