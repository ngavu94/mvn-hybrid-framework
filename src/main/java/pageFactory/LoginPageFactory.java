package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage{
    WebDriver driver;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,LoginPageFactory.class);
    }

    @FindBy(id="Email")
    private WebElement email;

    @FindBy(id="Password")
    private WebElement password;

    @FindBy(className="button-1 login-button")
    private WebElement loginButton;

    public void enterToEmailTextbox(String keyToSend) {
        waitForElementVisible(driver, email);
        senkeyToElement(email, keyToSend);
    }

    public void enterToPasswordTextbox(String keyToSend) {
        waitForElementVisible(driver, password);
        senkeyToElement(password, keyToSend);
    }
    public void clickLoginToSystem() {
        waitForElementClickable(driver, loginButton);
        clickToElement(loginButton);
    }
}
