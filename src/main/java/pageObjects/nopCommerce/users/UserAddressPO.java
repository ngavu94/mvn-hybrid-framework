package pageObjects.nopCommerce.users;

import org.openqa.selenium.WebDriver;

public class UserAddressPO extends UserSidebarPO {
         WebDriver driver;
        public UserAddressPO(WebDriver driver){
            super(driver);
            this.driver = driver;
        }

//    public RewardPointPageObject openRewardPointPage() {
//            //wait
//        waitForElementClickable(driver, AddressPageUI.REWARD_POINT_LINK);
//        //click
//        clickToElement(driver, AddressPageUI.REWARD_POINT_LINK);
//        return PageGenerator.getRewardPointPage(driver);
//    }

//    public CustomerInfoPageObject openCustomerInfoPage() {
//        //wait
//        waitForElementClickable(driver,AddressPageUI.CUSTOMER_INFO_LINK);
//        //click
//        clickToElement(driver,AddressPageUI.CUSTOMER_INFO_LINK);
//        return PageGenerator.getCustomerInfoPage(driver);
//    }
}
