package tpjazz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface PathVariables {
	
	
	public static String userName = "//input[@name='j_username']";
	public static String passWord = "//input[@name='j_password']";
	public static String relatedSite = "//span[text()='Related Sites']";
	public static String planning = "//a[@title='Planning']";
	public static String browseTP = "//span[text()='Browse Test Plans']";
	public static String serachTPTextBox = "//input[@class='filter-text-input-disabled']";
	public static String menuVisibility = "//div[@class='view-left-header']";
	public static String noTPAvailable = "//div[text()='No items match the current filter criteria.']";
	public static String createTPLink = "//span[text()='Create Test Plan']";
	public static String loadElementCreateTP = "(//div[text()='New / Not Yet Saved'])[1]";  //check
	public static String testPlanNameCreation = "//textarea[@id='com_ibm_asq_common_web_ui_internal_widgets_TitleTextAreaEditor_0']";
	public static String solutionFilter = "//div[@class='outer-wrapper-div styled-select']";
	public static String solutionFilterDropdown = "com_ibm_asq_common_web_ui_internal_widgets_selector_TruncatedSelect_0";
	public static String searchForSolutionFilter = "//input[@placeholder='Type to Search']";
	public static String okButtonSolutionFilter = "//button[@class='primary-button']";
	public static String solutionDetailFilterDropDown="com_ibm_asq_common_web_ui_internal_widgets_layout_DropDownButton_0_label";
	public static String solutionDetailFilter = "(//div[@class='toggle-edit-closed']/div[text()='Unassigned'])[1]";
	public static String testTypeFilter = "(//div[@class='toggle-edit-closed']/div[text()='Unassigned'])[1]";
	public static String systemTestTypeFilter = "//td[text()='System']";
	public static String releaseTextArea = "//textarea[@name='myarea']";
	public static String categoriesLabel = "//label[@class='field-label section-attr-label']";
	public static String testCasesLink = "//a[@title='Test Cases']";
	public static String addTestCaseIcon = "//img[@class='button-img add-icon-image']";
	public static String closeButtonTCAdd = "//button[@class='non-primary-button']";
	public static String typeTestCaseToAdd = "(//input[@class='dijitReset dijitInputInner'])[2]";
	public static String addTestCaseButton= "//button[text()='Add']";
	public static String closeAdditionTestCaseButton = "//button[text()='Close']";
	public static String addButtonToTC = "//button[text()='Add']";
	public static String closeButtonTC = "//button[text()='Close']";
	public static String saveButtontoTP = "//button[@title='Save']";
	public static String Noitemsfound = "(//div[text()='No items found.' and @class='table-message'])[2]";
	public static String userProfile = "//span[@class='sprite-image user-menu']";
    public static String TPIDPath = "//div[@dojoattachpoint='titleOutterContainerNode']";
    
    //public static String noItemsFoundTC = "//div[text()='No items found.' and @class='table-message']";
}
