package pageObjects.nopCommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserHomePageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;
    public UserHomePO(WebDriver driver){
        this.driver = driver;
    }

    public UserRegisterPO clickToRegisterLink() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }
    public boolean isMyAccountLinkDisplayed() {
        return getElement(driver, UserHomePageUI.MY_ACCOUNT_LINK).isDisplayed();
    }

    public UserCustomerInfoPO clickToMyaccountLink() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }
}
