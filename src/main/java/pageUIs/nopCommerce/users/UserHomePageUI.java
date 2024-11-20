package pageUIs.nopCommerce.users;

public class UserHomePageUI {
    public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
    public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
    public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account' and text()='My account']";
    //Biến non-static bắt buộc phải khởi tạo đối tượng hoặc kế thừa ms gọi đc
    //Biến static cho phép gọi trực tiếp từ tên class
    public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
    public static String REGISTER_PAGE_TITLE;
}
