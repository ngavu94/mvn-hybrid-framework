package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    protected final Logger log ;
    public BaseTest(){
        log = LoggerFactory.getLogger(getClass());

    }
    public WebDriver getDriver() {
        return driver;
    }

    private String projectPath=System.getProperty("user.dir");
    protected int generateNumber(){
        return new Random().nextInt(999);
    }
    public WebDriver getBrowserDriver(String browserName){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver",projectPath+"\\browserDriver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver",projectPath+"\\browserDriver\\chromdriver.exe");
                driver = new ChromeDriver();
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver",projectPath+"\\browserDriver\\msedgedriver.exe");
                driver= new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser Name is not valid");
        }
        driver.get("http://localhost/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.GLOBAL_TIMEOUT));
        return driver;
    }
    public WebDriver getBrowserDriver(String browserName, String url){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver",projectPath+"\\browserDriver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver",projectPath+"\\browserDriver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver",projectPath+"\\browserDriver\\msedgedriver.exe");
                driver= new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser Name is not valid");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.GLOBAL_TIMEOUT));
        driver.manage().window().maximize();
        return driver;
    }

    protected boolean verifyTrue(boolean condition){
        boolean status = true;
        try{

            Assert.assertTrue(condition);
            log.info("---------------PASSED---------------");
        }catch (Throwable e){
            status = false;
            log.info("---------------FAILED---------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);

        }
        return status;
    }
    protected boolean verifyFalse(boolean condition){
        boolean status = true;
        try{
            Assert.assertFalse(condition);
            log.info("---------------PASSED---------------");
        }catch (Throwable e){
            status = false;
            log.info("---------------FAILED---------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected boolean verifyEquals(Object actual, Object expected){
        boolean status = true;
        try{

            Assert.assertEquals(actual,expected);
            log.info("---------------PASSED---------------");
        }catch (Throwable e){
            status = false;
            log.info("---------------FAILED---------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected void closeBrowerDriver(){
        driver.quit();
    }

}
