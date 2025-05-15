package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.nopCommerce.BasePageUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class BasePage {
    public static BasePage getBasePage() {
        return new BasePage();
    }

    public void clickToElement(WebDriver driver) {
        driver.findElement(By.cssSelector("")).click();
    }

    public String getElementText(WebDriver driver) {
        return driver.findElement(By.xpath("")).getText();
    }

    public boolean isElementDisplayed(WebDriver driver) {
        return driver.findElement(By.xpath("")).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).isDisplayed();
    }

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void senkeyToAlert(WebDriver driver, String keysToSend) {
        waitAlertPresence(driver).sendKeys(keysToSend);
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(parentID);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            driver.switchTo().window(runWindow);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow).close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListElements(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElements(WebDriver driver, String locator, String... restParameter) {
        return driver.findElements(getByLocator(castParameter(locator, restParameter)));
    }

    private String castParameter(String locator, String... restParameter) {
        return String.format(locator, (Object[]) restParameter);
    }

    //Truyền tham số loại gì, sẽ trả về locator tương ứng
    //String prefix: cc/id/class/name => By.css, By.id, By.class...
    public By getByLocator(String prefixLocator) {
        By by = null;
        if (prefixLocator.toUpperCase().startsWith("ID")) {
            by = By.id(prefixLocator.substring(3));
        } else if (prefixLocator.toUpperCase().startsWith("CLASS")) {
            by = By.className(prefixLocator.substring(6));
        } else if (prefixLocator.toUpperCase().startsWith("NAME")) {
            by = By.name(prefixLocator.substring(5));
        } else if (prefixLocator.toUpperCase().startsWith("TAGNAME")) {
            by = By.tagName(prefixLocator.substring(8));
        } else if (prefixLocator.toUpperCase().startsWith("CSS")) {
            by = By.cssSelector(prefixLocator.substring(4));
        } else if (prefixLocator.toUpperCase().startsWith("XPATH")) {
            by = By.xpath(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Locator type is not support!!!");
        }
//        System.out.println(by);
        return by;
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParameter) {
        getElement(driver, castParameter(locator, restParameter)).click();
    }

    public void sendkeysToElement(WebDriver driver, String locator, String textInput) {
        //Nếu 1 element là thẻ input bị ẩn thì clear sẽ bị lỗi trên firefox
        //getElement(driver, locator).clear();
        Keys key = null;
        if (GlobalConstants.OS_NAME.startsWith("Window")) {
            key = Keys.CONTROL;
        } else {
            key = Keys.COMMAND;
        }
        getElement(driver, locator).sendKeys(Keys.chord(key, "a", Keys.BACK_SPACE));
        getElement(driver, locator).sendKeys(textInput);
    }

    public void sendkeysToElement(WebDriver driver, String locator, String textInput, String... restParameter) {
        getElement(driver, castParameter(locator, restParameter)).clear();
        getElement(driver, castParameter(locator, restParameter)).sendKeys(textInput);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String textItem) {
        new Select(getElement(driver, locator))
                .selectByVisibleText(textItem);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String textItem, String... restParameter) {
        new Select(getElement(driver, castParameter(locator, restParameter)))
                .selectByVisibleText(textItem);
    }

    public String getSelectedItemInDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator))
                .getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        driver.findElement(getByLocator(parentLocator)).click();
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    public void sleepInSeconds(long timeSecond) {
        try {
            Thread.sleep(timeSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getAttribute(attributeName);
    }

    public Dimension getElementSize(WebDriver driver, String locator) {
        return getElement(driver, locator).getSize();
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getText();
    }

    public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListElementNumber(WebDriver driver, String locator) {
        return getListElements(driver, locator).size();
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... restParameter) {
        if (!getElement(driver, castParameter(locator, restParameter)).isSelected()) {
            getElement(driver, castParameter(locator, restParameter)).click();
        }
    }

    public void unCheckToCheckbox(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void unCheckToCheckbox(WebDriver driver, String locator, String... restParameter) {
        if (getElement(driver, castParameter(locator, restParameter)).isSelected()) {
            getElement(driver, castParameter(locator, restParameter)).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isElementSelected(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).isSelected();
    }

    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public void switchToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToDefaultPage(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    public void clickAndHoldToElement(WebDriver driver, String locator) {
        new Actions(driver).clickAndHold(getElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getElement(driver, locator), key).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... restParameter) {
        new Actions(driver).sendKeys(getElement(driver, castParameter(locator, restParameter)), key).perform();
    }

    public void hightlightElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator));
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public boolean waitForListElementVisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator, restParameter))));
    }


    public void waitForElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator, String restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator, restParameter))));
    }

    public void waitForElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public void waitForElementInVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator, restParameter))));
    }


    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName += filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);


    }

    //this function used for the OrangeHRM project
    public boolean waitAllLoadingIconInvisible(WebDriver driver) {
        return waitForListElementVisible(driver, BasePageUI.LOADING_ICONS);

    }

    public boolean isSuccessMessageDisplayed(WebDriver driver) {
        waitForElementVisible(driver, BasePageUI.SUCCESS_MESSAGE);
        System.out.println("qua step verify message");
        return isElementDisplayed(driver, BasePageUI.SUCCESS_MESSAGE);
    }

    //Sort Ascending (String)
    public boolean isDataStringSortedAscending(WebDriver driver, String locator) {
        //Khai báo 1 Array List
        ArrayList<String> arrayList = new ArrayList<>();

        //Tìm tất cả element matching vs điều kiện (Name/Price/..)
        List<WebElement> elementList = driver.findElements(getByLocator(locator));

        //Lấy text của từng element add vào ArrayList

        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }
        System.out.println("-------------Dữ liệu trên UI:---------------");

        for (String name : arrayList) {
            System.out.println(name);
        }

        //Copy qua 1 array list mới để SORT trong Code

        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrayList) {
            sortedList.add(child);
        }

        //Thực hiện SORT ASC
        Collections.sort(sortedList);

        System.out.println("------------Dữ liệu đã SORT ASC trong code:-------------");
        for (String name : sortedList) {
            System.out.println(name);
        }

        return sortedList.equals(arrayList);
    }

    //Sort Descending (String)
    public boolean isDataStringSortedDescending(WebDriver driver, String locator) {
        //Khai báo 1 Array List
        ArrayList<String> arrayList = new ArrayList<>();

        //Tìm tất cả element matching vs điều kiện (Name/Price/..)
        List<WebElement> elementList = driver.findElements(getByLocator(locator));

        //Lấy text của từng element add vào ArrayList

        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }
        System.out.println("-------------Dữ liệu trên UI:---------------");

        for (String name : arrayList) {
            System.out.println(name);
        }

        //Copy qua 1 array list mới để SORT trong Code

        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrayList) {
            sortedList.add(child);
        }

        //Thực hiện SORT ASC
        Collections.sort(sortedList);
        System.out.println("------------Dữ liệu đã SORT ASC trong code:-------------");
        for (String name : sortedList) {
            System.out.println(name);
        }
        //Reverse data để sort DESC
        Collections.reverse(sortedList);

        System.out.println("------------Dữ liệu đã SORT DESC trong code:-------------");
        for (String name : sortedList) {
            System.out.println(name);
        }
        return sortedList.equals(arrayList);
    }

    public boolean isDataFloadSortedAscending(WebDriver driver, String locator) {

// Khai báo 1 arrayList
        ArrayList<Float> arrayList = new ArrayList<Float>();

        //Tìm tất cả element matching với điều kiện (Name/Price...)
        List<WebElement> elementList = driver.findElements(getByLocator(locator));
        System.out.println(elementList);

        //Lấy text của từng element add vào ArrayList
        for (WebElement element : elementList) {
            arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
            System.out.println(element);
        }
        System.out.println("--------------Dữ liệu trên UI:---------------");
        for (Float name : arrayList) {
            System.out.println(name);
        }
        //Copy qua 1 arrayList mới để SORT trong Code

        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : arrayList) {
            sortedList.add(child);
        }
        //Thực hiện sort asc
        Collections.sort(sortedList);
        System.out.println("------------Dữ liệu đã SORT trong code:-------------");
        for (Float name : sortedList) {
            System.out.println(name);
        }
        //Verify 2 array = nhau, nếu dữ liệu sort trên UI ko chính xác thì kq trả về false

        return sortedList.equals(arrayList);
    }
    public boolean isDataFloadSortedDescending(WebDriver driver, String locator) {

// Khai báo 1 arrayList
        ArrayList<Float> arrayList = new ArrayList<Float>();

        //Tìm tất cả element matching với điều kiện (Name/Price...)
        List<WebElement> elementList = driver.findElements(getByLocator(locator));

        //Lấy text của từng element add vào ArrayList
        for (WebElement element : elementList) {
            arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
        }
        System.out.println("--------------Dữ liệu trên UI:---------------");
        for (Float name : arrayList) {
            System.out.println(name);
        }
        //Copy qua 1 arrayList mới để SORT trong Code

        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : arrayList) {
            sortedList.add(child);
        }
        //Thực hiện sort asc
        Collections.sort(sortedList);
        //sx ngược lại
        Collections.reverse(sortedList);
        System.out.println("------------Dữ liệu đã SORT DESC trong code:-------------");
        for (Float name : sortedList) {
            System.out.println(name);
        }
        //Verify 2 array = nhau, nếu dữ liệu sort trên UI ko chính xác thì kq trả về false

        return sortedList.equals(arrayList);
    }

    public boolean isDataDateSortedAscending(WebDriver driver, String locator) {
        // Khai báo 1 arrayList
        ArrayList<Date> arrayList = new ArrayList<Date>();

        //Tìm tất cả element matching với điều kiện (Name/Price...)
        List<WebElement> elementList = driver.findElements(By.xpath(locator));

        //Lấy text của từng element add vào ArrayList
        for (WebElement element : elementList) {
            arrayList.add(convertStringToDate(element.getText()));
        }
        System.out.println("--------------Dữ liệu trên UI:---------------");
        for (Date name : arrayList) {
            System.out.println(name);
        }
        //Copy qua 1 arrayList mới để SORT trong Code

        ArrayList<Date> sortedList = new ArrayList<Date>();
        for (Date child : arrayList) {
            sortedList.add(child);
        }
        //Thực hiện sort asc
        Collections.sort(sortedList);
        System.out.println("------------Dữ liệu đã SORT trong code:-------------");
        for (Date name : sortedList) {
            System.out.println(name);
        }
        //Verify 2 array = nhau, nếu dữ liệu sort trên UI ko chính xác thì kq trả về false

        return sortedList.equals(arrayList);
    }

    public Date convertStringToDate(String dateInString) {
        dateInString = dateInString.replace(",", "");
        SimpleDateFormat format = new SimpleDateFormat("MMM dd yyyy");
        Date date = null;
        try {
            date = format.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
