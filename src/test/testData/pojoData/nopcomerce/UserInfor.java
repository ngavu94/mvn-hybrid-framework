package pojoData.nopcomerce;

public class UserInfor {
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String companyName;
    private String password;
    public static UserInfor getUser(){
        return new UserInfor();
    }

    public String getEmailAddress(){
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
}
