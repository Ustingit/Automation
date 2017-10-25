package com.curaesoft.qa.selenium.tests;
import com.curaesoft.qa.selenium.Config.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;


public class LoginPageTest extends BaseWebDriver {
	HomePage homePage;
	Boolean result;
	Boolean success = true;
	@BeforeMethod
	public void login() {

		try {
			homePage = this.loginPage.login("intake");

		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Failed to login into the application !");
		}
	}


	@Test (priority= 0)

	public void verifyUserLoggedin() {
		try {
			result = this.loginPage.userInfo();
			Assert.assertTrue(result);
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Failed to login into the application");
		}
	}

	@AfterMethod
	public void logout() {
		try {
			if(Constant.Debugging == false ){
				if(success){
					result = this.loginPage.logout();
					Assert.assertTrue(result);
				}
			}
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Failed to login into the application");
		}
	}
}
