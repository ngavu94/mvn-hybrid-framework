package pageUIs.orangeHRM.pim.employee;

public class PersonalDetailPageUI {
    public static final String AVATAR_IMG = "xpath=//div[@class='orangehrm-edit-employee-image']/img[@class='employee-image']";
    public static final String SAVE_BUTTON_AT_EDIT_PROFILE_CONTAINER = "xpath=//div[@class='orangehrm-edit-employee-content']//button[@type='submit']";
    //public static final String SUCCESS_MESSAGE_UPLOAD_AVATAR="xpath=//div[@id='oxd-toaster_1']//p[contains(@class,'oxd-text--toast-message')]";
    public static final String FIRST_NAME_TEXTBOX = "css=input[name='firstName']";
    public static final String MIDDLE_NAME_TEXTBOX = "css=input[name='middleName']";
    public static final String LAST_NAME_TEXTBOX = "css=input[name='lastName']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String DRIVER_LICENCE_NUMBER_TEXTBOX = "xpath=//label[contains(text(),'License Number')]/parent::div/following-sibling::div/input";
    public static final String LICENCE_EXPIRY_DATE_TEXTBOX = "xpath=//label[contains(text(),'License Expiry')]/parent::div/following-sibling::div//input";
    public static final String NATIONALITY_DROPDOWN_PARENT = "xpath=//label[contains(text(),'Nationality')]/parent::div/following-sibling::div//i";
    public static final String NATIONALITY_DROPDOWN_SELECTED = "xpath=//label[contains(text(),'Nationality')]/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String NATIONALITY_DROPDOWN_CHILD = "xpath=//label[contains(text(),'Nationality')]/parent::div/following-sibling::div//div[@class='oxd-select-option']";
    public static final String MARITAL_STATUS_DROPDOWN_PARENT = "xpath=//label[contains(text(),'Marital')]/parent::div/following-sibling::div//i";
    public static final String MARITAL_STATUS_DROPDOWN_CHILD = "xpath=//label[contains(text(),'Marital')]/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]";
    public static final String MARITAL_STATUS_DROPDOWN_SELECTED = "xpath=//label[contains(text(),'Marital')]/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String DATE_OF_BIRTH_TEXTBOX = "xpath=//label[contains(text(),'Birth')]/parent::div/following-sibling::div//input";
    public static final String GENDER_RADIO_BUTTON = "xpath=//label[text()='Gender']/parent::div/following-sibling::div//label[contains(string(),'%s')]/span";
    public static final String GENDER_RADIO_BUTTON_SELECTED = "xpath=//label[text()='Gender']/parent::div/following-sibling::div//label[contains(string(),'%s')]/input";

    public static final String SAVE_BUTTON = "xpath=//h6[text()='Personal Details']/parent::div//button[@type='submit']";

}
