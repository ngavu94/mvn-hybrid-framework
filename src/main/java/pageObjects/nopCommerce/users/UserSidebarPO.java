package pageObjects.nopCommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserSidebarPageUI;

public class UserSidebarPO extends BasePage {
    WebDriver driver;

    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserRewardPointPO openRewardPointPage() {
        //wait
        waitForElementClickable(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        //click
        clickToElement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        //wait
        waitForElementClickable(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        //click
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }

    public UserAddressPO openAddressPage() {
        //wait
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_LINK);
        //click
        clickToElement(driver, UserSidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }


    public UserOrderPO openOrderPage() {
        //wait
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        //click
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }

    //TH page ít thì viêt như này
    public UserSidebarPO openSidebarLinkByPageName(String pageName) {
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        //click
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        switch (pageName) {
            case "Addresses":
                return PageGenerator.getUserAddressPage(driver);
            case "Reward points":
                return PageGenerator.getUserRewardPointPage(driver);
            case "Customer info":
                return PageGenerator.getUserCustomerInfoPage(driver);
            case "Orders":
                return PageGenerator.getUserOrderPage(driver);
        }
         throw new RuntimeException("Page name is not valid");
    }
    // TH page nhiều thì viết như này
    public void openSidebarLinkByPageNames(String pageName) {
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        //click
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);

    }

}
