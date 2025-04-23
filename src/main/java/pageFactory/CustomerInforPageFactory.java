package pageFactory;

import org.openqa.selenium.WebDriver;

public class CustomerInforPageFactory {
    WebDriver driver;

    public CustomerInforPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public double getFirstNameTextboxValue() {
        return  1;
    }

    public boolean isGenderMaleSelected() {
    }

    public byte[] getLastNameTextboxValue() {
    }

    public String  getEmailTextboxValue() {
        return null;
    }

    public String getCompanyNameTextboxValue() {
        return  null;
    }
}
