package com.nopcomerce.user;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_III_Inheritence extends BasePage {
    WebDriver driver;
    BasePage basePage; //Declare
    String firstName, lastName, day, month, year, email, companyName, password;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        basePage = new BasePage(); //Initial
        driver.get("http://localhost/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        firstName = "nga";
        lastName ="vu";
        day="10";
        month="August";
        year="1990";
        email="ngavu"+generateNumber()+"@org.edu";
        companyName="viettel";
        password="123456789";
    }

    @Test
    public void TC_01_Register() {
        waitForElementClickable(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");
        //chon gioi tinh
        waitForElementClickable(driver, "//input[@id='gender-male']");
        clickToElement(driver, "//input[@id='gender-male']");

        sendkeysToElement(driver, "//input[@id='FirstName']",firstName);

        sendkeysToElement(driver, "//input[@id='LastName']",lastName);

//        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).deselectByVisibleText(day);
//        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).deselectByVisibleText(month);
//        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).deselectByVisibleText(year);
        sendkeysToElement(driver, "//input[@id='Email']",email);
        sendkeysToElement(driver, "//input[@id='Company']",companyName);
        sendkeysToElement(driver, "//input[@id='Password']",password);
        sendkeysToElement(driver, "//input[@id='ConfirmPassword']",password);

        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver, "//div[@class='result']"),"Your registration completed");
    }

    @Test
    public void TC_02_Login() {
        driver.findElement(By.cssSelector("a.ico-login")).click();

        driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.login-button")).click();

        waitForElementClickable(driver, "//a[@class='ico-login']");
        clickToElement(driver, "//a[@class='ico-login']");

        waitForElementVisible(driver, "//input[@id='Email']");
        sendkeysToElement(driver, "//input[@id='Email']",email);
        sendkeysToElement(driver, "//input[@id='Password']",password);
        ////button[@class='button-1 login-button']

        waitForElementClickable(driver, "//button[@class='button-1 login-button']");
        clickToElement(driver, "//button[@class='button-1 login-button']");
        Assert.assertTrue(getElement(driver,"//a[@class='ico-account' and text()='My account']").isDisplayed());
    }

    @Test
    public void TC_03_Access_MyAccount() {
        //customerInfoPageObject = new CustomerInfoPageObject();
        waitForElementVisible(driver,"//a[@class='ico-account' and text()='My account']");
        clickToElement(driver,"//a[@class='ico-account' and text()='My account']");
        isElementSelected(driver,"//input[@id='gender-male']");
        Assert.assertEquals(getElementAttribute(driver,"//input[@id='FirstName']","value"),firstName);
        Assert.assertEquals(getElementAttribute(driver,"//input[@id='LastName']","value"),lastName);
        Assert.assertEquals(getElementAttribute(driver,"//input[@id='Email']","value"),email);
        Assert.assertEquals(getElementAttribute(driver,"//input[@id='Company']","value"),companyName);
    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }

    private int generateNumber(){
        return new Random().nextInt(999);
    }
}
