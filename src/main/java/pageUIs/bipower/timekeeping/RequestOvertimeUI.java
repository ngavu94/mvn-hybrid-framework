package pageUIs.bipower.timekeeping;

public class RequestOvertimeUI {
    public static final String REQUEST_CODE_TEXTBOX = "//input[@placeholder='Enter request code']";
    public static final String PROJECT_DROPDOWN = "//label[text()='Project name']/following-sibling::div//input";
    public static final String PROJECT_ITEM_BY_NAME = "//div[text()='%s']";
    public static final String OVERTIME_REASON_TEXTAREA = "//textarea[@placeholder='Enter overtime reason']";
    public static final String START_DATE_TEXTBOX = "//input[@placeholder='15/05/2025']";
    public static final String FROM_TIME_TEXTBOX = "(//input[contains(@placeholder,':')])[1]";
    public static final String TO_TIME_TEXTBOX = "(//input[contains(@placeholder,':')])[2]";
    public static final String JIRA_LINK_TEXTBOX = "//input[@placeholder='Nhập đường dẫn Jira']";
    public static final String SAVE_BUTTON = "//button[normalize-space()='Save']";
}
