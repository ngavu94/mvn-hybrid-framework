package pageObjects.nopCommerce.demo;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUIs.nopCommerce.demo.HomePageUIs;
import pageUIs.nopCommerce.demo.MyAccountPageUIs;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public RegisterPageObject clickToRegisterLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUIs.REGISTER_LINK);
        clickToElement(driver, HomePageUIs.REGISTER_LINK);
        return PageGeneratorPO.getRegisterPage(driver);
    }
    public LoginPageObject clickToLoginLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUIs.LOGIN_LINK);
        clickToElement(driver, HomePageUIs.LOGIN_LINK);
        return new LoginPageObject(driver);
    }
    public MyAccountPageObject clickToMyAccountLink(WebDriver driver) {
        waitForElementClickable(driver, HomePageUIs.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUIs.MY_ACCOUNT_LINK);
        Assert.assertEquals(getElementText(driver, MyAccountPageUIs.PAGE_TITLE), "My account - Customer info");
        return new MyAccountPageObject(driver);
    }

    public boolean isMyAccountDisplayed() {
        waitForElementVisible(driver, HomePageUIs.MY_ACCOUNT_LINK);
        return  isElementDisplayed(driver, HomePageUIs.MY_ACCOUNT_LINK);
    }
}
