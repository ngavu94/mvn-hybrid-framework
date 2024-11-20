package pageObjects.jquerry;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquerry.HomePageUI;

import java.util.List;

public class HomePO extends BasePage {
    WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        sleepInSeconds(2);
    }

    public boolean isPageNumberActive(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        return getElementAttribute(driver, HomePageUI.DYNAMIC_PAGE_LINK, "class", pageNumber).endsWith("active");
    }

    public void enterToTextboxByHearderName(String headerName, String valueToSenkey) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, headerName);
        senkeysToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, valueToSenkey, headerName);
        pressKeyToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER,headerName);

    }

    public boolean isRowDataValueDisplayed(String females, String country, String males, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_DATA_ROW,females,country,males,total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_DATA_ROW,females,country,males,total);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementClickable(driver,HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME,countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY_NAME,countryName);
    }

    public void editRowByCountryName(String countryName) {
        waitForElementClickable(driver,HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME,countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY_NAME,countryName);
    }

    public void clickToLoadDataButton() {
        //wait
        waitForElementClickable(driver,HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver,HomePageUI.LOAD_DATA_BUTTON);

    }

    public void enterToTextboxByIndex(String rowIndex, String colName, String valueToSenkey) {
        //Từ columnName làm sao để lấy được column index
        int colIndexNumber= getListElements(driver,HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER,colName).size()+1;
        //convert nó qua dạng string
        String colIndex = String.valueOf(colIndexNumber) ;
        //Truyền 2 giá trị rowIndex và colIndex vào locator để xử lý
        senkeysToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX,valueToSenkey,rowIndex,colIndex);
    }

    public void selectToDropdownByIndex(String rowIndex, String colName, String valueToSelect) {
//Từ columnName làm sao để lấy được column index
        int colIndexNumber= getListElements(driver,HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER,colName).size()+1;
        //convert nó qua dạng string
        String colIndex = String.valueOf(colIndexNumber) ;
        //Truyền 2 giá trị rowIndex và colIndex vào locator để tương tác và select giá trị
        selectItemInDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX,valueToSelect,rowIndex, colIndex);
//        selectItemInDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX_2,valueToSelect,rowIndex, colIndex);
    }

    public void checkToCheckboxByIndex(String rowIndex, String colName) {
        int colIndexNumber= getListElements(driver,HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER,colName).size()+1;
        //convert nó qua dạng string
        String colIndex = String.valueOf(colIndexNumber) ;
        //Truyền 2 giá trị rowIndex và colIndex vào locator để tương tác và select giá trị
        checkToCheckboxOrRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX,rowIndex, colIndex);
    }
    public void unCheckToCheckboxByIndex(String rowIndex, String colName) {
        int colIndexNumber= getListElements(driver,HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER,colName).size()+1;
        //convert nó qua dạng string
        String colIndex = String.valueOf(colIndexNumber) ;
        //Truyền 2 giá trị rowIndex và colIndex vào locator để tương tác và select giá trị
        unCheckToCheckbox(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX,rowIndex, colIndex);
    }

    public void clickToIconByIndex(String rowIndex, String iconName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_INDEX, rowIndex, iconName);
        clickToElement(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_INDEX, rowIndex, iconName);
    }

    public boolean isFileLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_LOADING_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_LOADING_BY_FILE_NAME, fileName);
    }

    public void clickToUploadButton(WebDriver driver) {
//        waitForElementClickable(driver, HomePageUI.UPLOAD_BUTTON);
//        clickToElement(driver, HomePageUI.UPLOAD_BUTTON);
        List<WebElement> listElement = getListElements(driver, HomePageUI.UPLOAD_BUTTON);
        for (WebElement uploadButton: listElement){
            uploadButton.click();
            sleepInSeconds(3);
        }
    }

    public boolean isFileUploadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_UPLOAD_SUCCESS, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_UPLOAD_SUCCESS, fileName);
    }
}
