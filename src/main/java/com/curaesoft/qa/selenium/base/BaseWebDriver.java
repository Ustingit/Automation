package com.curaesoft.qa.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.curaesoft.qa.selenium.CommonPages.LoginPage;
import com.curaesoft.qa.selenium.Config.Constant;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class BaseWebDriver {
	protected WebDriver driver;
	protected LoginPage loginPage;

	@BeforeClass
	public void setUp() {
		if (Constant.browserType.equals("*firefox")) {
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
		}else if (Constant.browserType.equals("*chrome")) {
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
		}
		driver.get(Constant.webURL);
		driver.manage().window().maximize();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
