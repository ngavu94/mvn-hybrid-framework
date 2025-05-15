package pageUIs.bipower;


public class LoginPageUI {
    public static final String EMAIL_TEXTBOX = "id=email";
    public static final String PASSWORD_TEXTBOX = "id=password";
//    public static final String LOGIN_BUTTON = "xpath=//button[text()='Login']";
    public static final String LOGIN_BUTTON = "xpath=//button[text()='Đăng nhập']";

    public static final String LINK_NAME = "xpath=//span[@class='link_name text-black']"; // giả sử logout button xuất hiện khi login thành công
    public static final String LOGOUT_BUTTON = "id=logoutButton"; // giả sử logout button xuất hiện khi login thành công
    public static final String EMAIL_ERROR_MESSAGE = "xpath=//input[@id='email']/parent::div/div/div"; // giả sử error message khi login fail
    public static final String PASSWORD_ERROR_MESSAGE = "xpath=//input[@id='password']/parent::div/parent::div/div[2]/div"; // giả sử error message khi login fail

}

