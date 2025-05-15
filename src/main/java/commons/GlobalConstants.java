package commons;

import java.io.File;

public class GlobalConstants {
    //System Infor
    public final static String PROJECT_PATH=System.getProperty("user.dir");
    public final static String OS_NAME=System.getProperty("os.name");
    //public final static String RESOURCE_PATH=PROJECT_PATH+SEPARATOR+"resources"+SEPARATOR;


    //App infor user
    public final static String DEV_USER_URL="http://dev.techpanda.org/";
    public final static String STAGING_USER_URL="http://staging.techpanda.org/";
    public final static String LIVE_USER_URL="http://live.techpanda.org/";

    //App infor admin
    public final static String DEV_ADMIN_URL="http://dev.techpanda.org/index.php/backendlogin";
    public final static String STAGING_ADMIN_URL="http://staging.techpanda.org/index.php/backendlogin";
    public final static String LIVE_ADMIN_URL="http://live.techpanda.org/index.php/backendlogin";
    public final static String ORANGE_HRM_URL="http://localhost:90/orangehrm/orangehrm-5.7/web/index.php/auth/login";


    public final static String ADMIN_USERNAME="user01";
    public final static String ADMIN_PASSWORD="guru99com";

    //Wait infor
    public final static int SHORT_TIMEOUT=10;
    public final static int LONG_TIMEOUT=30;
    public final static int GLOBAL_TIMEOUT=15;

    //Download/ upload file
    public final static String SEPARATOR= File.separator;
    public final static String UPLOAD_PATH=PROJECT_PATH+SEPARATOR+ "uploadFiles"+SEPARATOR;
    public final static String DOWNLOAD_PATH=PROJECT_PATH+"/downloadFiles/";

    //Retry case fail
    public final static int RETRY_NUMBER=3;

    //Browser logs/extensions
    public final static String BROWSER_LOG_PATH=PROJECT_PATH+"/browserLogs/";
    public final static String BROWSER_EXTENSION_PATH=PROJECT_PATH+"/browserExtensions/";

    //html report folder
    public final static String REPORTING_PATH=PROJECT_PATH+ SEPARATOR+"htmlReportNG"+SEPARATOR;
    public final static String EXTENT_PATH=PROJECT_PATH+SEPARATOR+"test-output"+SEPARATOR+"html"+SEPARATOR;
    public final static String ALLURE_PATH=PROJECT_PATH+"/htmlAllure/";

    //Data test environment
    public final static String DATA_TEST_PATH=PROJECT_PATH+SEPARATOR+"src"+SEPARATOR+"test"+SEPARATOR+"resources"+SEPARATOR;
    public final static String ENVIRONMENT_CONFIG_PATH=PROJECT_PATH+"/environmentConfig/";

    //JIRA
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String JIRA_SITE_URL = "https://ngavu-automationtest.atlassian.net";
    public static final String JIRA_USERNAME = "ngavu190419@gmail.com";
    public static final String JIRA_API_KEY = "ATATT3xFfGF0j5WWg1SCS3KBAR4MIyQpanwISw9heBxT2k3xCEikZyy_2Ue9vJBgNWkfr3QcyGF3YqrTnUzwnn_YVT0gEiEchOLq0wQ9bpiFizdYyV5eFIHHryYk6uGzvSrGt6gjYFh3DQNs-8aw6gMGJFuRAscNjls14BMHvi11gMtxteLjnPA=D0DC9285";
    public static final String JIRA_PROJECT_KEY = "CA";
}
