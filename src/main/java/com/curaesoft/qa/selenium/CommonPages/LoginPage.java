package com.curaesoft.qa.selenium.CommonPages;

import com.curaesoft.qa.selenium.lib.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.curaesoft.qa.selenium.Config.Constant;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;

import java.util.concurrent.TimeUnit;

public class LoginPage {
	public WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id='email']")
	public WebElement userName;

	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//div[@id='ui-login']/div/div/md-card/md-content/form/button")
	public WebElement login;

	@FindBy(how = How.XPATH, using = "//md-menu/button")
	public WebElement menuDropDown;

	@FindBy(how = How.XPATH, using = "//md-backdrop")
	public WebElement menuBackDrop;

	String uName;
	String pswd;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage login(String role) {
		try {
			String excelPath = this.getClass().getClassLoader().getResource(Constant.File_TestData).getPath();
			ExcelUtils.setExcelFile(excelPath, Constant.excelSheetName);
			if (role.equals(Constant.QA_ROLE)) {
				uName = ExcelUtils.getCellData(1, 0);
				pswd = ExcelUtils.getCellData(1, 1);
			} else if (role.equals(Constant.CLINICIAN_ROLE)) {
				uName = ExcelUtils.getCellData(2, 0);
				pswd = ExcelUtils.getCellData(2, 1);
			} else if (role.equals(Constant.MANAGER_ROLE)) {
				uName = ExcelUtils.getCellData(3, 0);
				pswd = ExcelUtils.getCellData(3, 1);
			} else {
				Reporter.log("Role not available");
				return null;
			}
		} catch (Exception e) {
			Reporter.log("No role selected");
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(userName));
			userName.sendKeys(uName);
			password.sendKeys(pswd);
		} catch (Exception e) {
			Reporter.log("Failed to enter the username and password  in the login page");
		}
		/**
		 * Click Login Method is invoked
		 */
		clickLogin();
		Reporter.log("The test user logged in is " + uName);
		return PageFactory.initElements(driver, HomePage.class);
	}

	/**
	 * Method to Click Login
	 */
	public void clickLogin() {
		try {
			login.click();
			Thread.sleep(6000);
		} catch (Exception e) {
			Reporter.log("Failed to click on the login button on login page");
		}
	}

	/**
	 * Method to invoke logout simulation
	 * 
	 */
	public boolean logout() {
		try {
			menuDropDown.click();
			driver.findElement(By.linkText("Logout")).click();
		} catch (Exception e) {
			Reporter.log("Failed to logout from the application");
		}
		return true;
	}

	/**
	 * Method to invoke logout simulation
	 * 
	 */
	public boolean userInfo() {
		try {
			driver.getPageSource().contains("Welcome");
		} catch (Exception e) {
			Reporter.log("Failed to logout from the application");
		}
		return true;
	}
	public static void main(String[] args) {
		Utility xcel = new Utility();

		Constant data= new Constant();
		String exePath = "driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(data.webURL);

		try {
			xcel.reader(driver,"resources/login.xlsx");
		} catch (Exception e) {
			xcel.close(driver);
			e.printStackTrace();
		}


	}
}
