package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.configuration.*;
import pageObjects.orangeHRM.pim.employee.*;

public class PageGenerator {
    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static DashboardPO getDashboardPage(WebDriver driver) {
        return new DashboardPO(driver);
    }

    public static AddNewEmployeePO getAddNewEmployeePage(WebDriver driver) {
        return new AddNewEmployeePO(driver);
    }

    public static ContactDetailPO getContactDetailPage(WebDriver driver) {
        return new ContactDetailPO(driver);
    }

    public static EmployeeListPO getEmployeeListPage(WebDriver driver) {
        return new EmployeeListPO(driver);
    }

    public static PersonalDetailPO getPersonalDetailPage(WebDriver driver) {
        return new PersonalDetailPO(driver);
    }
    public static EmergencyContactsPO getEmergencyPage(WebDriver driver) {
        return new EmergencyContactsPO(driver);
    }

    //configurations
    public static CustomFieldPO getCustomFieldPage(WebDriver driver) {
        return new CustomFieldPO(driver);
    }

    public static DataImportPO getDataImportPage(WebDriver driver) {
        return new DataImportPO(driver);
    }

    public static OptionalFieldPO getOptionalFieldPage(WebDriver driver) {
        return new OptionalFieldPO(driver);
    }

    public static ReportingMethodPO getReportingMethodPage(WebDriver driver) {
        return new ReportingMethodPO(driver);
    }

    public static TerminationReasonPO getTerminationReasonPage(WebDriver driver) {
        return new TerminationReasonPO(driver);
    }
    //report
//    public static AddNewPO getAddNewReportPage(WebDriver driver){
//        return new AddNewPO(driver);

}
