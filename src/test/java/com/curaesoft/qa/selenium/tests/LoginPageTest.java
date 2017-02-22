package com.curaesoft.qa.selenium.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;


public class LoginPageTest extends BaseWebDriver {
	HomePage homePage;
	Boolean result;

	@BeforeMethod
	public void login() {

		try {
			homePage = this.loginPage.login("qa");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to login into the application !");
		}
	}

//	@Test
//	public void TestLogin() {
//		LoginPage page = new LoginPage();
//		page.execute();
//	}

	@Test
	public void verifyUserLoggedin() {
		try {
			result = this.loginPage.userInfo();
			Assert.assertTrue(result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to login into the application");
		}
	}

	@AfterMethod
	public void logout() {
		try {
			result = this.loginPage.logout();
			Assert.assertTrue(result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to login into the application");
		}
	}
}
