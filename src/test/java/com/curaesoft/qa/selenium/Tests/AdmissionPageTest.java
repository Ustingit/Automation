package com.curaesoft.qa.selenium.Tests;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.curaesoft.qa.selenium.lib.Utility;
/**
 * Created by SE on 2/17/2017.
 */
public class AdmissionPageTest  extends BaseWebDriver {
    HomePage homePage;
    Boolean result;

    @BeforeMethod(alwaysRun = true)
    public void login() {

        try {
            homePage = this.loginPage.login("Intake");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }

    @Test
    public void createAdmission() {
        Utility page = new Utility();
        page.execute(this.driver, "resources/admission.xlsx");
    }

    @AfterMethod(alwaysRun = true)
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
