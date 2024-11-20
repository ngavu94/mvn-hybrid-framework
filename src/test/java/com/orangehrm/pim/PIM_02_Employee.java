package com.orangehrm.pim;

import com.fasterxml.jackson.databind.ser.Serializers;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM_02_Employee extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

    }

    @Test(groups = {"regression","pim","employee"})
    public void Employee_06_Dependencies() {

    }
    @Test
    public void Employee_07_Immigrations() {

    }
    @Test
    public void Employee_08_Jobs() {

    }
    @Test
    public void Employee_09_Salary() {

    }
    @Test
    public void Employee_10_ReportTo() {

    }
    @Test
    public void Employee_11_Qualifications() {

    }

    @AfterClass
    public void afterClass() {
        closeBrowerDriver();
    }

    WebDriver driver;
}
