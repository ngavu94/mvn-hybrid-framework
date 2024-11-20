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

public class Level_02_BasePage_II_StaticMethod {
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
        BasePage basePage = BasePage.getBasePage();
    }

    @Test
    public void TC_01_Register() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        //chon gioi tinh
        basePage.waitForElementClickable(driver, "//input[@id='gender-male']");
        basePage.clickToElement(driver, "//input[@id='gender-male']");

        basePage.senkeysToElement(driver, "//input[@id='FirstName']",firstName);

        basePage.senkeysToElement(driver, "//input[@id='LastName']",lastName);

//        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).deselectByVisibleText(day);
//        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).deselectByVisibleText(month);
//        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).deselectByVisibleText(year);
        basePage.senkeysToElement(driver, "//input[@id='Email']",email);
        basePage.senkeysToElement(driver, "//input[@id='Company']",companyName);
        basePage.senkeysToElement(driver, "//input[@id='Password']",password);
        basePage.senkeysToElement(driver, "//input[@id='ConfirmPassword']",password);

        basePage.waitForElementClickable(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"),"Your registration completed");
    }

    @Test
    public void TC_02_Login() {
//        driver.findElement(By.cssSelector("a.ico-login")).click();
//
//        driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
//        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
//        driver.findElement(By.cssSelector("button.login-button")).click();

        basePage.waitForElementClickable(driver, "//a[@class='ico-login']");
        basePage.clickToElement(driver, "//a[@class='ico-login']");

        basePage.waitForElementVisible(driver, "//input[@id='Email']");
        basePage.senkeysToElement(driver, "//input[@id='Email']",email);
        basePage.senkeysToElement(driver, "//input[@id='Password']",password);
        ////button[@class='button-1 login-button']

        basePage.waitForElementClickable(driver, "button[@class='button-1 login-button']");
        basePage.clickToElement(driver, "button[@class='button-1 login-button']");
        Assert.assertTrue(basePage.getElement(driver,"//a[@class='ico-account' and text()='My account']").isDisplayed());
    }

    @Test
    public void TC_03_Access_MyAccount() {
        basePage.waitForElementVisible(driver,"//a[@class='ico-account' and text()='My account']");
        basePage.clickToElement(driver,"//a[@class='ico-account' and text()='My account']");
        basePage.isElementSelected(driver,"//input[@id='gender-male']");
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='FirstName']","value"),firstName);
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='LastName']","value"),lastName);
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='Email']","value"),email);
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='Company']","value"),companyName);
    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }

    private int generateNumber(){
        return new Random().nextInt(999);
    }
}
