package pageObjects.nopCommerce.users;

import org.openqa.selenium.WebDriver;

public class UserOrderPO extends UserSidebarPO {
     WebDriver driver;

    public UserOrderPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

//    public AddressPageObject openAddressPage() {
//        //wait
//        waitForElementClickable(driver, OrderPageUI.ADDRESS_LINK);
//        //click
//        clickToElement(driver, OrderPageUI.ADDRESS_LINK);
//        return PageGenerator.getAddressPage(driver);
//    }
}
