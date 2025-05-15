package pageObjects.bipower;

import org.openqa.selenium.WebDriver;
import pageObjects.bipower.timekeeping.overtime.RegisterOvertimePO;
import pageObjects.bipower.LoginPO;


public class PageGenerator {
    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static presencePO getPresencePage(WebDriver driver) {
        return new presencePO(driver);
    }

    public static RegisterOvertimePO getRegisterOvertimePage(WebDriver driver) {
        return new RegisterOvertimePO(driver);
    }



}


