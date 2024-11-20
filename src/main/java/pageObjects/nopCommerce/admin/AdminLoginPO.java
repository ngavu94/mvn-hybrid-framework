package pageObjects.nopCommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;
    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }


    public AdminDashboardPO clickToLoginButton() {
        return PageGenerator.getAdminDashboardPage(driver);
    }

    public void enterToEmailTextbox(String email) {
        //wait
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        //enter
        senkeysToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(String pass) {
        //wait
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        //enter
        senkeysToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, pass);
    }
}
