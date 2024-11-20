package com.jquerry.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquerry.HomePO;
import pageObjects.jquerry.PageGenerator;

import java.time.Duration;

public class Level_11_DataTable extends BaseTest {
    WebDriver driver;
    HomePO homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String urlName) {
        driver = getBrowserDriver(browserName, urlName);
        homePage = PageGenerator.getHomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

     @Test(groups = {"regression","pim","employee"})
    public void Table_01_Paging() {
        //Navigate to any page
        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageNumberActive("15"));
        //Navigate to any page
        homePage.openPageByNumber("5");
        Assert.assertTrue(homePage.isPageNumberActive("5"));

        //Navigate to any page
        homePage.openPageByNumber("10");
        Assert.assertTrue(homePage.isPageNumberActive("10"));
    }

   // @Test
    public void Table_02_Search_And_Verify() {
        //Enter value to header
        homePage.enterToTextboxByHearderName("Country", "Algeria");
        homePage.sleepInSeconds(3);
        //Verify data in first row
        Assert.assertTrue(homePage.isRowDataValueDisplayed("283821", "Algeria", "295140", "578961"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHearderName("Females", "12253515");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("12253515", "AFRICA", "12599691", "24853148"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHearderName("Males", "276472");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("276880", "Angola", "276472", "553353"));
        homePage.refreshCurrentPage(driver);
    }

    //@Test
    public void Table_03_Edit_Delete() {
        //Delete a row
        //Search theo country
        homePage.enterToTextboxByHearderName("Country", "Algeria");
        homePage.sleepInSeconds(2);
        homePage.deleteRowByCountryName("Algeria");
        homePage.refreshCurrentPage(driver);

        //Search theo country
        homePage.enterToTextboxByHearderName("Country", "Angola");
        homePage.sleepInSeconds(2);
        homePage.deleteRowByCountryName("Angola");
        homePage.refreshCurrentPage(driver);

        //Edit a row
        homePage.enterToTextboxByHearderName("Country", "Armenia");
        homePage.sleepInSeconds(3);
        homePage.editRowByCountryName("Armenia");
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHearderName("Country", "Guatemala");
        homePage.sleepInSeconds(3);
        homePage.editRowByCountryName("Guatemala");
        homePage.refreshCurrentPage(driver);


    }
    @Test
    public void Table_04_Action_By_Index() {
        //Delete a row
        //Search theo country
        homePage.openPageUrl(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        //Có thể thao tác với bất kỳ row, column nào
        homePage.clickToLoadDataButton();
//        homePage.enterToTextboxByIndex("4","Contact Person", "Michael Jacson");
//        homePage.sleepInSeconds(2);
//        homePage.enterToTextboxByIndex("5","Company", "MJ Company");
//        homePage.sleepInSeconds(2);
//        homePage.enterToTextboxByIndex("3","Company", "MJ Company");
//        homePage.sleepInSeconds(2);
//        homePage.selectToDropdownByIndex("6","Country", "Hong Kong");
//        homePage.selectToDropdownByIndex("7","Country", "Japan");
//        homePage.checkToCheckboxByIndex("7","NPO?");
//        homePage.unCheckToCheckboxByIndex("7","NPO?");
        homePage.clickToIconByIndex("4","Move Up");
        homePage.clickToIconByIndex("5","Remove");
        homePage.clickToIconByIndex("5","Insert");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
