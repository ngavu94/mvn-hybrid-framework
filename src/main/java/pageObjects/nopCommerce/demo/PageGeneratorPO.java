package pageObjects.nopCommerce.demo;

import org.openqa.selenium.WebDriver;

public class PageGeneratorPO {
    WebDriver driver;
    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static MyAccountPageObject getMyAccount(WebDriver driver){
        return new MyAccountPageObject(driver);
    }
}
