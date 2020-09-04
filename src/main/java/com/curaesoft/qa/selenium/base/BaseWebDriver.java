package com.curaesoft.qa.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.curaesoft.qa.selenium.CommonPages.LoginPage;
import com.curaesoft.qa.selenium.Config.Constant;
import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.ChromeDriverManager;
//import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.Dimension;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class BaseWebDriver {
	protected WebDriver driver;
	protected LoginPage loginPage;

	@BeforeClass
	public void setUp() {

		if (Constant.browserType.equals("*firefox")) {
//			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
		}else if (Constant.browserType.equals("*chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-gpu");
//			WebDriverManager.chromedriver().version("83");
			WebDriverManager.chromedriver().setup();
//			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		}

		driver.get(Constant.webURL);
		if(Constant.width != 0 && Constant.height !=0){
			driver.manage().window().setSize(new Dimension(Constant.width,Constant.height));

		}else{
			driver.manage().window().maximize();
		}
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	@AfterClass
	public void tearDown() {
		if (Constant.Debugging == false){
			driver.close();
		}

	}
}
