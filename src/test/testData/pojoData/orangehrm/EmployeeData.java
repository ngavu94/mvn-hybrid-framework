package pojoData.orangehrm;

import pageObjects.orangeHRM.pim.employee.EmployeeTabs;

public class EmployeeData {
    private String employeeID;
    private String addFirstName;
    private String addMiddleName;
    private String addLastName;
    private String editFirstName;
    private String editMiddleName;
    private String editLastName;
    private String editDriverLicenseNumber;
    private String editLicenseExpireDate;
    private String editNationality;
    private String editMaritalStatus;
    private String editDateOfBirth;

    //Contact Detail
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String workEmail;


    public static EmployeeData getEmployeeData() {
        return new EmployeeData();
    }

    //Add
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getAddFirstName() {
        return addFirstName;
    }

    public void setAddFirstName(String addFirstName) {
        this.addFirstName = addFirstName;
    }

    public String getAddLastName() {
        return addLastName;
    }

    public void setAddLastName(String addLastName) {
        this.addLastName = addLastName;
    }

    public String getAddMiddleName() {
        return addMiddleName;
    }

    public void setAddMiddleName(String addMiddleName) {
        this.addMiddleName = addMiddleName;
    }

    //Edit
    public String getEditFirstName() {
        return editFirstName;
    }

    public void setEditFirstName(String editFirstName) {
        this.editFirstName = editFirstName;
    }

    public String getEditMiddleName() {
        return editMiddleName;
    }

    public void setEditMiddleName(String editMiddleName) {
        this.editMiddleName = editMiddleName;
    }

    public String getEditLastName() {
        return editLastName;
    }

    public void setEditLastName(String editLastName) {
        this.editLastName = editLastName;
    }

    public String getEditDriverLicenseNumber() {
        return editDriverLicenseNumber;
    }

    public void setEditDriverLicenseNumber(String editDriverLicenseNumber) {
        this.editDriverLicenseNumber = editDriverLicenseNumber;
    }

    public String getEditLicenseExpireDate() {
        return editLicenseExpireDate;
    }

    public void setEditLicenseExpireDate(String editLicenseExpireDate) {
        this.editLicenseExpireDate = editLicenseExpireDate;
    }

    public String getEditNationality() {
        return editNationality;
    }

    public void setEditNationality(String editNationality) {
        this.editNationality = editNationality;
    }

    public String getEditDateOfBirth() {
        return editDateOfBirth;
    }

    public void setEditDateOfBirth(String editDateOfBirth) {
        this.editDateOfBirth = editDateOfBirth;
    }

    public String getEditMaritalStatus() {
        return editMaritalStatus;
    }

    public void setEditMaritalStatus(String editMaritalStatus) {
        this.editMaritalStatus = editMaritalStatus;
    }

    //Contract Detail
    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

}
