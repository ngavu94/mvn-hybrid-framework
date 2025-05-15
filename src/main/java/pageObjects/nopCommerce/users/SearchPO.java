package pageObjects.nopCommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.SearchPageUI;

public class SearchPO extends BasePage {

    private WebDriver driver;

    public SearchPO(WebDriver driver){
        this.driver = driver;
    }

    public void enterToSearchTextbox(String value) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
        sendkeysToElement(driver,SearchPageUI.SEARCH_TEXTBOX,value);
    }

    public void clickSearchButton() {
        waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
    }
}
