package tpjazz;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PropertyFiles;
import utilities.writeData;

import com.sun.xml.txw2.Document;

public class TpJazzMain implements PathVariables {

	public static WebDriver driver;
	public static WebElement TestPlan;
	public static WebDriverWait wait;

	public static WebDriver loginToJazz() throws Exception {

		String jazzUsrName = PropertyFiles.globalPropertyFile("UserName");
		String jazzpwd = PropertyFiles.globalPropertyFile("Password");
		System.setProperty("webdriver.chrome.driver", "C:\\DO NOT DELETE\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://jazz.cerner.com:9443/qm/web/console/IP#action=com.ibm.rqm.planning.home.actionDispatcher&subAction=viewTestPlans");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(02000);
		driver.findElement(By.xpath(userName)).sendKeys(jazzUsrName);
		WebElement pwd = driver.findElement(By.xpath(passWord));
		pwd.sendKeys(jazzpwd);
		pwd.sendKeys(Keys.ENTER);
		//Thread.sleep(50000);
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(relatedSite)));
		System.out.println("Logged in Successfully");
		return driver;
	}

	public static void closeChrome() {

		driver.quit();
		System.out.println("Closed Browser");

	}

	public static void searchTP() throws InterruptedException, IOException, AWTException {

		String Solu = PropertyFiles.globalPropertyFile("Solution");
		String registrationManagementSolution = "//div[@title='" + Solu + "']";
		String SoluDetails = PropertyFiles.globalPropertyFile("SolutionDetails");
		String registrationManagemenSlutionDetailFilter = "//input[@aria-label='" + SoluDetails
				+ "' and @type='checkbox']";
		driver.findElement(By.xpath(planning)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(browseTP)).click();
		String tpName = PropertyFiles.globalPropertyFile("TestPlanName");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menuVisibility)));
		driver.findElement(By.xpath(serachTPTextBox)).sendKeys(tpName + Keys.ENTER);
		Thread.sleep(5000);
		TestPlan = driver.findElement(By.xpath(noTPAvailable));
		Boolean bool = TestPlan.isDisplayed();
		if (bool) {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Test Plan is not available");
			Thread.sleep(2000);
			driver.findElement(By.xpath(planning)).click();
			// creating a test plan if not available
			driver.findElement(By.xpath(createTPLink)).click();
			// wait until the new TP plan loads
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loadElementCreateTP)));
			// typing the test plan name
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(testPlanNameCreation)));
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(categoriesLabel)));
			Thread.sleep(1000);
			WebElement tpLink = driver.findElement(By.xpath(testPlanNameCreation));
			tpLink.click();
			tpLink.sendKeys(tpName);
			Thread.sleep(2000);
			// click on Solution
			driver.findElement(By.xpath(solutionFilter)).click();
			// select more in the option
			Select select = new Select(driver.findElement(By.id(solutionFilterDropdown)));
			Thread.sleep(2000);
			select.selectByVisibleText("More...");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchForSolutionFilter)));
			Thread.sleep(2000);
			driver.findElement(By.xpath(searchForSolutionFilter)).sendKeys(Solu);
			Thread.sleep(4000);
			// to select the solution from the box
			driver.findElement(By.xpath(registrationManagementSolution)).click();
			driver.findElement(By.xpath(okButtonSolutionFilter)).click();
			Thread.sleep(2000);

			// click solu details
			driver.findElement(By.xpath(solutionDetailFilter)).click();
			Thread.sleep(2000);
			try {
				boolean sDetailDropdown = driver.findElement(By.xpath("//td[text()= '" + SoluDetails + "' ]"))
						.isDisplayed();
				if (sDetailDropdown)

				{
					driver.findElement(By.xpath("//td[text()='" + SoluDetails + "']")).click();
				} else {
					driver.findElement(By.xpath("//td[text()='More...']")).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchForSolutionFilter)));
					Thread.sleep(2000);
					driver.findElement(By.xpath(searchForSolutionFilter)).sendKeys(SoluDetails);
					Thread.sleep(2000);
					driver.findElement(By.xpath(registrationManagemenSlutionDetailFilter)).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath(okButtonSolutionFilter)).click();
				}
			} catch (Exception e) {
				// TODO: handle exception
				driver.findElement(By.xpath("//td[text()='More...']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchForSolutionFilter)));
				Thread.sleep(2000);
				driver.findElement(By.xpath(searchForSolutionFilter)).sendKeys(SoluDetails);
				Thread.sleep(2000);
				driver.findElement(By.xpath(registrationManagemenSlutionDetailFilter)).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(okButtonSolutionFilter)).click();
			}
			Thread.sleep(3000);
			// click elsewhere for drop down to disappear
			driver.findElement(By.xpath(categoriesLabel)).click();
			Thread.sleep(3000);
			// enter the test type
			driver.findElement(By.xpath(testTypeFilter)).click();
			driver.findElement(By.xpath(systemTestTypeFilter)).click();
			Thread.sleep(3000);
			// click elsewhere for drop down to disappear
			driver.findElement(By.xpath(categoriesLabel)).click();
			Thread.sleep(3000);
			// enter the release
			String currRelease = PropertyFiles.globalPropertyFile("currentRelease");
			driver.findElement(By.xpath(releaseTextArea)).sendKeys(currRelease);
		} else {

			System.out.println("Test Plan " + tpName + " is Already Present");
			String selectTPLink = "//div[text()='" + tpName + "']";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectTPLink)));
			driver.findElement(By.xpath(selectTPLink)).click();
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(categoriesLabel)));
		}
	}

	public static void addTestCases() throws Exception {

		// get the number of rows from excel
		String path = PropertyFiles.globalPropertyFile("ExcelPath");
		String Sheet = PropertyFiles.globalPropertyFile("SheetName");
		int totalrows = readExcel.getRowCount(path, Sheet);
		int testCasecolNo = Integer.parseInt(PropertyFiles.globalPropertyFile("ExcelSheetTCColNum"));
		driver.findElement(By.xpath(testCasesLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addTestCaseIcon)));
		driver.findElement(By.xpath(addTestCaseIcon)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closeButtonTCAdd)));
		writeData.writeData1("***********List of Test Cases Not Added from Excel**********");
		int tcCount = 0;
		System.out.println(totalrows + "---num of rows in excel");
		for (int i = 1; i <= totalrows; i++) {
			String readingExcelData = readExcel.getExcelData(path, Sheet, i, testCasecolNo);
			WebElement textBoxTC = driver.findElement(By.xpath(typeTestCaseToAdd));
			textBoxTC.sendKeys(Keys.CONTROL + "a");
			textBoxTC.sendKeys(Keys.DELETE);
			textBoxTC.sendKeys(readingExcelData + Keys.ENTER);
			Thread.sleep(4000);
			// if the test case is already available

			// check for No items found
			try {

				boolean bool = driver.findElement(By.xpath(Noitemsfound)).isDisplayed();
				if (bool) {
					writeData.writeData1(readingExcelData);
					System.out.println(readingExcelData + "-->test case already added");
				} else {
					try {

						boolean bool2 = driver.findElement(By.xpath("//div[text()='" + readingExcelData + "']"))
								.isDisplayed();
						if (bool2 == true) {
							driver.findElement(
									By.xpath("(//div[text()='" + readingExcelData + "']/ancestor::tr)[3]/td[1]/span"))
									.click();
							Thread.sleep(3000);
							driver.findElement(By.xpath(addButtonToTC)).click();
							tcCount = tcCount + 1;
						} else {
							writeData.writeData1(readingExcelData);
							System.out.println(readingExcelData + "-->test case already added");
						}
					} catch (Exception e1) {
						writeData.writeData1(readingExcelData);
						System.out.println(readingExcelData + "-->test case already added");
					}
				}
			} catch (Exception e) {
				try {
					boolean bool2 = driver.findElement(By.xpath("//div[text()='" + readingExcelData + "']"))
							.isDisplayed();
					System.out.println(bool2 + "second try");
					if (bool2 == true) {
						driver.findElement(
								By.xpath("(//div[text()='" + readingExcelData + "']/ancestor::tr)[3]/td[1]/span"))
								.click();
						Thread.sleep(3000);
						driver.findElement(By.xpath(addButtonToTC)).click();
						tcCount = tcCount + 1;
					} else {
						writeData.writeData1(readingExcelData);
						System.out.println(readingExcelData + "-->test case already added");
					}
				} catch (Exception e1) {
					writeData.writeData1(readingExcelData);
					System.out.println(readingExcelData + "-->test case already added");
				}

			}

		}

		Thread.sleep(2000);
		// close after adding
		driver.findElement(By.xpath(closeButtonTC)).click();
		Thread.sleep(2000);
		// return tcCount
		writeData.writeData1("*********Number of test cases added*********");
		String testCaseCount = Integer.toString(tcCount);
		writeData.writeData1(testCaseCount);

	}

	public static void getTPID() throws Exception {

		WebElement Element = driver.findElement(By.xpath(TPIDPath));
		writeData.writeData1("*********TestPlan ID*********");
		System.out.println(Element.getAttribute("innerText") + "-->TestPlan ID by innerText");
		writeData.writeData1(Element.getAttribute("innerText"));
	}

	public static void logoutFromJazz() throws InterruptedException, AWTException {
		WebElement Trial = driver.findElement(By.xpath(userProfile));
		Trial.click();
		Thread.sleep(3000);
		Robot Rob = new Robot();
		Rob.keyPress(KeyEvent.VK_UP);
		Rob.keyPress(KeyEvent.VK_ENTER);
		Rob.keyRelease(KeyEvent.VK_UP);
		Rob.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void main(String[] args) throws Exception {

		TpJazzMain.loginToJazz();
		writeData.deleteContents();
		TpJazzMain.searchTP();
		TpJazzMain.addTestCases();
		// saving the test plan
		driver.findElement(By.xpath(saveButtontoTP)).click();
		Thread.sleep(5000);
		WebElement Element = driver.findElement(By.xpath(TPIDPath));
		String TPID = Element.getAttribute("innerText");
		TpJazzMain.getTPID();
		TpJazzMain.logoutFromJazz();
		Thread.sleep(2000);
		TpJazzMain.closeChrome();
		String toMailId = PropertyFiles.globalPropertyFile("ToEmailId");
		String fromMailId = PropertyFiles.globalPropertyFile("FromEmailID");
		String Solu = PropertyFiles.globalPropertyFile("Solution");
		SendMail.ReportViaMail(toMailId, fromMailId, Solu, TPID, "C:\\DO NOT DELETE\\Composition.txt");

	}

}
