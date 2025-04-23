package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.saucelab.ProductPageUIs;

public class ProductPageObject extends BasePage {
    private WebDriver driver;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemInSortDropdown(String sortItem) {
        waitForElementClickable(driver, ProductPageUIs.SORT_DROPDOWN);
        sleepInSeconds(3);
        selectItemInDropdown(driver, ProductPageUIs.SORT_DROPDOWN, sortItem);
    }


    public boolean isProductNameSortAscending() {
        waitForElementVisible(driver, ProductPageUIs.PRODUCT_NAME_TEXT);
        return isDataStringSortedAscending(driver, ProductPageUIs.PRODUCT_NAME_TEXT);
    }

    public boolean isProductNameSortDescending() {
        waitForElementVisible(driver, ProductPageUIs.PRODUCT_NAME_TEXT);
        return isDataStringSortedDescending(driver, ProductPageUIs.PRODUCT_NAME_TEXT);
    }

    public boolean isProductPriceSortAscending() {
        waitForElementVisible(driver, ProductPageUIs.PRODUCT_PRICE_TEXT);
        return isDataFloadSortedAscending(driver, ProductPageUIs.PRODUCT_PRICE_TEXT);
    }

    public boolean isProductPriceSortDescending() {
        waitForElementVisible(driver, ProductPageUIs.PRODUCT_PRICE_TEXT);
        return isDataFloadSortedDescending(driver, ProductPageUIs.PRODUCT_PRICE_TEXT);
    }
}
