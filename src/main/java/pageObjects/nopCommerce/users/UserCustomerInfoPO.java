package pageObjects.nopCommerce.users;

import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends UserSidebarPO {

    private WebDriver driver;

    public UserCustomerInfoPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public boolean isGenderMaleSelected() {
        waitForElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
        return  getElement(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO).isSelected();
    }

    public String getFirstNameTextboxValue() {
        return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX,"value");
    }

    public String getLastNameTextboxValue() {
        return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX,"value");
    }

//    public String getDayDropdownSelectedValue() {
//        return null;
//    }
//
//    public String getMonthDropdownSelectedValue() {
//        return null;
//    }
//
//    public String getYearDropdownSelectedValue() {
//        return null;
//    }

    public String getEmailTextboxValue() {
        return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX,"value");
    }

    public String getCompanyNameTextboxValue() {
        return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX,"value");
    }

//    public AddressPageObject openAddressPage() {
//    //wait
//        waitForElementClickable(driver, CustomerInfoPageUI.ADDRESS_LINK);
//        //click
//        clickToElement(driver, CustomerInfoPageUI.ADDRESS_LINK);
//        return PageGenerator.getAddressPage(driver);
//    }
}
