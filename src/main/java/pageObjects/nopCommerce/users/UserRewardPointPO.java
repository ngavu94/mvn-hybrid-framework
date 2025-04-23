package pageObjects.nopCommerce.users;

import org.openqa.selenium.WebDriver;

public class UserRewardPointPO extends UserSidebarPO {
     WebDriver driver;

    public UserRewardPointPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

//    public OrderPageObject openOrderPage() {
//        //wait
//        waitForElementClickable(driver, RewardPageUI.ORDER_LINK);
//        //click
//        clickToElement(driver, RewardPageUI.ORDER_LINK);
//        return PageGenerator.getOrderPage(driver);
//    }
}
