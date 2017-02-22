package com.curaesoft.qa.selenium.tests;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by SE on 2/22/2017.
 */
public class ProfilePageTest extends BaseWebDriver {
    HomePage homePage;
    Boolean result;

    @BeforeClass
    public void login() {

        try {
            homePage = this.loginPage.login("qa");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }

    @Test
    public void UpdateSettings() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "resources/profile.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }


    }


    @AfterClass
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
