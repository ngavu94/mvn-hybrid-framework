package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageFactory extends BasePage{
    WebDriver driver;

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "gender-male")
    private WebElement maleGender;

    @FindBy(id = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Company")
    private WebElement companyName;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;

    public void clickToMaleRadio() {
        waitForElementClickable(driver, maleGender);
        checkCheckboxOrRadioButton(maleGender);
    }

    public void enterToFirstNameTextbox(String firstName) {

    }

    public void enterToLastNameTextbox(String lastName) {
    }

    public void enterToEmailTextbox(String email) {
    }

    public void enterToCompanyTextbox(String companyName) {
    }

    public void enterToPasswordTextbox(String password) {
    }

    public void enterToPasswordConfirmTextbox(String password) {
    }

    public void clickRegisterButton() {
    }

    public String getRegisterSuccessMessage() {
        return null;
    }

    public void clickToLogoutButton() {
    }

    public void clickToLoginButton() {
    }
}
