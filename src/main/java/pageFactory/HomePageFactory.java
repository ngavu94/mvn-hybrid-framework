package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePage{
    WebDriver driver;

    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, HomePageFactory.class);
    }

    @FindBy(how = How.CLASS_NAME, using = "ico-register")
    private WebElement registerLink;

    @FindBy(className = "ico-account")
    private WebElement myAccountLink;


    public void clickToRegisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(registerLink);

    }

    public boolean isMyAccountLinkDisplayed() {
        return  isElementDisplayed( myAccountLink);
    }


    public void clickToMyaccountLink() {
        waitForElementClickable(driver, myAccountLink);
    }
}
