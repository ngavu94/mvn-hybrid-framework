package pageFactory;

import commons.GlobalConstants;
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
    public void ClickToElement(WebElement element){
        element.click();
    }
    public void senkeyToElement(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
    public  void selectItemInDropdown(WebElement element, String textItem){
        new Select(element).selectByVisibleText(textItem);
    }
    public String getSelectedItemInDropdown(WebElement element){
        return new Select(element).getFirstSelectedOption().getText();
    }
    public void checkCheckboxOrRadioButton(WebElement element){
        if(!element.isSelected()){
            element.click();
        }
    }
    public String getElementAttribute(WebElement element, String attributeName){
        return  element.getAttribute(attributeName);
    }
    public String getElementText(WebElement element){
        return element.getText();
    }

    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public void waitForElementVisible(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementClickable(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickToElement(WebElement element){
        element.click();
    }


}
