package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class LoginPO {
    WebDriver driver;
    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToNewAccountButton() {
    }

    public void enterToEmailAdressTextbox(String mail) {
    }

    public boolean isConfirmEmailTextboxDisplayed() {
        return false;
    }
}
