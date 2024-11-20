package pageUIs.orangeHRM.pim.employee;

public class ContactDetailPageUI {
    public static final String STREET_1_TEXTBOX = "xpath=//label[text()='Street 1']/parent::div/following-sibling::div/input";
    public static final String STREET_2_TEXTBOX = "xpath=//label[text()='Street 2']/parent::div/following-sibling::div/input";
    public static final String CITY_TEXTBOX = "xpath=//label[text()='City']/parent::div/following-sibling::div/input";
    public static final String STATE_PROVINCE_TEXTBOX = "xpath=//label[text()='State/Province']/parent::div/following-sibling::div/input";
    public static final String ZIP_POSTAL_CODE_TEXTBOX = "xpath=//label[text()='Zip/Postal Code']/parent::div/following-sibling::div/input";
    public static final String COUNTRY_DROPDOWN_PARENT = "xpath=//label[text()='Country']/parent::div/following-sibling::div//i";
    public static final String COUNTRY_DROPDOWN_CHILD = "xpath=//label[text()='Country']/parent::div/following-sibling::div//div[@role='listbox']/div/span";
    public static final String COUNTRY_DROPDOWN_SELECTED = "xpath=//label[text()='Country']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String HOME_PHONE_TEXTBOX = "xpath=//label[text()='Home']/parent::div/following-sibling::div/input";
    public static final String MOBILE_PHONE_TEXTBOX = "xpath=//label[text()='Mobile']/parent::div/following-sibling::div/input";
    public static final String WORK_PHONE_TEXTBOX = "xpath=//label[text()='Work']/parent::div/following-sibling::div/input";
    public static final String WORK_EMAIL_TEXTBOX = "xpath=//label[text()='Work Email']/parent::div/following-sibling::div/input";
    public static final String SAVE_BUTTON_IN_CONTACT_DETAIL = "xpath=//div[contains(@class,'padding')]//div[@class='oxd-form-actions']/button";

}
