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

public class Level_12_UploadFile extends BaseTest {
    WebDriver driver;
    HomePO homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String urlName) {
        driver = getBrowserDriver(browserName, urlName);
        homePage = PageGenerator.getHomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

     @Test
    public void Upload_01() {
        //Lấy ra đường dẫn của file, thư mục cho đúng
        //Tất cả các OS: Window/ MAC/ Linux đều chạy được

        //Có thể upload 1 lần 1 file
        homePage.uploadMultipleFiles(driver,fileName01);
        homePage.sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);

        //Có thể upload 1 lần nhiều file
        homePage.uploadMultipleFiles(driver,fileName01,fileName02);
        homePage.sleepInSeconds(3);
         homePage.refreshCurrentPage(driver);

        homePage.uploadMultipleFiles(driver,fileName01,fileName02,fileName03);
        homePage.sleepInSeconds(3);
        //Verify việc load file lên
       Assert.assertTrue(homePage.isFileLoadedByName(fileName01));
       Assert.assertTrue(homePage.isFileLoadedByName(fileName02));
       Assert.assertTrue(homePage.isFileLoadedByName(fileName03));
         //Click upload button tại từng file
        homePage.clickToUploadButton(driver);

        //Có thể verify dùng 1 hàm
         homePage.isFileUploadedByName(fileName01);
         homePage.isFileUploadedByName(fileName02);
         homePage.isFileUploadedByName(fileName03);


        //Ko cần care- cách đang làm ko cần đụng tới open file dailog


    }

    @Test
    public void Table_04_Action_By_Index() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    String fileName01 ="image01.png";
    String fileName02 ="image02.png";
    String fileName03 ="image03.png";
}
